package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.service.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class FileDataController {
    @Autowired
    private FileDataService fileDataService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = fileDataService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData = fileDataService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .body(imageData);
    }
}
