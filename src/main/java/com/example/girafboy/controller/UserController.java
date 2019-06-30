package com.example.girafboy.controller;

import com.example.girafboy.entity.User;
import com.example.girafboy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/findUser/{id}")
    public User findUser(@PathVariable String id){
        return userService.findUserByID(id);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/findAllUser")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    //是toggle操作，已禁用后会解禁
    @PutMapping("/forbid/{id}")
    public String forbid(@PathVariable String id){
        if(userService.forbid(id))
            return "已禁用";
        else
            return "已启用";
    }
}
