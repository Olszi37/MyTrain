package com.olszi.config;

import com.olszi.DAO.TrainsetDAO;
import com.olszi.DAO.TrainsetDAOImpl;
import com.olszi.DAO.user.UserAuthDAO;
import com.olszi.DAO.user.UserAuthDAOImpl;
import com.olszi.DAO.user.UserDAO;
import com.olszi.DAO.user.UserDAOImpl;
import com.olszi.service.TrainsetService;
import com.olszi.service.TrainsetServiceImpl;
import com.olszi.service.user.UserAuthService;
import com.olszi.service.user.UserAuthServiceImpl;
import com.olszi.service.user.UserService;
import com.olszi.service.user.UserServiceImpl;
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

    @Bean
    public TrainsetDAO trainsetDAO(){
        return new TrainsetDAOImpl(hibernateConfig.sessionFactory().getObject());
    }

    @Bean
    public TrainsetService trainsetService(){
        return new TrainsetServiceImpl(trainsetDAO());
    }
}
