package com.olszi.dao;

import com.olszi.model.Station;
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
public class StationDAOImpl implements StationDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public StationDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Station station) {
        sessionFactory.getCurrentSession().save(station);
    }

    @Override
    public void update(Station station) {
        sessionFactory.getCurrentSession().update(station);
    }

    @Override
    public void delete(Station station) {
        sessionFactory.getCurrentSession().delete(station);
    }

    @Override
    public Station getById(Long id) {
        return sessionFactory.getCurrentSession().get(Station.class, id);
    }

    @Override
    public List<Station> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM station", Station.class).getResultList();
    }

    @Override
    public int rowCount() {
        return ((Long)sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM station").uniqueResult()).intValue();
    }

    @Override
    public void clearTable() {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM station").executeUpdate();
    }
}
