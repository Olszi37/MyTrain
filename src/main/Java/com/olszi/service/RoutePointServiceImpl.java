package com.olszi.service;

import com.olszi.dao.RoutePointDAO;
import com.olszi.model.RoutePoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}