package com.olszi.dao;

import com.olszi.model.RoutePoint;

/**
 * Created by MOlszi on 2016-09-08.
 */
public interface RoutePointDAO{

    public void create(RoutePoint routePoint);

    public void update(RoutePoint routePoint);

    public void delete(RoutePoint routePoint);

    public RoutePoint getById(Long id);
}
