package com.comp474.calender.comp474calender.Service;

import com.comp474.calender.comp474calender.dao.ScheduleRepo;
import com.comp474.calender.comp474calender.entity.*;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.json.simple.*;
import java.time.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comp474.calender.comp474calender.Service.EventService;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;
    private EventService eventService;
    // create an appointment

    public List<Schedules> findAllSchedules() {
        return scheduleRepo.findAll();
    }

    public Schedules createSchedule(Schedules schedule) {
        Schedules newSchedule = scheduleRepo.save(schedule);

        //eventService.createEvent(Events events);

        return  newSchedule;
    }

    private List<Events> generateEventsFromSchedule(Schedules schedule) {
        List<Events> newEvents = new LinkedList<Events>();
        JSONObject json = new JSONObject();

        String weekDays = schedule.getWeekDay();
        String months = schedule.getMonth();
        int year = schedule.getYear();

        String startTime = schedule.getStart();
        LocalDateTime start = LocalDateTime.of(year, Month.APRIL, 28, Integer.parseInt(startTime) , 0);
        json.put("start", start);

        String endTime = schedule.getEnd();
        LocalDateTime end = LocalDateTime.of(year, Month.APRIL, 28, Integer.parseInt(endTime) , 0);

        json.put("end", end);

        String emailId = schedule.getOwnerId();
        json.put("users_emailid", emailId);

//        Events newEvent = new Events(json);


        return newEvents;
    }
}
