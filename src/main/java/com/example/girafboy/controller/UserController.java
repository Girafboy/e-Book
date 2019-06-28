package com.example.girafboy.controller;

import com.example.girafboy.entity.User;
import com.example.girafboy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
