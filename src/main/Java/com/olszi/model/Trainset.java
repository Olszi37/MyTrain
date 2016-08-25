package com.olszi.model;

import javax.persistence.*;

/**
 * Created by MOlszi on 2016-08-24.
 */

@Entity
@Table(name = "trainset")
public class Trainset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainsetID")
    private Long trainsetID;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;
}
