package com.olszi.dao;

import com.olszi.model.Course;
import com.olszi.model.RoutePoint;
import com.olszi.model.Station;
import com.olszi.model.Trainset;
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
    public List<RoutePoint> getInitialStations(Station station) {
        return sessionFactory.getCurrentSession().createQuery("FROM routePoint WHERE stationID = :station AND departure != 0", RoutePoint.class)
                .setParameter("station", station.getStationID()).getResultList();
    }

    @Override
    public List<RoutePoint> getFinalStations(Station station) {
        return sessionFactory.getCurrentSession().createQuery("FROM routePoint WHERE stationID = :station AND distance != 0", RoutePoint.class)
                .setParameter("station", station.getStationID()).getResultList();
    }

    @Override
    public List<RoutePoint> getByCourse(Course course) {
        return sessionFactory.getCurrentSession().createQuery("FROM routePoint WHERE courseID = :course", RoutePoint.class)
                .setParameter("course", course.getCourseID()).getResultList();
    }

    @Override
    public List<RoutePoint> getByCourseAndTrainset(Course course, Trainset trainset) {
        return sessionFactory.getCurrentSession().createQuery("FROM routePoint WHERE courseID = :course AND trainsetID = :trainset", RoutePoint.class)
                .setParameter("course", course.getCourseID()).setParameter("trainset", trainset.getTrainsetID()).getResultList();
    }

    @Override
    public List<RoutePoint> getByCourseTrainsetAndStations(Course course, Trainset trainset, Station station1, Station station2) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM routePoint WHERE courseID = :course AND trainsetID = :trainset AND (stationID BETWEEN :id1 AND :id2)", RoutePoint.class)
                .setParameter("course", course.getCourseID()).setParameter("trainset", trainset.getTrainsetID())
                .setParameter("id1", station1.getStationID()).setParameter("id2", station2.getStationID()).getResultList();
    }

    @Override
    public int rowCount() {
        return (int) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM routePoint").uniqueResult();
    }

    @Override
    public void clearTable() {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM routePoint").executeUpdate();
    }
}
