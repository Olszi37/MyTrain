package com.olszi.service;

import com.olszi.model.Payment;

/**
 * Created by MOlszi on 2016-09-10.
 */
public interface PaymentService {

    public void create(Payment payment);

    public void update(Payment payment);

    public void delete(Payment payment);

    public Payment getById(Long id);
}
