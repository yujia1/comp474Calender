package com.comp474.calender.comp474calender.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "schedules")
@Getter
@Setter
public class Schedules implements Serializable {

    private static final long serialVersionUID = 123456789L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "startTime")
    private String start;

    @Column(name = "endTime")
    private String end;

    @Column(name = "weekDay")
    private String weekDay;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private int year;

    @Column(name = "eventIds")
    private String eventIds;

    @Column(name = "numStudentsAllowed")
    private int numStudentsAllowed;
}

