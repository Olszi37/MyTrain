package com.olszi.controller;

import com.olszi.model.Payment;
import com.olszi.model.Reservation;
import com.olszi.service.PaymentService;
import com.olszi.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Siny on 2016-10-15.
 */

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ReservationService reservationService;

    public @ResponseBody Payment create(HttpServletRequest request){

        Payment payment = new Payment();

        // setters

        paymentService.create(payment);

        Reservation reservation = new Reservation(); // set by request
        reservation.setPayment(payment);
        reservationService.update(reservation);

        return payment;
    }
}
