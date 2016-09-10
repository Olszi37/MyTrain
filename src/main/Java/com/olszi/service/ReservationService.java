package com.olszi.service;

import com.olszi.model.Reservation;

/**
 * Created by MOlszi on 2016-09-10.
 */
public interface ReservationService {

    public void create(Reservation reservation);

    public void update(Reservation reservation);

    public void delete(Reservation reservation);

    public Reservation getById(Long id);
}
