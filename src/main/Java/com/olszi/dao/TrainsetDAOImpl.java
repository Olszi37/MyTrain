package com.olszi.dao;

import com.olszi.model.Trainset;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MOlszi on 2016-09-08.
 */

@Repository
@Transactional
public class TrainsetDAOImpl implements TrainsetDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public TrainsetDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Trainset trainset) {
        sessionFactory.getCurrentSession().save(trainset);
    }

    @Override
    public void update(Trainset trainset) {
        sessionFactory.getCurrentSession().update(trainset);
    }

    @Override
    public void delete(Trainset trainset) {
        sessionFactory.getCurrentSession().delete(trainset);
    }

    @Override
    public Trainset getById(Long id) {
        return sessionFactory.getCurrentSession().get(Trainset.class, id);
    }
}
