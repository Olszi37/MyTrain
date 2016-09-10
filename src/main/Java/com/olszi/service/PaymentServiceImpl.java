package com.olszi.service;

import com.olszi.dao.PaymentDAO;
import com.olszi.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MOlszi on 2016-09-10.
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentDAO paymentDAO;

    @Autowired
    public PaymentServiceImpl(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public void create(Payment payment) {
        paymentDAO.create(payment);
    }

    @Override
    public void update(Payment payment) {
        paymentDAO.update(payment);
    }

    @Override
    public void delete(Payment payment) {
        paymentDAO.delete(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDAO.getById(id);
    }
}
