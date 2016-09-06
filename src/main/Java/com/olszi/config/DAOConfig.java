package com.olszi.config;

import com.olszi.dao.UserDAO;
import com.olszi.dao.UserDAOImpl;
import com.olszi.dao.UserDetailsDAO;
import com.olszi.dao.UserDetailsDAOImpl;
import com.olszi.service.UserDetailsService;
import com.olszi.service.UserDetailsServiceImpl;
import com.olszi.service.UserService;
import com.olszi.service.UserServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by MOlszi on 2016-08-19.
 */

@Configuration
@ComponentScan(basePackages = "com.olszi")
public class DAOConfig {

    @Autowired
    private HibernateConfig hibernateConfig;

    @Bean
    public UserDAO userDAO(){
        return new UserDAOImpl(hibernateConfig.sessionFactory().getObject());
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl(userDAO());
    }

    @Bean
    public UserDetailsDAO userDetailsDAO(){
        return new UserDetailsDAOImpl(hibernateConfig.sessionFactory().getObject());
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl(userDetailsDAO());
    }
}
