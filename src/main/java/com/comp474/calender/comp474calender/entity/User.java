package com.comp474.calender.comp474calender.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 2681531852204068105L;
    @Id
    @Column(name = "emailid", unique = true)
    private String emailId;

    private String password;

    private boolean enabled;

    private String role;

    private String firstName;

    private String lastName;

     //Cascade persist to maintain field itself, fetch to load the field all or only id
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Events> events;

    public User() {}

    public User(String emailId, String password, boolean enabled, String role, String firstName, String lastName) {
        this.emailId = emailId;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
