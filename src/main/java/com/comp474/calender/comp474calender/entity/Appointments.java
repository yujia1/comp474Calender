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
@Table(name = "appointments")
@Getter
@Setter
public class Appointments implements Serializable {

    private static final long serialVersionUID = 1994505605936682926L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "start", unique = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date start;

    @Column(name = "end", unique = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date end;

    @Column(name = "zoomlink")
    private String zoomLink;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_status")
    private AppointmentStatus appointmentStatus;

    //TODO
    // many to one students
//    @ManyToOne
//    @JoinColumn(name = "id_student")
//    private Students students;
//    // many to one professors
//    @ManyToOne
//    @JoinColumn(name = "id_professor")
//    private Professors professors;

    @ManyToOne
    @JsonIgnore
    private Events events;

}
