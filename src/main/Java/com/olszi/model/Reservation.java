package com.olszi.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by MOlszi on 2016-08-24.
 */

@Entity
@Table(name = "reservation")
public class Reservation {

    private Long id;

    private Long userID;


}
