package com.olszi.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by MOlszi on 2016-08-19.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {HibernateConfig.class, WebAppConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
