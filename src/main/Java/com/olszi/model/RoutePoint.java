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
    @Column(name = "pointID")
    private Long pointID;

    @ManyToOne(targetEntity = Course.class)
    private Course course;

    @ManyToOne(targetEntity = Station.class)
    private Station station;

    @Column(name = "estimatedTimeArrival")
    private LocalTime estimatedTimeArrival;

    @Column(name = "distance")
    private int distance;

    public RoutePoint(Course course, Station station, LocalTime estimatedTimeArrival, int distance) {
        this.course = course;
        this.station = station;
        this.estimatedTimeArrival = estimatedTimeArrival;
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

    public LocalTime getEstimatedTimeArrival() {
        return estimatedTimeArrival;
    }

    public void setEstimatedTimeArrival(LocalTime estimatedTimeArrival) {
        this.estimatedTimeArrival = estimatedTimeArrival;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}