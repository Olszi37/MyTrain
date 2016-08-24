package com.olszi.model;

import javax.persistence.*;

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

    @ManyToOne
    @Column(name = "userID")
    private Long userID;

    @ManyToOne
    @Column(name = "trainsetID")
    private String trainsetID;

}
