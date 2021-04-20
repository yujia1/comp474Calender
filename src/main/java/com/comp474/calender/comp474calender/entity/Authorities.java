package com.comp474.calender.comp474calender.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Authorities")
@NoArgsConstructor
@Setter
@Getter
public class Authorities implements Serializable {

    @Id
    @Column(name = "emailid")
    private String emailId;
    @Column(name = "authorities")
    private String authorities;

    public Authorities(String emailId, String authorities) {
        this.emailId = emailId;
        this.authorities = authorities;
    }

}
