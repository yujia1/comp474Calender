package com.comp474.calender.comp474calender.dao;

import com.comp474.calender.comp474calender.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointments, Long> {
}
