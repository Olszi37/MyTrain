package com.olszi.model;

import javax.persistence.*;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long userID;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private UserRole role;

    public User(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public Long getUserID() {
        return userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
