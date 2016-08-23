package com.olszi.DAO;

import com.olszi.model.User;
import com.olszi.model.UserAuth;
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

    @Transactional
    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public Long createUserAuth(UserAuth userAuth){
        return (Long) sessionFactory.getCurrentSession().save(userAuth);
    }

    public List<User> getAll() {
        return null;
    }
}
