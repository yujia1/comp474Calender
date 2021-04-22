package com.comp474.calender.comp474calender.controller;

import com.comp474.calender.comp474calender.Service.EventService;
import com.comp474.calender.comp474calender.dao.UserRepo;
import com.comp474.calender.comp474calender.entity.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/events/create")
    public Events createAppointment(@RequestBody Events events) {
        Events newEvents = eventService.createEvent(events);
        return newEvents;
    }

    @RequestMapping(value = "/events/cancel", method = RequestMethod.DELETE)
    public Events cancelAppointment(@RequestBody Events events) {
       Events canceledEvents = eventService.cancelEvent(events);
       return canceledEvents;
    }

    @RequestMapping(value = "/events/update", method = RequestMethod.PATCH)
    public Events updateAppointment(@RequestBody Events events){
       return eventService.updateEvent(events);
    }
    @GetMapping("/events/all")
    public List<Events> findAllEvents() {
        return eventService.findAllEvents();
    }
}
