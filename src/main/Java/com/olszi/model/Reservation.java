package com.olszi.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by MOlszi on 2016-08-24.
 */

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationID")
    private Long id;

    @Column(name = "userID")
    private Long userID;

    @Column(name = "trainsetID")
    private String trainsetID;

    private Long courseID;

    private Long paymentID;

    private String name;

    private String email;

    private LocalDateTime departure;

    private int carriageNumber;

    private List<Integer> seat;
}
