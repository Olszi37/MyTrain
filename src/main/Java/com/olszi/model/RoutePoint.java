package com.olszi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity
@Table(name = "routePoint")
public class RoutePoint implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pointID", nullable = false)
    private Long pointID;

    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;

    @ManyToOne(targetEntity = Station.class)
    @JoinColumn(name = "stationID", nullable = false)
    private Station station;

    @Column(name = "arrival")
    private LocalTime arrival;

    @Column(name = "departure")
    private LocalTime departure;

    @Column(name = "distance", nullable = false)
    private int distance;

    public RoutePoint(Course course, Station station, LocalTime arrival, LocalTime departure, int distance) {
        this.course = course;
        this.station = station;
        this.arrival = arrival;
        this.departure = departure;
        this.distance = distance;
    }

    public RoutePoint() {
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
}
