package com.comp474.calender.comp474calender.Service;

import com.comp474.calender.comp474calender.dao.EventRepo;
import com.comp474.calender.comp474calender.entity.Events;
import com.comp474.calender.comp474calender.entity.EventStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;
    // create an appointment
    public Events createEvent(Events events) {
        Date startTime = events.getStart();
        // convert local time to date
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        // compare time
        // succeed it, then confirmed appointment
        Events newEvent = eventRepo.save(events);
        if (startTime.compareTo(out) > 0) {
            events.setStatus(EventStatus.CONFIRMED);
            return  newEvent;
        }
        // fail it, then rejected
        events.setStatus(EventStatus.REJECTED);
        return  newEvent;
    }

    // cancel an appointment
    public Events cancelEvent(Events events) {
        events.setStatus(EventStatus.CANCELED);
        eventRepo.delete(events);
        return events;
    }

//    update an appointment
    public Events updateEvent(Events events) {
        eventRepo.save(events);
        return events;
    }

    public List<Events> findAllEvents() {

        return eventRepo.findAll();
    }

    public String findEventsForUser(String email) {
        if (email != null) {
            List<Events> allEvents = eventRepo.findAll();
            List<Events> userEvents = new LinkedList<Events>();

            for (int i = 0; i < allEvents.size(); i++) {
                if (allEvents.get(i).getUsers().equals(email)) {
                    userEvents.add(allEvents.get(i));
                }
            }
            return allEvents.get(0).getUsers().getEmailId();
        } else {
            return "new LinkedList<Events>()";
        }
    }
}
