package com.example.girafboy.dao;

import com.example.girafboy.entity.Picture;

public interface PictureDao {
    Picture findByName(String name);

}
