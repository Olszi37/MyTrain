package com.olszi.dao;

import com.olszi.model.Carriage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MOlszi on 2016-09-07.
 */

@Repository
public class CarriageDAOImpl implements CarriageDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CarriageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void create(Carriage carriage) {
        sessionFactory.getCurrentSession().save(carriage);
    }

    @Override
    @Transactional
    public void update(Carriage carriage) {
        sessionFactory.getCurrentSession().update(carriage);
    }

    @Override
    @Transactional
    public void delete(Carriage carriage) {
        sessionFactory.getCurrentSession().delete(carriage);
    }
}
