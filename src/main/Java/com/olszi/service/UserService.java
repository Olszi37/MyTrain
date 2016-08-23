package com.olszi.service;

import com.olszi.model.User;
import com.olszi.model.UserAuth;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-19.
 */
public interface UserService {

    public void create(User user);

    public List<User> getAll();
}
