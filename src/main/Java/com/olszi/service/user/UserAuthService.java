package com.olszi.service.user;

import com.olszi.model.user.UserAuth;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-23.
 */
public interface UserAuthService {

    public Long create(UserAuth userAuth);

    public List<UserAuth> getAll();

    public void delete(UserAuth userAuth);

    public UserAuth getByLogin(String login);

    public UserAuth getById(Long id);

    public void changePassword(UserAuth userAuth, String password);
}
