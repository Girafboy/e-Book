package com.example.girafboy.daoimpl;

import com.example.girafboy.dao.PictureDao;
import com.example.girafboy.entity.Picture;
import com.example.girafboy.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PictureDaoImpl implements PictureDao {

    @Autowired
    PictureRepository pictureRepository;

    @Override
    public Picture findByName(String name) {
        return pictureRepository.findByName(name);
    }
}
