package com.comp474.calender.comp474calender.controller;

import com.comp474.calender.comp474calender.entity.Events;
import com.comp474.calender.comp474calender.entity.Authorities;
import com.comp474.calender.comp474calender.entity.User;
import com.comp474.calender.comp474calender.dao.AuthoritiesRepo;
import com.comp474.calender.comp474calender.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthoritiesRepo authoritiesRepo;

    //successfully test in postman
    @PostMapping("/registration")
    public String registerNewUser(@RequestBody User user){
        user.setEnabled(true);
        List<Events> events = new ArrayList<>();
        user.setEvents(events);
        Authorities authorities = new Authorities(user.getEmailId(), user.getRole());
        authoritiesRepo.save(authorities);
        userRepo.save(user);
        //TODO
        // change to login page
        return "redirect:https://www.google.com";
    }
    @GetMapping("/login")
    public String login(@RequestBody User user) {
        //TODO
        // change to landing page
        return "redirect:https://www.google.com";
    }
}
