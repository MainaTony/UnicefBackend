package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.pythonmodels.PythonResponse;
import com.pinnoserv.portal.entity.FileData;
import com.pinnoserv.portal.entity.StatementReport;
import com.pinnoserv.portal.repositories.FileDataRepository;
import com.pinnoserv.portal.repositories.StatementReportRepository;
import com.pinnoserv.portal.service.FileDataService;
import com.pinnoserv.portal.service.FileDataServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/image")
@Slf4j
public class FileDataController {
    @Autowired
    private FileDataService fileDataService;
    @Autowired
    StatementReportRepository statementReportRepository;

    @PostMapping("/upload")
    public String uploadImageToFileSystem(@RequestParam("image")MultipartFile file) throws IOException {
        log.info("My Multipart file upload new is :: ", file);
        fileDataService.uploadImageToFileSystem(file);
        return "File updated Successfully";
    }

    @PostMapping("/allFiles")
    public ApiResponse getAllProcessedFiles(){
        return fileDataService.getAllStatementReports();
    }

    @PostMapping("/responsePayload/{id}")
    public StatementReport getAReport(@PathVariable Long id){
        StatementReport statementReport = statementReportRepository.findById(id).get();
        return statementReport;
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData = fileDataService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .body(imageData);
    }

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFiles(@RequestParam("files")MultipartFile multipartFiles) throws IOException {
//        log.info("My multipart is :: {}", multipartFiles);
//        String filename = fileDataService.uploadFile(multipartFiles);
//        return ResponseEntity.ok().body(filename);
//    }
}

//  You cannot control the mind with te mind. If we are in a relaxed/happy state, we can make choices that are reasonable, manuevure our environment, but most of the times we are not in a relaxed and happy  state
//  The autonomic nervous system. nervous system that regulates involuntary physiologic processes including heart rate, blood pressure, respiration, digestion, and sexual arousal. It contains three anatomically distinct divisions: sympathetic, parasympathetic, and enteric.
//  The autonomic nervous system || The components of your nervous system that raise your alertness or bring them way down. responsible for Fight or flight
//  When we are at the extremes of the autonomic system e.g when we are very alert or really stressed, concerned or we are really close to sleeping/ exhausted etc. At This points our thoughts become a runaway train. Its ard to talk your way out of this points or even its hard to think your way out of this points. You are nt rational. The thing you do is you can call someone. ts hard to get out of this situations with 'Thinking alone'
//  The beauty of the autonomic nervous system is that it traverses the brain and the body and it connects to all the organs in the body. Certain behaviours even certain patterns of breathing allow us to shift where we are on the autonomic continu/scale (between very alert and very calm) thereby give our mind a shift also in terms of the kinds of thoughts we can entertain, sort of actions we can engage in.
//  If your very upset, it is very difficult to take your mind off whatever it is that is upsetting you. And also if you are feeling anxious and you dont know why, it is difficult to remove your feelings off the feeling of anxiety.
//  In that state, you always feel as if that state will go on forever
//  When we tap in into the body we are able to move ourselves up the autonomic continoum and at that point we are able to think thigs differently and we start to get a sense that the way we feel might not be the way we are going to feel forever and it is in those shifts that you realise that your mind is not your best friend in those extrem scenarios
//  If you cant control the mind with the mind, look to the body to control the mind
//  Example: Stress, Panic, Anxiety [All this include high level of alertness, high levels of awareness]
//  When stressed several things happen :  Our heart rate Quickens, pupils get big[you see things through a small aperture, you cannot see things in your periphery], Fuel from our muscles and lungs is shuttled/transported to particular organs in the body and away from others i.e fuel shuttled to bigger muscles in the body to generate large movements, Thats why we quack/hands start shaking when we are stressed
//  When stressed, Heart rate then readiness for action/quack. Your hands shake because the body wants to move but it cant move and it can't move
//  Glucose is transported to the muscles and  from the reproductive system and the digestive system and transported to organs and the other organs
//  Glucose is transported to the muscles and removed from the reproductive system, the digestive system because it is not the right time for them at this point by this systems.
//
//
//
//
//
//
