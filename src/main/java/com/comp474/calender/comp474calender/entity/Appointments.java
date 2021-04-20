package com.comp474.calender.comp474calender.entity;

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
public class Appointments implements Serializable, Comparable<Appointments> {

    private static final long serialVersionUID = 1994505605936682926L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "eventType")
    private EventType eventType;

    @Column(name = "start", unique = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date start;

    @Column(name = "end", unique = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date end;
    //TODO
    // many to one students
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Students students;
    // many to one professors
    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professors professors;

    @ManyToMany(mappedBy = "appointments")
    private List<Events> events;

    // compare to
    @Override
    public int compareTo(Appointments o) {
        return this.getStart().compareTo(o.getStart());
    }
}
