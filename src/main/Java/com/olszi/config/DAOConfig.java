package com.olszi.config;

import org.springframework.beans.factory.annotation.Autowired;
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


}
