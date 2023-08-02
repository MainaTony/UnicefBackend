package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.FileData;
import com.pinnoserv.portal.repositories.FileDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
@Slf4j
public class FileDataServiceImpl implements FileDataService{
    @Autowired
    private FileDataRepository fileDataRepository;
    private final String FOLDER_PATH = "C:\\Users\\user\\Desktop\\statements\\";

    @Override
    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        log.info("Begin the Upload service");
        String filePath = FOLDER_PATH+file.getOriginalFilename();
        log.info("My File Path {}", filePath);
        FileData fileData = FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imagePath(filePath)
                .build();
        fileDataRepository.save(fileData);
        file.transferTo(new File(filePath));
        if(fileData != null){
            return "File Uploaded Successfully : My File Name is = " + file.getOriginalFilename();
        }
        return null;
    }

    @Override
    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath = fileData.get().getImagePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}
