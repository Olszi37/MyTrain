package com.olszi.controller;

import com.olszi.model.Reservation;
import com.olszi.model.SearchResult;
import com.olszi.service.CarriageService;
import com.olszi.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Siny on 2016-10-15.
 */

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private CarriageService carriageService;

    @RequestMapping(method = RequestMethod.POST, value = "create")
    public Reservation create(HttpServletRequest request){

        Reservation reservation = new Reservation();

        SearchResult result = new SearchResult();

        //searchResult, ilosc osob, klasa, dane - imie i nazwisko, email
        //payment setterem potem

        // setters

        reservationService.create(reservation);

        return reservation;
    }
}
