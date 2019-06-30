package com.example.girafboy.serviceimpl;

import com.example.girafboy.dao.BookDao;
import com.example.girafboy.dao.PictureDao;
import com.example.girafboy.entity.Picture;
import com.example.girafboy.service.PictureService;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureDao pictureDao;
    @Autowired
    BookDao bookDao;

    @Override
    public Boolean upload(MultipartFile multipartFile, Integer bookID) {
        try{
            Picture picture = pictureDao.addPicture(multipartFile.getOriginalFilename(),
                    new Binary(multipartFile.getBytes()),
                    multipartFile.getContentType(),
                    multipartFile.getSize());
            bookDao.modifyBook(bookID,null,null,
                    "http://localhost:8000/picture/download/" + picture.getId(),
                    null,null,null,null);
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public byte[] getPictureBlob(String id) {
        Picture picture = pictureDao.findById(id);
        if(picture == null)
            return new byte[0];
        return picture.getContent().getData();
    }
}
