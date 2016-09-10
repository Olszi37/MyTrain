package com.olszi.dao;

import com.olszi.model.Seat;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MOlszi on 2016-09-10.
 */

@Repository
@Transactional
public class SeatDAOImpl implements SeatDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public SeatDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Seat seat) {
        sessionFactory.getCurrentSession().save(seat);
    }

    @Override
    public void update(Seat seat) {
        sessionFactory.getCurrentSession().update(seat);
    }

    @Override
    public void delete(Seat seat) {
        sessionFactory.getCurrentSession().delete(seat);
    }

    @Override
    public Seat getById(Long id) {
        return sessionFactory.getCurrentSession().get(Seat.class, id);
    }
}
