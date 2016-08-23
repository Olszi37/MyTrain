package com.olszi.service;

import com.olszi.DAO.UserAuthDAO;
import com.olszi.model.user.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
