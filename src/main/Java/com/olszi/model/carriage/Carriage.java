package com.olszi.model.carriage;

import javax.persistence.*;
import java.util.List;

/**
 * Created by MOlszi on 2016-08-24.
 */

@Entity
@Table(name = "carriage")
public class Carriage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carriageID")
    private Long carriageId;

    @Column(name = "trainsetID")
    private Long trainsetID;

    @Column(name = "number")
    private int number;

    @Column(name = "type")
    private CarriageType type;

    //IDK co wstawic
    private List<CarriageFeatures> features;

    public Carriage(Long trainsetID, int number, CarriageType type, List<CarriageFeatures> features) {
        this.trainsetID = trainsetID;
        this.number = number;
        this.type = type;
        this.features = features;
    }

    public Carriage() {
    }

    public Long getCarriageId() {
        return carriageId;
    }

    public Long getTrainsetID() {
        return trainsetID;
    }

    public void setTrainsetID(Long trainsetID) {
        this.trainsetID = trainsetID;
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

    public List<CarriageFeatures> getFeatures() {
        return features;
    }

    public void setFeatures(List<CarriageFeatures> features) {
        this.features = features;
    }
}
