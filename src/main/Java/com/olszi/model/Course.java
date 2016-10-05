package com.olszi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity
@Table(name = "course")
public class Course implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseID", nullable = false)
    private Long courseID;

    @ManyToOne(targetEntity = Station.class)
    @JoinColumn(name = "from", nullable = false)
    private Station from;

    @ManyToOne(targetEntity = Station.class)
    @JoinColumn(name = "destiny", nullable =  false)
    private Station destiny;

    @Column(name = "descpription")
    private String description;

    public Course(Station from, Station destiny, String description) {
        this.from = from;
        this.destiny = destiny;
        this.description = description;
    }

    public Course() {
    }

    public Long getCourseID() {
        return courseID;
    }

    public Station getFrom() {
        return from;
    }

    public void setFrom(Station from) {
        this.from = from;
    }

    public Station getDestiny() {
        return destiny;
    }

    public void setDestiny(Station destiny) {
        this.destiny = destiny;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
