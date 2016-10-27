package com.olszi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity(name = "routePoint")
@Table(name = "routePoint")
public class RoutePoint implements Serializable{

    @Id
    @Column(nullable = false)
    private Long pointID;

    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;

    @ManyToOne(targetEntity = Station.class)
    @JoinColumn(name = "stationID", nullable = false)
    private Station station;

    private LocalTime arrival;

    private LocalTime departure;

    @Column(nullable = false)
    private int distance;

    @ManyToOne(targetEntity = Trainset.class)
    @JoinColumn(name = "trainsetID", nullable = false)
    private Trainset trainset;

    public RoutePoint() {
    }

    public RoutePoint(Long pointID, Course course, Station station, LocalTime arrival, LocalTime departure, int distance, Trainset trainset) {
        this.pointID = pointID;
        this.course = course;
        this.station = station;
        this.arrival = arrival;
        this.departure = departure;
        this.distance = distance;
        this.trainset = trainset;
    }

    public void setPointID(Long pointID) {
        this.pointID = pointID;
    }

    public Long getPointID() {
        return pointID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public LocalTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalTime arrival) {
        this.arrival = arrival;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Trainset getTrainset() {
        return trainset;
    }

    public void setTrainset(Trainset trainset) {
        this.trainset = trainset;
    }
}
