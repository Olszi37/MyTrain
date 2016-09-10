package com.olszi.dao;

import com.olszi.model.UserDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Repository
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDetailsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(UserDetails userDetails) {
        sessionFactory.getCurrentSession().save(userDetails);
    }

    @Override
    public void update(UserDetails userDetails) {
        sessionFactory.getCurrentSession().update(userDetails);
    }

    @Override
    public void delete(UserDetails userDetails) {
        sessionFactory.getCurrentSession().delete(userDetails);
    }

    @Override
    public UserDetails getById(Long id) {
        return sessionFactory.getCurrentSession().get(UserDetails.class, id);
    }

    @Override
    public List<UserDetails> findByEmail(String email) {
        return sessionFactory.getCurrentSession().createQuery("FROM "+ UserDetails.class.getName()+" WHERE email LIKE :email", UserDetails.class).setParameter("email", email).list();
    }
}
