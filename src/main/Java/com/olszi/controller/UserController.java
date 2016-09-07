package com.olszi.controller;

import com.olszi.model.User;
import com.olszi.model.UserDetails;
import com.olszi.model.UserRole;
import com.olszi.service.UserDetailsService;
import com.olszi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by MOlszi on 2016-08-31.
 */

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(HttpServletRequest httpServletRequest){

        User user = prepareUser(httpServletRequest);
        UserDetails userDetails = prepareUserDetails(httpServletRequest);

        userService.create(user);

        userDetails.setUser(user);

        userDetailsService.create(userDetails);
    }

    public User prepareUser(HttpServletRequest httpServletRequest){
        User user = new User();

        user.setLogin(httpServletRequest.getHeader("login"));
        user.setPassword(httpServletRequest.getHeader("password"));
        user.setRole(UserRole.USER);

        return user;
    }

    public UserDetails prepareUserDetails(HttpServletRequest httpServletRequest){
        UserDetails userDetails = new UserDetails();

        userDetails.setName(httpServletRequest.getHeader("name"));
        userDetails.setSurname(httpServletRequest.getHeader("surname"));
        userDetails.setEmail(httpServletRequest.getHeader("email"));

        return userDetails;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody UserDetails get(HttpServletRequest httpServletRequest){
        Long id = new Long(httpServletRequest.getHeader("id"));

        return userDetailsService.getById(id);
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public @ResponseBody List<UserDetails> findByEmail(HttpServletRequest httpServletRequest){
        return userDetailsService.findByEmail(httpServletRequest.getHeader("email"));
    } // return void table
}
