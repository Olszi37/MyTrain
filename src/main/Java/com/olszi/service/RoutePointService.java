package com.olszi.service;

import com.olszi.model.Course;
import com.olszi.model.RoutePoint;
import com.olszi.model.Station;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-10.
 */
public interface RoutePointService {

    public void create(RoutePoint routePoint);

    public void update(RoutePoint routePoint);

    public void delete(RoutePoint routePoint);

    public RoutePoint getById(Long id);

    public List<RoutePoint> getByStation(Station station);

    public List<RoutePoint> getByCourse(Course course);

    public List<RoutePoint> getByCourseBetweenStations(Course course, Station station1, Station station2);
}
