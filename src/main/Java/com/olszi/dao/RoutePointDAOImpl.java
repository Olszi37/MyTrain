package com.olszi.dao;

import com.olszi.model.Course;
import com.olszi.model.RoutePoint;
import com.olszi.model.Station;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-08.
 */

@Repository
@Transactional
public class RoutePointDAOImpl implements RoutePointDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public RoutePointDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(RoutePoint routePoint) {
        sessionFactory.getCurrentSession().save(routePoint);
    }

    @Override
    public void update(RoutePoint routePoint) {
        sessionFactory.getCurrentSession().update(routePoint);
    }

    @Override
    public void delete(RoutePoint routePoint) {
        sessionFactory.getCurrentSession().delete(routePoint);
    }

    @Override
    public RoutePoint getById(Long id) {
        return sessionFactory.getCurrentSession().get(RoutePoint.class, id);
    }

    @Override
    public List<RoutePoint> getByStation(Station station) {
        return sessionFactory.getCurrentSession().createQuery("FROM routePoint WHERE stationID = :station", RoutePoint.class)
                .setParameter("station", station.getStationID()).getResultList();
    }

    @Override
    public List<RoutePoint> getByCourse(Course course) {
        return sessionFactory.getCurrentSession().createQuery("FROM routePoint WHERE courseID = :course", RoutePoint.class)
                .setParameter("course", course.getCourseID()).getResultList();
    }

    @Override
    public List<RoutePoint> getByCourseBetweenStations(Course course, Station station1, Station station2) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM routePoint WHERE courseID = :course AND stationID BETWEEN :id1 AND :id2", RoutePoint.class)
                .setParameter("course", course.getCourseID())
                .setParameter("id1", station1.getStationID()).setParameter("id2", station2.getStationID()).getResultList();
    }
}
