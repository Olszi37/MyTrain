package com.olszi.service;

import com.olszi.model.UserDetails;

/**
 * Created by MOlszi on 2016-08-31.
 */
public interface UserDetailsService {

    public void create(UserDetails userDetails);

    public void update(UserDetails userDetails);

    public void delete(UserDetails userDetails);
}
