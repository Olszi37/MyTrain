package com.olszi.service;

import com.olszi.dao.SeatDAO;
import com.olszi.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MOlszi on 2016-09-10.
 */

@Service
public class SeatServiceImpl implements SeatService {

    private SeatDAO seatDAO;

    @Autowired
    public SeatServiceImpl(SeatDAO seatDAO) {
        this.seatDAO = seatDAO;
    }

    @Override
    public void create(Seat seat) {
        seatDAO.create(seat);
    }

    @Override
    public void update(Seat seat) {
        seatDAO.update(seat);
    }

    @Override
    public void delete(Seat seat) {
        seatDAO.delete(seat);
    }

    @Override
    public Seat getById(Long id) {
        return seatDAO.getById(id);
    }
}
