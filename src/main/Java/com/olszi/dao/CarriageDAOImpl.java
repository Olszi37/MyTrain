package com.olszi.dao;

import com.olszi.model.Carriage;
import com.olszi.model.Trainset;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-07.
 */

@Repository
@Transactional
public class CarriageDAOImpl implements CarriageDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CarriageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Carriage carriage) {
        sessionFactory.getCurrentSession().save(carriage);
    }

    @Override
    public void update(Carriage carriage) {
        sessionFactory.getCurrentSession().update(carriage);
    }

    @Override
    public void delete(Carriage carriage) {
        sessionFactory.getCurrentSession().delete(carriage);
    }

    @Override
    public Carriage getById(Long id) {
        return sessionFactory.getCurrentSession().get(Carriage.class, id);
    }

    @Override
    public List<Carriage> getByTrainset(Trainset trainset) {
        return sessionFactory.getCurrentSession().createQuery("FROM carriage WHERE tainsetID = :trainset", Carriage.class)
                .setParameter("trainset", trainset.getTrainsetID()).getResultList();
    }

    @Override
    public int rowCount() {
        return (int) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM carriage").uniqueResult();
    }

    @Override
    public void clearTable() {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM carriage").executeUpdate();
    }
}
