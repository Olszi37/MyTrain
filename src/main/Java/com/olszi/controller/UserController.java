package com.olszi.controller;

import com.olszi.model.User;
import com.olszi.model.UserAuth;
import com.olszi.model.UserRole;
import com.olszi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Long create(HttpServletRequest httpServletRequest){
        //User user = new User();

//        user.setName(httpServletRequest.getHeader("name"));
//        user.setLastName(httpServletRequest.getHeader("lastName"));
//        user.setEmail(httpServletRequest.getHeader("email"));

        UserAuth userAuth = new UserAuth();

        userAuth.setLogin(httpServletRequest.getHeader("login"));
        userAuth.setPassword(httpServletRequest.getHeader("password"));
        userAuth.setRole(UserRole.USER);

        //userService.create(user);
        return userService.createUserAuth(userAuth);
    }
}
