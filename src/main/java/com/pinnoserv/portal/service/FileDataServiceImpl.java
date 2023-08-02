package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.FileData;
import com.pinnoserv.portal.repositories.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileDataServiceImpl implements FileDataService{
    @Autowired
    private FileDataRepository fileDataRepository;
    private final String FOLDER_PATH = "/c/Users/user/Desktop/statements";

    @Override
    public String uploadImageToFileSystem(MultipartFile file) {
        String filePath = FOLDER_PATH+file.getOriginalFilename();
        FileData fileData = FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imagePath(filePath)
                .build();
        fileDataRepository.save(fileData);
        if(fileData != null){
            return "File Uploaded Successfully" + file.getOriginalFilename();
        }
        return null;
    }

    @Override
    public String downloadImageFromFileSystem(String url) {
        return null;
    }
}
