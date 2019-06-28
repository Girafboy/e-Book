package com.example.girafboy.daoimpl;

import com.example.girafboy.dao.UserDao;
import com.example.girafboy.entity.User;
import com.example.girafboy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByID(String id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findByIDAndPassWord(String id, String password) {
        return userRepository.findUserByUserIDAndPassword(id,password);
    }

    @Override
    public User addUser(String id, String password, String role, String state, String email) {
        User user = new User();
        user.setUserID(id);
        user.setPassword(password);
        user.setRole(role);
        user.setState(state);
        user.setEmail(email);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Boolean updateUser(String id, String password, String role, String state, String email) {
        User user = userRepository.getOne(id);
        if(user == null)    return false;
        user.setPassword(password);
        user.setRole(role);
        user.setState(state);
        user.setEmail(email);
        userRepository.saveAndFlush(user);
        return true;
    }

    @Override
    public Boolean isAdmi(User user) {
        return user.getRole().equals("admi");
    }
}
