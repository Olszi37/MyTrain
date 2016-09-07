package com.olszi.service;

import com.olszi.model.UserDetails;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-31.
 */
public interface UserDetailsService {

    public void create(UserDetails userDetails);

    public void update(UserDetails userDetails);

    public void delete(UserDetails userDetails);

    public UserDetails getById(Long id);

    public List<UserDetails> findByEmail(String email);
}
