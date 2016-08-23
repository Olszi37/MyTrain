package com.olszi.config;

import com.olszi.DAO.UserAuthDAO;
import com.olszi.DAO.UserAuthDAOImpl;
import com.olszi.DAO.UserDAO;
import com.olszi.DAO.UserDAOImpl;
import com.olszi.service.UserAuthService;
import com.olszi.service.UserAuthServiceImpl;
import com.olszi.service.UserService;
import com.olszi.service.UserServiceImpl;
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
    public UserAuthDAO userAuthDAO(){
        return new UserAuthDAOImpl(hibernateConfig.sessionFactory().getObject());
    }

    @Bean
    public UserAuthService userAuthService(){
        return new UserAuthServiceImpl(userAuthDAO());
    }
}
