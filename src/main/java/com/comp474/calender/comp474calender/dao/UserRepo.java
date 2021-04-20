package com.comp474.calender.comp474calender.dao;

import com.comp474.calender.comp474calender.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

}
