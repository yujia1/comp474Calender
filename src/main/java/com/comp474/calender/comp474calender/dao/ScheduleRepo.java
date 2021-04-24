package com.comp474.calender.comp474calender.dao;

import com.comp474.calender.comp474calender.entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedules, String> {

}
