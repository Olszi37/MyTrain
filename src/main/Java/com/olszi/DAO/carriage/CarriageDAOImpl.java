package com.olszi.DAO.carriage;

import com.olszi.model.carriage.Carriage;
import com.olszi.model.carriage.CarriageType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-25.
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
    public Long create(Carriage carriage) {
        return (Long) sessionFactory.getCurrentSession().save(carriage);
    }

    @Override
    public void delete(Carriage carriage) {
        sessionFactory.getCurrentSession().delete(carriage);
    }

    @Override
    public List<Carriage> getByTrainsetID(Long trainsetID) {
        return sessionFactory.getCurrentSession().createQuery("FROM carriage WHERE trainsetID = :trainsetID", Carriage.class)
                .setParameter("trainsetID", trainsetID).list();
    }

    @Override
    public List<Carriage> getBytype(CarriageType type) {
        return sessionFactory.getCurrentSession().createQuery("FROM carriage WHERE type = :type", Carriage.class)
                .setParameter("type", type).list();
    }
}
