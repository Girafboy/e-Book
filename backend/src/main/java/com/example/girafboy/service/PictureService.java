package com.example.girafboy.service;

import com.example.girafboy.entity.Picture;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
    Boolean upload(MultipartFile multipartFile, Integer bookName);
    byte[] getPictureBlob(String id);
}
