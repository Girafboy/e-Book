package com.example.girafboy.service;

import com.example.girafboy.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User findUserByID(String id);
    String login(User user);
    User addUser(User user);
}
