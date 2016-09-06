package com.olszi.dao;

import com.olszi.model.UserDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDetailsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void create(UserDetails userDetails) {
        sessionFactory.getCurrentSession().save(userDetails);
    }

    @Override
    @Transactional
    public void update(UserDetails userDetails) {
        sessionFactory.getCurrentSession().update(userDetails);
    }

    @Override
    @Transactional
    public void delete(UserDetails userDetails) {
        sessionFactory.getCurrentSession().delete(userDetails);
    }
}
