package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.pythonmodels.PythonResponse;
import com.pinnoserv.portal.service.FileDataService;
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

    @PostMapping("/upload")
    public ApiResponse uploadImageToFileSystem(@RequestParam("image")MultipartFile file) throws IOException {
        log.info("My Multipart file upload new is :: ", file);
        return fileDataService.uploadImageToFileSystem(file);
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
