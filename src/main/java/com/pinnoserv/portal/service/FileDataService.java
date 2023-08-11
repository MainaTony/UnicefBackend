package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.pythonmodels.PythonResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileDataService {
    ApiResponse uploadImageToFileSystem(MultipartFile file) throws IOException;
    byte[] downloadImageFromFileSystem(String url) throws IOException;

    String uploadFile(MultipartFile file) throws IOException;
}
