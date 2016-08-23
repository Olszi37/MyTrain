package com.olszi.DAO;

import com.olszi.model.UserAuth;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by MOlszi on 2016-08-23.
 */

@Repository
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
}
