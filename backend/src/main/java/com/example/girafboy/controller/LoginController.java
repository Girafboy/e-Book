package com.example.girafboy.controller;

import com.example.girafboy.entity.User;
import com.example.girafboy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/welcome")
    public String welcome(){
        return "Welcome to eBook! Please login.";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request,@RequestBody User user){
        String state = userService.login(user);
        if(state.equals("USER") || state.equals("ADMI"))
            request.getSession().setAttribute("userID",user.getUserID());
        return state;
    }

    @GetMapping(value = "/valid")
    public String isSessionValid(HttpServletRequest request){
        return request.isRequestedSessionIdValid() ? "VALID":"INVALID";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "LOGOUT";
    }
}
