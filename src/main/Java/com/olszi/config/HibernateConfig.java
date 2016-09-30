package com.olszi.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
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
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();

        bean.setDataSource(dataSource());
        bean.setPackagesToScan("com.olszi.model");

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.put("hibernate.default_schema", env.getProperty("hibernate.default_schema"));
        hibernateProperties.put("hibernate.connection.CharSet", env.getProperty("hibernate.connection.CharSet"));
        hibernateProperties.put("hibernate.connection.characterEncoding", env.getProperty("hibernate.connection.characterEncoding"));
        hibernateProperties.put("hibernate.connection.useUnicode", env.getProperty("hibernate.connection.useUnicode"));

        bean.setHibernateProperties(hibernateProperties);
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() throws IOException {
        HibernateTransactionManager bean = new HibernateTransactionManager();
        bean.setSessionFactory(sessionFactory());

        return bean;
    }
}
