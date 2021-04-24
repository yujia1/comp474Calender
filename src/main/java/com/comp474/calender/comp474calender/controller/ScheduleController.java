package com.comp474.calender.comp474calender.controller;

import com.comp474.calender.comp474calender.Service.ScheduleService;
import com.comp474.calender.comp474calender.entity.Schedules;
import com.comp474.calender.comp474calender.entity.Authorities;
import com.comp474.calender.comp474calender.entity.User;
import com.comp474.calender.comp474calender.dao.AuthoritiesRepo;
import com.comp474.calender.comp474calender.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/schedules/create")
    public Schedules createSchedule(@RequestBody Schedules schedule) {
        return scheduleService.createSchedule(schedule);
    }


        @GetMapping("/schedules")
    public List<Schedules> findAllSchedules() {
        return scheduleService.findAllSchedules();
    }
}
