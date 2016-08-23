package com.olszi.model.user;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by MOlszi on 2016-08-23.
 */

@Entity
@Table(name = "userAuth")
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private UserRole role;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    public UserAuth(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
        created = LocalDateTime.now();
        modified = created;
    }

    public UserAuth() {
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(){
        created = LocalDateTime.now();
        modified = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified() {
        modified = LocalDateTime.now();
    }
}
