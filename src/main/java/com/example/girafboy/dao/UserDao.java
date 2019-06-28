package com.example.girafboy.dao;

import com.example.girafboy.entity.Order;
import com.example.girafboy.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {
    User findByID(String id);
    User findByIDAndPassWord(String id,String password);
    User addUser(String id, String password, String role,
                   String state, String email);
    Boolean updateUser(String id, String password, String role,
                       String state, String email);
    Boolean isAdmi(User user);
}
