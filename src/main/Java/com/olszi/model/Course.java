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

    @Column(name = "departure", nullable = false)
    private LocalTime departure;

    @ManyToOne(targetEntity = Trainset.class)
    @JoinColumn(name = "trainsetID")
    private Trainset trainset;

    public Course(Station from, Station destiny, LocalTime departure, Trainset trainset) {
        this.from = from;
        this.destiny = destiny;
        this.departure = departure;
        this.trainset = trainset;
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

    public LocalTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public Trainset getTrainset() {
        return trainset;
    }

    public void setTrainset(Trainset trainset) {
        this.trainset = trainset;
    }
}
