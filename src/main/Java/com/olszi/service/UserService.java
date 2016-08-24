package com.olszi.service;

import com.olszi.model.user.User;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-19.
 */
public interface UserService {

    public void create(User user);

    public User getById(Long id);

    public User getByEmail(String email);

    public void delete(User user);

    public List<User> getAll();
}
