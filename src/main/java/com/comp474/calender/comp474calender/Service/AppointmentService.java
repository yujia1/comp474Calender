package com.comp474.calender.comp474calender.Service;

import com.comp474.calender.comp474calender.dao.AppointmentRepo;
import com.comp474.calender.comp474calender.dao.UserRepo;
import com.comp474.calender.comp474calender.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private UserRepo userRepo;
    // create an appointment
    public Appointments createAppointment(Appointments appointments) {
        Events event = appointments.getEvents();
        User user = appointments.getEvents().getUsers();
        if (event.getEventType()== EventType.OFFICEHOUR && user.getRole()=="student") {
            appointments.setAppointmentStatus(AppointmentStatus.FAILED);
            return appointments;
        }
        appointments.setAppointmentStatus(AppointmentStatus.SUCCEED);
        appointmentRepo.save(appointments);
        return appointments;
    }
    // delete an appointment
    public Appointments cancelAppointment(Appointments appointments) {
        appointmentRepo.delete(appointments);
        appointments.setAppointmentStatus(AppointmentStatus.CANCELED);
        return appointments;
    }
}
