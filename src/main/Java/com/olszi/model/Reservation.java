package com.olszi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity(name = "payment")
@Table(name = "reservation")
public class Reservation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationID", nullable = false)
    private Long reservationID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne(targetEntity = Station.class)
    @JoinColumn(name = "initialStop", nullable = false)
    private Station initialStop;

    @ManyToOne(targetEntity = Station.class)
    @JoinColumn(name = "finalStop", nullable = false)
    private Station finalStop;

    @Column(name = "departureDate", nullable = false)
    private LocalDate departureDate;

    @Column(name = "personCount", nullable = false)
    private int personCount;

    @Column(name = "class", nullable = false)
    private ClassType classType;

    @ManyToOne(targetEntity = Payment.class)
    @JoinColumn(name = "paymentID", nullable = false)
    private Payment payment;

    public Reservation(String name, String email, Station initialStop, Station finalStop, LocalDate departureDate, int personCount, ClassType classType, Payment payment) {
        this.name = name;
        this.email = email;
        this.initialStop = initialStop;
        this.finalStop = finalStop;
        this.departureDate = departureDate;
        this.personCount = personCount;
        this.classType = classType;
        this.payment = payment;
    }

    public Reservation() {
    }

    public Long getReservationID() {
        return reservationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Station getInitialStop() {
        return initialStop;
    }

    public void setInitialStop(Station initialStop) {
        this.initialStop = initialStop;
    }

    public Station getFinalStop() {
        return finalStop;
    }

    public void setFinalStop(Station finalStop) {
        this.finalStop = finalStop;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
