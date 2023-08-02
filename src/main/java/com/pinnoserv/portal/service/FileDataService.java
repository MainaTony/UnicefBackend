package com.pinnoserv.portal.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileDataService {
    String uploadImageToFileSystem(MultipartFile file);
    String downloadImageFromFileSystem(String url);
}
