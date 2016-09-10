package com.olszi.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity
@Table(name = "carriage")
public class Carriage implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carriageID", nullable = false)
    private Long carriageID;

    @ManyToOne(targetEntity = Trainset.class)
    @JoinColumn(name = "trainsetID")
    private Trainset trainset;

    @Column(name = "number")
    private int number;

    @Column(name = "type", nullable = false)
    private CarriageType type;

    public Carriage(Trainset trainset, int number, CarriageType type) {
        this.trainset = trainset;
        this.number = number;
        this.type = type;
    }

    public Carriage() {
    }

    public Long getCarriageID() {
        return carriageID;
    }

    public Trainset getTrainset() {
        return trainset;
    }

    public void setTrainset(Trainset trainset) {
        this.trainset = trainset;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public CarriageType getType() {
        return type;
    }

    public void setType(CarriageType type) {
        this.type = type;
    }
}
