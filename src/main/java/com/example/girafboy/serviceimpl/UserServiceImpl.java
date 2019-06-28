package com.example.girafboy.serviceimpl;

import com.example.girafboy.dao.UserDao;
import com.example.girafboy.entity.User;
import com.example.girafboy.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByID(String id) {
        return userDao.findByID(id);
    }

    @Override
    public String login(User user) {
        User user1 = userDao.findByIDAndPassWord(user.getUserID(),user.getPassword());
        User user2 = userDao.findByID(user.getUserID());
        if( user2 == null)
            return "NOT_FOUND";
        else if(user1 == null)
            return "WRONG_PASSWORD";
        else if(userDao.isAdmi(user1))
            return "ADMI";
        else
            return "USER";
    }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user.getUserID(), user.getPassword(),"user","正常",user.getEmail());
    }
}
