package com.comp474.calender.comp474calender.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class Events implements Serializable {
    private static final long serialVersionUID = 6561674322377833080L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "start", unique = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date start;

    @Column(name = "end", unique = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date end;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EventStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "eventType")
    private EventType eventType;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "events")
    private User users;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "events")
    private List<Appointments> appointments;
}
