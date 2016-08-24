package com.olszi.controller;

import com.olszi.model.user.User;
import com.olszi.model.user.UserAuth;
import com.olszi.model.user.UserRole;
import com.olszi.service.UserAuthService;
import com.olszi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by MOlszi on 2016-08-19.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserAuthService userAuthService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(HttpServletRequest httpServletRequest){

        UserAuth userAuth = prepareUserAuth(httpServletRequest);

        Long id = userAuthService.create(userAuth);

        User user = prepareUser(httpServletRequest, id);

        userService.create(user);

        return ResponseEntity.ok("created");
    }

    public UserAuth prepareUserAuth(HttpServletRequest httpServletRequest){
        UserAuth userAuth = new UserAuth();

        userAuth.setLogin(httpServletRequest.getHeader("login"));
        userAuth.setPassword(httpServletRequest.getHeader("password"));
        userAuth.setRole(UserRole.USER);
        userAuth.setCreated();

        return userAuth;
    }

    public User prepareUser(HttpServletRequest httpServletRequest, Long id){
        User user = new User();

        user.setId(id);
        user.setName(httpServletRequest.getHeader("name"));
        user.setLastName(httpServletRequest.getHeader("lastName"));
        user.setEmail(httpServletRequest.getHeader("email"));

        return user;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(HttpServletRequest httpServletRequest){

        Long id = (long) httpServletRequest.getIntHeader("id");
        User user = userService.getById(id);

        userService.delete(user);
    }
}
