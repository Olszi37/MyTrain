package com.olszi.model;

import javax.persistence.*;

/**
 * Created by MOlszi on 2016-08-31.
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

    public Trainset(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public Trainset() {
    }

    public Long getTrainsetID() {
        return trainsetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
