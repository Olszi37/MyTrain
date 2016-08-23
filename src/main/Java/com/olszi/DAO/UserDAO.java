package com.olszi.DAO;

import com.olszi.model.user.User;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-19.
 */
public interface UserDAO {

    public void create(User user);

    public List<User> getAll();
}
