package com.comp474.calender.comp474calender.dao;

import com.comp474.calender.comp474calender.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Events, Long> {

}
