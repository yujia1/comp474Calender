package com.comp474.calender.comp474calender.Service;

import com.comp474.calender.comp474calender.dao.ScheduleRepo;
import com.comp474.calender.comp474calender.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comp474.calender.comp474calender.Service.EventService;


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

        String startTime = schedule.getStart();
        String endTime = schedule.getEnd();
        String weekDays = schedule.getWeekDay();
        String months = schedule.getMonth();

        return newEvents;
    }
}
