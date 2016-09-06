package com.olszi.service;

import com.olszi.dao.UserDetailsDAO;
import com.olszi.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDetailsDAO userDetailsDAO;

    @Autowired
    public UserDetailsServiceImpl(UserDetailsDAO userDetailsDAO) {
        this.userDetailsDAO = userDetailsDAO;
    }

    @Override
    public void create(UserDetails userDetails) {
        userDetailsDAO.create(userDetails);
    }

    @Override
    public void update(UserDetails userDetails) {
        userDetailsDAO.update(userDetails);
    }

    @Override
    public void delete(UserDetails userDetails) {
        userDetailsDAO.delete(userDetails);
    }
}
