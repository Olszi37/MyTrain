package com.olszi.dao;

import com.olszi.model.Reservation;

/**
 * Created by MOlszi on 2016-09-08.
 */
public interface ReservationDAO {

    public void create(Reservation reservation);

    public void update(Reservation reservation);

    public void delete(Reservation reservation);

    public Reservation getById(Long id);
}
