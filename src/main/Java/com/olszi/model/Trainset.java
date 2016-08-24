package com.olszi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by MOlszi on 2016-08-24.
 */

@Entity
@Table(name = "trainset")
public class Trainset {

    @Id
    private String trainsetID;


}
