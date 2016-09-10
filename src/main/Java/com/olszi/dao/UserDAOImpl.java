package com.olszi.dao;

import com.olszi.model.User;
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
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User getById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findByLogin(String login) {
        return sessionFactory.getCurrentSession().createQuery("FROM "+ User.class.getName()+" WHERE login LIKE :login", User.class).setParameter("login", login).list();
    }
}
