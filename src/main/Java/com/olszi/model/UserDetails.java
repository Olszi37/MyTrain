package com.olszi.model;

import javax.persistence.*;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity
@Table(name = "userDetails")
public class UserDetails {

    @Id
    @Column(name = "userID")
    @OneToOne(targetEntity = User.class)
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    public UserDetails(User user, String name, String surname, String email) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public UserDetails() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
