package com.olszi.service;

import com.olszi.dao.ReservationDAO;
import com.olszi.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MOlszi on 2016-09-10.
 */

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationDAO reservationDAO;

    @Autowired
    public ReservationServiceImpl(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    @Override
    public void create(Reservation reservation) {
        reservationDAO.create(reservation);
    }

    @Override
    public void update(Reservation reservation) {
        reservationDAO.update(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        reservationDAO.delete(reservation);
    }

    @Override
    public Reservation getById(Long id) {
        return reservationDAO.getById(id);
    }
}
