package com.olszi.DAO;

import com.olszi.model.user.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-19.
 */

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User getByEmail(String email){
        return (User) sessionFactory.getCurrentSession().createQuery("FROM user WHERE email LIKE :email").setParameter("email", email).uniqueResult();
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM user", User.class).getResultList();
    }
}
