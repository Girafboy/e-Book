package com.example.girafboy.daoimpl;

import com.example.girafboy.dao.PictureDao;
import com.example.girafboy.entity.Picture;
import com.example.girafboy.repository.PictureRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Null;
import java.util.Date;

@Repository
public class PictureDaoImpl implements PictureDao {

    @Autowired
    PictureRepository pictureRepository;

    @Override
    public Picture findById(String id) {
        return pictureRepository.findById(id).isPresent()?pictureRepository.findById(id).get(): null;
    }

    @Override
    public Picture addPicture(String name, Binary content, String contentType, long size) {
        Picture picture = new Picture();
        picture.setName(name);
        picture.setContent(content);
        picture.setCreatedTime(new Date());
        picture.setContentType(contentType);
        picture.setSize(size);
        return pictureRepository.insert(picture);
    }
}
