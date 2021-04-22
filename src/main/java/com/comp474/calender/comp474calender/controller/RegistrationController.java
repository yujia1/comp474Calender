package com.comp474.calender.comp474calender.controller;

import com.comp474.calender.comp474calender.Service.UserService;
import com.comp474.calender.comp474calender.entity.Events;
import com.comp474.calender.comp474calender.entity.Authorities;
import com.comp474.calender.comp474calender.entity.User;
import com.comp474.calender.comp474calender.dao.AuthoritiesRepo;
import com.comp474.calender.comp474calender.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;

    //successfully test in postman
    @PostMapping("/registration")
    public String registerNewUser(@RequestBody User user){
        return userService.register(user);
        //TODO
        // redirect to login
    }
    @GetMapping("/login")
    public HttpStatus login(@RequestParam("email") String email, @RequestParam("password") String password) {
        // send back whether login was successful by checking db
        return userService.login(email, password);
    }
}
