package com.pinnoserv.portal.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileDataService {
    String uploadImageToFileSystem(MultipartFile file) throws IOException;
    byte[] downloadImageFromFileSystem(String url) throws IOException;
}
