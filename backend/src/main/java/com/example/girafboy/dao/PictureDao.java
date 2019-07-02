package com.example.girafboy.dao;

import com.example.girafboy.entity.Picture;
import org.bson.types.Binary;

public interface PictureDao {
    Picture findById(String id);
    Picture addPicture(String name, Binary content, String contentType, long size);
}
