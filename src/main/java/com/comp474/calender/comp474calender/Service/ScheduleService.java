package com.comp474.calender.comp474calender.Service;

import com.comp474.calender.comp474calender.dao.ScheduleRepo;
import com.comp474.calender.comp474calender.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;
    // create an appointment

    public List<Schedules> findAllSchedules() {
        return scheduleRepo.findAll();
    }

    public Schedules createSchedule(Schedules schedule) {
//        Date startTime = schedule.getStart();
//        // convert local time to date
//        Date in = new Date();
//        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
//        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        // compare time
        // succeed it, then confirmed appointment
        Schedules newSchedule = scheduleRepo.save(schedule);
//        if (startTime.compareTo(out) > 0) {
//            events.setStatus(EventStatus.CONFIRMED);
//            return  newEvent;
//        }
//        // fail it, then rejected
//        events.setStatus(EventStatus.REJECTED);
        return  newSchedule;
    }
}
