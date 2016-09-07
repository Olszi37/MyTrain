package com.olszi.dao;

import com.olszi.model.Reservation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by MOlszi on 2016-09-08.
 */

@Repository
public class ReservationDAOImpl implements ReservationDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public ReservationDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Reservation reservation) {
        sessionFactory.getCurrentSession().save(reservation);
    }

    @Override
    public void update(Reservation reservation) {
        sessionFactory.getCurrentSession().update(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        sessionFactory.getCurrentSession().delete(reservation);
    }

    @Override
    public Reservation getById(Long id) {
        return sessionFactory.getCurrentSession().get(Reservation.class, id);
    }
}
