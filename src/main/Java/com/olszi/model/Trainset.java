package com.olszi.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity(name = "trainset")
@Table(name = "trainset")
public class Trainset implements Serializable{

    @Id
    @Column(nullable = false)
    private Long trainsetID;

    @Column(nullable = false)
    private String number;

    private String name;

    public Trainset() {
    }

    public Trainset(Long trainsetID, String number, String name) {
        this.trainsetID = trainsetID;
        this.number = number;
        this.name = name;
    }

    public void setTrainsetID(Long trainsetID) {
        this.trainsetID = trainsetID;
    }

    public Long getTrainsetID() {
        return trainsetID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
