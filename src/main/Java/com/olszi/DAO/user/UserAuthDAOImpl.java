package com.olszi.DAO.user;

import com.olszi.model.user.UserAuth;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-23.
 */

@Repository
@Transactional
public class UserAuthDAOImpl implements UserAuthDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserAuthDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(UserAuth userAuth) {
        return (Long) sessionFactory.getCurrentSession().save(userAuth);
    }

    @Override
    public List<UserAuth> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM userAuth", UserAuth.class).list();
    }

    @Override
    public void delete(UserAuth userAuth) {
        sessionFactory.getCurrentSession().delete(userAuth);
    }

    @Override
    public UserAuth getByLogin(String login) {
        return (UserAuth) sessionFactory.getCurrentSession().createQuery("FROM userAuth WHERE login LIKE :login").setParameter("login", login).uniqueResult();
    }

    @Override
    public UserAuth getById(Long id) {
        return sessionFactory.getCurrentSession().get(UserAuth.class, id);
    }

    @Override
    public void changePassword(UserAuth userAuth, String password) {

    }
}
