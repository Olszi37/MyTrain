package com.olszi.model;

import javax.persistence.*;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity
@Table(name = "station")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stationID")
    private Long stationID;

    @Column(name = "name")
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public Station() {
    }

    public Long getStationID() {
        return stationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
