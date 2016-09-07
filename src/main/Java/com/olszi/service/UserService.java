package com.olszi.service;

import com.olszi.model.User;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-31.
 */
public interface UserService {

    public void create(User user);

    public void update(User user);

    public void delete(User user);

    public User getById(Long id);

    public List<User> findByLogin(String login);
}
