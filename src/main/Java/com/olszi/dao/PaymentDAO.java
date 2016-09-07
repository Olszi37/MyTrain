package com.olszi.dao;

import com.olszi.model.Payment;

/**
 * Created by MOlszi on 2016-09-08.
 */
public interface PaymentDAO {

    public void create(Payment payment);

    public void update(Payment payment);

    public void delete(Payment payment);

    public Payment getById(Long id);
}
