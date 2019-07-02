package com.example.girafboy.serviceimpl;

import com.example.girafboy.dao.UserDao;
import com.example.girafboy.entity.User;
import com.example.girafboy.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByID(String id) {
        return userDao.findByID(id);
    }

    @Override
    public Boolean existUser(String id) {
        return userDao.isExist(id);
    }

    @Override
    public String login(User user) {
        if(!userDao.isExist(user.getUserID()))
            return "NOT_FOUND";

        User user1 = userDao.findByIDAndPassWord(user.getUserID(),user.getPassword());
        if(user1 == null)
            return "WRONG_PASSWORD";
        else if(userDao.isForbidden(user1))
            return "FORBIDDEN";
        else if(userDao.isAdmi(user1))
            return "ADMI";
        else
            return "USER";
    }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user.getUserID(), user.getPassword(),"user","正常",user.getEmail());
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public Boolean forbid(String id) {
        if (userDao.isForbidden(userDao.findByID(id))) {
            userDao.updateUser(id, null, null, "正常", null);
            return false;
        } else {
            userDao.updateUser(id, null, null, "禁用", null);
            return true;
        }
    }
}
