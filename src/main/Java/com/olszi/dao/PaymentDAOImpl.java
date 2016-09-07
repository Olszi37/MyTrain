package com.olszi.dao;

import com.olszi.model.Payment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by MOlszi on 2016-09-08.
 */

@Repository
public class PaymentDAOImpl implements PaymentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public PaymentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Payment payment) {
        sessionFactory.getCurrentSession().save(payment);
    }

    @Override
    public void update(Payment payment) {
        sessionFactory.getCurrentSession().update(payment);
    }

    @Override
    public void delete(Payment payment) {
        sessionFactory.getCurrentSession().delete(payment);
    }

    @Override
    public Payment getById(Long id) {
        return sessionFactory.getCurrentSession().get(Payment.class, id);
    }
}
