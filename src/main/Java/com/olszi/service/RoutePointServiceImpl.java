package com.olszi.service;

import com.olszi.dao.RoutePointDAO;
import com.olszi.model.Course;
import com.olszi.model.RoutePoint;
import com.olszi.model.Station;
import com.olszi.model.Trainset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-10.
 */

@Service
public class RoutePointServiceImpl implements RoutePointService {

    private RoutePointDAO routePointDAO;

    @Autowired
    public RoutePointServiceImpl(RoutePointDAO routePointDAO) {
        this.routePointDAO = routePointDAO;
    }

    @Override
    public void create(RoutePoint routePoint) {
        routePointDAO.create(routePoint);
    }

    @Override
    public void update(RoutePoint routePoint) {
        routePointDAO.update(routePoint);
    }

    @Override
    public void delete(RoutePoint routePoint) {
        routePointDAO.delete(routePoint);
    }

    @Override
    public RoutePoint getById(Long id) {
        return routePointDAO.getById(id);
    }

    @Override
    public List<RoutePoint> getInitialStations(Station station) {
        return routePointDAO.getInitialStations(station);
    }

    @Override
    public List<RoutePoint> getFinalStations(Station station) {
        return routePointDAO.getFinalStations(station);
    }

    @Override
    public List<RoutePoint> getByCourse(Course course) {
        return routePointDAO.getByCourse(course);
    }

    @Override
    public List<RoutePoint> getByCourseAndTrainset(Course course, Trainset trainset) {
        return routePointDAO.getByCourseAndTrainset(course, trainset);
    }

    @Override
    public List<RoutePoint> getByCourseTrainsetAndStations(Course course, Trainset trainset, Station station1, Station station2) {
        return routePointDAO.getByCourseTrainsetAndStations(course, trainset, station1, station2);
    }

    @Override
    public int rowCount() {
        return routePointDAO.rowCount();
    }

    @Override
    public void clearTable() {
        routePointDAO.clearTable();
    }
}
