package com.comp474.calender.comp474calender.Service;

import com.comp474.calender.comp474calender.dao.AuthoritiesRepo;
import com.comp474.calender.comp474calender.dao.UserRepo;
import com.comp474.calender.comp474calender.entity.Authorities;
import com.comp474.calender.comp474calender.entity.EventType;
import com.comp474.calender.comp474calender.entity.Events;
import com.comp474.calender.comp474calender.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   @Autowired
   private UserRepo userRepo;
   @Autowired
   private AuthoritiesRepo authoritiesRepo;

   public String register(User user) {
      user.setEnabled(true);
//      Events event = new Events() {};
//      if (user.getRole() =="student") {
//         event.setEventType(EventType.REGULAR);
//      }
//      user.setEvents(event);
      Authorities authorities = new Authorities(user.getEmailId(), user.getRole());
      authoritiesRepo.save(authorities);
      userRepo.save(user);
      //TODO
      // change the redirect to login
      return "redirect:https://www.google.com";
   }

   public String login(String email, String password) {
      if (userRepo.existsById(email)) {
         User user = userRepo.getOne(email);
         if (password.equals(user.getPassword())) {
            return user.getRole();
         } else {
            return "WRONG PASSWORD";
         }
      } else {
         return "NO USER WITH THAT EMAIL";
      }
   }
}
