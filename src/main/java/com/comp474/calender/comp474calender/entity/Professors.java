package com.comp474.calender.comp474calender.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professors")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "professor_id")
public class Professors extends User{
    private final static String role = "PROF";

    //TODO
    // one professor to many appointment
    @OneToMany(mappedBy = "professors")
    private List<Appointments> appointments;

    @Column(name = "zoomlink")
    private String zoomLink;

    public Professors() {
    }

    public Professors(String emailId, String password, boolean enabled, String role, String firstName, String lastName) {
        super(emailId, password, enabled, role,firstName, lastName);
    }
}
