package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.DataSourceById;
import com.pinnoserv.portal.custommodels.apiresponsedto.DataSourceGetAll;
import com.pinnoserv.portal.entity.DataSource;
import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.repositories.DataSourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Slf4j
@Service
public class DataSourceServiceImpl implements DataSourceService{
    ApiResponse apiResponse = new ApiResponse();
    @Autowired
    DataSourceRepository dataSourceRepository;
    @Override
    public ApiResponse findById(DataSource dataSource) {

        DataSource dataSourceResponse = null;
        try {
            Long id = dataSource.getId();
            if(dataSourceRepository.existsById(id)) {
                dataSourceResponse = dataSourceRepository.findById(id).get();
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DATA_SOURCE_FETCHED);
                apiResponse.setEntity(dataSourceResponse);
                return apiResponse;
            }
            if(!dataSourceRepository.existsById(id)){
                dataSourceRepository.deleteById(id);
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DATA_SOURCE_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(DATA_SOURCE_NOT_EXIST);
        apiResponse.setEntity(null);
        return apiResponse;
    }

    @Override
    public ApiResponse findAll() {
        List<DataSource> listDatasource = null;
        try {
            listDatasource = dataSourceRepository.findAll();
            if(listDatasource != null){
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DATA_SOURCE_ALL_FETCHED);
                apiResponse.setEntity(listDatasource);
                return apiResponse;
            }
        } catch (Exception e) {
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(DATA_SOURCE_NOT_EXIST);
        apiResponse.setEntity(null);
        return apiResponse;
    }

    @Override
    public ApiResponse createDataSource(DataSource dataSource) {
        try {
            log.info("Begin Create Datasource Service");
                DataSource createDatasource = DataSource.builder()
                        .name(dataSource.getName())
                        .dataSourceUrl(dataSource.getDataSourceUrl())
                        .dateCreated(LocalDateTime.now())
                        .inTrash("No")
                        .excelUrl(dataSource.getExcelUrl())
                        .dataSourceType(dataSource.getDataSourceType())
                        .dataUsage(dataSource.getDataUsage())
                        .status(dataSource.getStatus())
                        .action(dataSource.getAction())
                        .excelPath(dataSource.getExcelPath())
                        .expiry(dataSource.getExpiry())
                        .kycId(dataSource.getKycId())
                        .maxApprovals(dataSource.getMaxApprovals())
                        .approvalStatus(dataSource.getApprovalStatus())
                        .approvalLevel(dataSource.getApprovalLevel())
                        .updateCycle(dataSource.getUpdateCycle())
                        .scoringDataSize(dataSource.getScoringDataSize())
                        .organisationIdFk(dataSource.getOrganisationIdFk())
                        .build();
                dataSourceRepository.save(createDatasource);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DATA_SOURCE_CREATED);
                apiResponse.setEntity(null);
                return apiResponse;

        }catch (Exception e){
            throw new RuntimeException(e);
//            apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
//            apiResponse.setResponseDescription(DATA_SOURCE_NOT_CREATED);
//            apiResponse.setEntity(null);
//            return apiResponse;
        }

    }

    @Override
    public ApiResponse updataDataSource(DataSource dataSource) {
        DataSource updateDataSource = null;
        try {

            Long id = dataSource.getId();
            if (dataSourceRepository.existsById(id)) {

                DataSource dbDataSource = dataSourceRepository.findById(id).get();

                String name = dataSource.getName();
                String dataSourceUrl = dataSource.getDataSourceUrl();
                String excelUrl = dataSource.getExcelUrl();
                String dataSourceType = dataSource.getDataSourceType();
                String dataUsage = dataSource.getDataUsage();
                int status = dataSource.getStatus();
                String action = dataSource.getAction();
                String excelPath = dataSource.getExcelPath();
                String expiry = dataSource.getExpiry();
                int kycId = dataSource.getKycId();
                int maxApprovals = dataSource.getMaxApprovals();
                int approvalStatus = dataSource.getApprovalStatus();
                int approvalLevel = dataSource.getApprovalLevel();
                int updateCycle = dataSource.getUpdateCycle();
                int scoringDataSize = dataSource.getScoringDataSize();



                if (!name.isEmpty() && !name.equalsIgnoreCase(dbDataSource.getName())) {
                    dbDataSource.setName(name);
                }
                if (!dataSourceUrl.isEmpty() && !dataSourceUrl.equalsIgnoreCase(dbDataSource.getDataSourceType())) {
                    dbDataSource.setName(dataSourceUrl);
                }
                if (!excelUrl.isEmpty() && !excelUrl.equalsIgnoreCase(dbDataSource.getExcelUrl())) {
                    dbDataSource.setExcelUrl(excelUrl);
                }
                if (!dataSourceType.isEmpty() && !dataSourceType.equalsIgnoreCase(dbDataSource.getDataSourceType())){
                    dbDataSource.setExcelUrl(dataSourceType);
                }
                if (!excelPath.isEmpty() && !excelPath.equalsIgnoreCase(dbDataSource.getExcelPath())){
                    dbDataSource.setExcelPath(excelPath);
                }
                if (!expiry.isEmpty() && !expiry.equalsIgnoreCase(dbDataSource.getExpiry())){
                    dbDataSource.setExpiry(expiry);
                }
                if (!dataUsage.isEmpty() && !dataUsage.equalsIgnoreCase(dbDataSource.getDataUsage())){
                    dbDataSource.setDataUsage(dataUsage);
                }
                if (status != 0 && status != dbDataSource.getStatus()){
                    dbDataSource.setStatus(status);
                }
                if (!action.isEmpty() && !action.equalsIgnoreCase(dbDataSource.getAction())){
                    dbDataSource.setAction(action);
                }
                if (kycId != 0 && kycId != dbDataSource.getKycId()){
                    dbDataSource.setKycId(kycId);
                }
                if (maxApprovals != 0 && maxApprovals != dbDataSource.getMaxApprovals()){
                    dbDataSource.setMaxApprovals(maxApprovals);
                }
                if (approvalStatus != 0 && approvalStatus != dbDataSource.getApprovalStatus()){
                    dbDataSource.setApprovalStatus(approvalStatus);
                }
                if (approvalLevel != 0 && approvalLevel != dbDataSource.getApprovalLevel()){
                    dbDataSource.setApprovalLevel(approvalLevel);
                }
                if (updateCycle != 0 && updateCycle != dbDataSource.getUpdateCycle()){
                    dbDataSource.setUpdateCycle(updateCycle);
                }
                if (scoringDataSize != 0 && scoringDataSize != dbDataSource.getScoringDataSize()){
                    dbDataSource.setScoringDataSize(scoringDataSize);
                }

                updateDataSource = dataSourceRepository.save(dbDataSource);

                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DATA_SOURCE_UPDATED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;

            }
            if(!dataSourceRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DATA_SOURCE_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            apiResponse.setResponseCode(SUCCESS_RESPONSE);
            apiResponse.setResponseDescription(DATA_SOURCE_UPDATED_SUCCESSFULLY);
            apiResponse.setEntity(null);
            return apiResponse;
    }

    @Override
    public ApiResponse deleteDataSource(DataSource dataSource) {
        try{
            Long id = dataSource.getId();
            if(dataSourceRepository.existsById(id)){
            dataSourceRepository.deleteById(id);

                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DATA_SOURCE_DELETED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!dataSourceRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DATA_SOURCE_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DATA_SOURCE_NOT_DELETED);
                apiResponse.setEntity(null);
                return apiResponse;
    }
}
