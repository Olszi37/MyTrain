package com.olszi.dao;

import com.olszi.model.Seat;

/**
 * Created by MOlszi on 2016-09-10.
 */
public interface SeatDAO {

    public void create(Seat seat);

    public void update(Seat seat);

    public void delete(Seat seat);

    public Seat getById(Long id);
}
