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
    @ManyToOne
    private Long trainsetID;

    @Column(name = "number")
    private int number;

    @Column(name = "type")
    private CarriageType type;

    //IDK co wstawic
    private List<CarriageFeatures> features;
}
