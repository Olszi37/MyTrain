package com.olszi.service;

import com.olszi.DAO.UserDAO;
import com.olszi.model.User;
import com.olszi.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-19.
 */

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void create(User user) {
        userDAO.create(user);
    }

    public Long createUserAuth(UserAuth userAuth){
        return userDAO.createUserAuth(userAuth);
    }

    public List<User> getAll() {
        return null;
    }
}
