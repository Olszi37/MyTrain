package com.olszi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity(name = "course")
@Table(name = "course")
public class Course implements Serializable{

    @Id
    @Column(nullable = false)
    private Long courseID;

    @ManyToOne(targetEntity = Station.class, optional = false)
    @JoinColumn(name = "`from`", nullable = false)
    private Station from;

    @ManyToOne(targetEntity = Station.class, optional = false)
    @JoinColumn(nullable =  false)
    private Station destiny;

    @Column(nullable = false)
    private String description;

    public Course() {
    }

    public Course(Long courseID, Station from, Station destiny, String description) {
        this.courseID = courseID;
        this.from = from;
        this.destiny = destiny;
        this.description = description;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
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
