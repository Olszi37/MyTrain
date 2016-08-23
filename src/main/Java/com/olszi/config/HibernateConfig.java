package com.olszi.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Created by MOlszi on 2016-08-19.
 */

@Configuration
@ComponentScan(basePackages = "com.olszi")
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource bean = new BasicDataSource();

        bean.setUrl(env.getProperty("jdbc.url"));
        bean.setUsername(env.getProperty("jdbc.username"));
        bean.setPassword(env.getProperty("jdbc.password"));
        bean.setDriverClassName(env.getProperty("jdbc.driverClassName"));

        return bean;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();

        bean.setDataSource(dataSource());
        bean.setPackagesToScan("com.olszi.model");

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.showSql", env.getProperty("hibernate.showSql"));
        hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));

        bean.setHibernateProperties(hibernateProperties);
        return bean;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager bean = new HibernateTransactionManager();
        bean.setSessionFactory(sessionFactory().getObject());

        return bean;
    }
}
