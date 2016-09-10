package com.olszi.service;

import com.olszi.model.RoutePoint;

/**
 * Created by MOlszi on 2016-09-10.
 */
public interface RoutePointService {

    public void create(RoutePoint routePoint);

    public void update(RoutePoint routePoint);

    public void delete(RoutePoint routePoint);

    public RoutePoint getById(Long id);
}
