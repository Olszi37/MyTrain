package com.olszi.service;

import com.olszi.DAO.user.UserAuthDAO;
import com.olszi.model.user.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-23.
 */

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private UserAuthDAO userAuthDAO;

    @Autowired
    public UserAuthServiceImpl(UserAuthDAO userAuthDAO) {
        this.userAuthDAO = userAuthDAO;
    }

    @Override
    public Long create(UserAuth userAuth) {
        return userAuthDAO.create(userAuth);
    }

    @Override
    public List<UserAuth> getAll() {
        return userAuthDAO.getAll();
    }

    @Override
    public void delete(UserAuth userAuth) {
        userAuthDAO.delete(userAuth);
    }

    @Override
    public UserAuth getByLogin(String login) {
        return userAuthDAO.getByLogin(login);
    }

    @Override
    public UserAuth getById(Long id) {
        return userAuthDAO.getById(id);
    }

    @Override
    public void changePassword(UserAuth userAuth, String password) {
        userAuthDAO.changePassword(userAuth, password);
    }
}
