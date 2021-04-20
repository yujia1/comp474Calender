package com.comp474.calender.comp474calender.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Students extends User{
    private final static String role = "STUD";

    @OneToMany(mappedBy = "students")
    private List<Appointments> appointments;

    @Column(name = "zoomlink")
    private String zoomLink;

    public Students(){
    }
    public Students(String emailId, String password, boolean enabled, String role, String firstName, String lastName) {
        super(emailId, password, enabled, role,firstName, lastName);
    }
}
