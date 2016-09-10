package com.olszi.model;

import javax.persistence.*;

/**
 * Created by MOlszi on 2016-09-10.
 */

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seatID", nullable = false)
    private Long seatID;

    @ManyToOne(targetEntity = Carriage.class)
    @JoinColumn(name = "carriageID", nullable = false)
    private Carriage carriage;

    @ManyToOne(targetEntity = Reservation.class)
    @JoinColumn(name = "reservationID", nullable = false)
    private Reservation reservation;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "location", nullable = false)
    private SeatLocation location;

    public Seat(Carriage carriage, Reservation reservation, int number, SeatLocation location) {
        this.carriage = carriage;
        this.reservation = reservation;
        this.number = number;
        this.location = location;
    }

    public Seat() {
    }

    public Long getSeatID() {
        return seatID;
    }

    public Carriage getCarriage() {
        return carriage;
    }

    public void setCarriage(Carriage carriage) {
        this.carriage = carriage;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SeatLocation getLocation() {
        return location;
    }

    public void setLocation(SeatLocation location) {
        this.location = location;
    }
}
