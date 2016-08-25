package com.olszi.DAO.trainset;

import com.olszi.model.Trainset;
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
public class TrainsetDAOImpl implements TrainsetDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public TrainsetDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Trainset trainset) {
        return (Long) sessionFactory.getCurrentSession().save(trainset);
    }

    @Override
    public void delete(Trainset trainset) {
        sessionFactory.getCurrentSession().delete(trainset);
    }

    @Override
    public List<Trainset> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM trainset", Trainset.class).list();
    }

    @Override
    public void update(Trainset trainset) {
        sessionFactory.getCurrentSession().update(trainset);
    }

    @Override
    public Trainset getById(Long id) {
        return sessionFactory.getCurrentSession().get(Trainset.class, id);
    }

    @Override
    public Trainset getByName(String name) {
        return sessionFactory.getCurrentSession().createQuery("FROM trainset WHERE name LIKE :name", Trainset.class).setParameter("name", name).uniqueResult();
    }

    @Override
    public Trainset getByNickname(String nickname) {
        return sessionFactory.getCurrentSession().createQuery("FROM trainset WHERE nickname LIKE :nickname", Trainset.class).setParameter("nickname", nickname).uniqueResult();
    }
}
