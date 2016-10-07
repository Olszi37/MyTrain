package com.olszi.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity
@Table(name = "trainset")
public class Trainset implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainsetID", nullable = false)
    private Long trainsetID;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "name")
    private String name;

    public Trainset(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public Trainset() {
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
