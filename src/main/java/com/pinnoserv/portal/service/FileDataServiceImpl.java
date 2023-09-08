package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.pythonmodels.PythonResponse;
import com.pinnoserv.portal.custommodels.responseutils.ResponseUtil;
import com.pinnoserv.portal.entity.FileData;
import com.pinnoserv.portal.entity.Image;
import com.pinnoserv.portal.entity.StatementReport;
import com.pinnoserv.portal.repositories.FileDataRepository;
import com.pinnoserv.portal.repositories.StatementReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.DIRECTORY;

@Service
@Slf4j
@EnableScheduling
public class FileDataServiceImpl implements FileDataService{

    @Autowired
    private FileDataRepository fileDataRepository;
    @Autowired
    private StatementReportRepository statementReportRepository;
    private final WebClient webClient;
    ApiResponse fileApiResponse = new ApiResponse();
    public FileDataServiceImpl(WebClient webClient){
        this.webClient = webClient;

    }
    private final String FOLDER_PATH = "C:\\Users\\user\\Desktop\\statements\\";

    @Override
    public void uploadImageToFileSystem(MultipartFile file) throws IOException {
//        Start saving the file in the db
        log.info("Begin the Upload service");
        String filePath = FOLDER_PATH+file.getOriginalFilename();
        log.info("My File Path {}", filePath);
        String customFilePath = DIRECTORY+file.getOriginalFilename();
        log.info("{}",customFilePath);

        FileData fileData = FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imagePath(filePath)
                .status(ResponseUtil.SUCCESSFUL_FILE_UPLOAD_STATUS)
                .build();
        fileDataRepository.save(fileData);
        file.transferTo(new File(filePath));
//        End of saving the file in the db
    }
    @Scheduled(fixedDelay = 30000)
    public void processStatement()  {

//        Start the Scheduler
        PythonResponse payload = null;
//        Search for all the files in the db
        List<FileData> allFiles = fileDataRepository.findAll();
//        Loop through files in the db
        for(int i=0; i<fileDataRepository.findAll().size(); i++){
//            The instance of statement A that has been selected
            FileData fileData = allFiles.get(i);
//            Get status code of statement A
            if(fileData.getStatus() == 0){
//                Change the status of statement A to 2, initiating the scoring analysis from the spring boot application
//                FileData fileDataScoreEngine = fileDataRepository.findById(fileData.getId()).get();
                fileData.setStatus(ResponseUtil.PROCESSING_SCORING_ENGINE_FILE_UPLOAD_STATUS);
//                Initiate scoring process of statement A, initiate Call to python Micro service
                payload = webClient.get()
                    .uri("http://127.0.0.1:8000/analysis/?url="+fileData.getImagePath())
                    .retrieve()
                    .bodyToMono(PythonResponse.class)
                    .block();
//                After Python Micro service is done on statement A, a "response" payload is sent back to the spring boot service
//                Check if "response" is null or "response" payload is present
//                Response payload is null
                if (payload.paidIn == null && payload.paidOut == null){
                    log.info("Processing Unsuccessful");
                    fileData.setStatus(ResponseUtil.ERROR_FILE_UPLOAD_STATUS);
                }
//                Response Payload is present
                log.info("Processing Successful");
//                Update the status of statement A again to status 3, meaning processing of the file was successful
                fileData.setStatus(ResponseUtil.SUCCESSFUL_IN_PROCESSING_SCORING_ENGINE_FILE_UPLOAD_STATUS);
//                Save the status of statement A status
                fileDataRepository.save(fileData);
//                Map the response payload to the "StatementReport" entity
                StatementReport mpesaReport = StatementReport.builder()
                .agentDeposit(payload.paidIn.agentDeposit)
                .customersReceived(payload.paidIn.customesRecieved)
                .paybillBanks(payload.paidIn.paybillBanks)
                .fulizaReceived(payload.paidIn.fulizaRecieved)
                .paybillBetting(payload.paidIn.paybillBeting)
                .paybillLenders(payload.paidIn.paybillLenders)
                .paybillOthers(payload.paidIn.paybillOthers)
                .paidOutPaybillOthers(payload.paidIn.paybillOthers)
                .paidOutCustomersSent(payload.paidOut.customersSent)
                .paidOutAgentWithdraw(payload.paidOut.agentWithdraw)
                .paidOutOthers(payload.paidOut.others)
                .paidOutBuyGoods(payload.paidOut.buyGoods)
                .paidOutBanks(payload.paidOut.banks)
                .paidOutUtilities(payload.paidOut.utilities)
                .paidOutFulizaPaid(payload.paidOut.fulizaPaid)
                .paidOutOnlinePurchases(payload.paidOut.onlinePurchases)
                .paidOutBetting(payload.paidOut.betting)
                .paidOutMobileLenders(payload.paidOut.mobileLenders)
                .build();
//                Once mapping is done, save the response payload/statement report entity to the database
        statementReportRepository.save(mpesaReport);
        log.info("My Payload Response Report is: {}", mpesaReport);
//        Change the status of statement A, to 3, meaning it has been successfully saved to the database
                fileData.setStatus(4);
//                Attach the response payload of statement A, to statement A path
//                FileData fileDataDb = fileDataRepository.findById(fileData.getId()).get();
//                StatementReport statementReport = statementReportRepository.
                fileData.setStatementReport(mpesaReport);
                StatementReport statementReport = statementReportRepository.findById(fileData.getId()).get();
                fileData.setStatementReport(statementReport);
//                fileData.setStatementReport().add();
//                mpesaReport
//                fileData.setStatementReport(fileDataRepository.findById(fileData.getId()));
//                Save the new instance of statement A(now with statement analysis response) to the database
        fileDataRepository.save(fileData);
            }
        }
    }

    //    fixedDelayString = "PT15M"
//    @Scheduled(fixedDelay = 2000)
//    public void runAfter2Seconds(){
//        List<FileData> fileDataScoreEngine = fileDataRepository.findAll();
//        fileDataScoreEngine.toArray();
//
//        if(!fileDataScoreEngine.isEmpty()){
//            for(int x=0; x<fileDataScoreEngine.size(); x++){
//                if(fileDataScoreEngine.get(x).getStatus() == 0){ fi
//
//                }
//            }
//        }
//        log.info("I will run after every 2 seconds");
//    }

    @Override
    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath = fileData.get().getImagePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        log.info("Begin the Upload service");

        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        String filePath = FOLDER_PATH+file.getOriginalFilename();
        log.info("My File Path {}", filePath);
        String customFilePath = DIRECTORY+file.getOriginalFilename();
        log.info("{}",customFilePath);

        FileData fileData = FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imagePath(filePath)
                .build();
        fileDataRepository.save(fileData);
        file.transferTo(new File(filePath));
        return file.getOriginalFilename();
    }

    @Override
    public ApiResponse getAllStatementReports() {
        ApiResponse apiResponse = new ApiResponse<>();
        List<FileData> fileData = fileDataRepository.findAll();
        if(fileData.isEmpty()){
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Files Fetched Successfully");
            apiResponse.setEntity(null);
        }
        apiResponse.setResponseCode("00");
        apiResponse.setResponseDescription("Files Fetched Successfully");

        apiResponse.setEntity(fileData);

        return apiResponse;
    }
}
