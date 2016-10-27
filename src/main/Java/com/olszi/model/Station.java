package com.olszi.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity(name = "station")
@Table(name = "station")
public class Station implements Serializable{

    @Id
    @Column(nullable = false)
    private Long stationID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String province;

    public Station() {
    }

    public Station(Long stationID, String name, String province) {
        this.stationID = stationID;
        this.name = name;
        this.province = province;
    }

    public void setStationID(Long stationID) {
        this.stationID = stationID;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
