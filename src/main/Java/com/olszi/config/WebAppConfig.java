package com.olszi.config;

import org.hibernate.annotations.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-19.
 */

@EnableWebMvc
@ComponentScan(basePackages = "com.olszi")
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

    @Bean
    MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("utf-8");
        return multipartResolver;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addFormatters(FormatterRegistry registry) {

            }

            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

            }

            @Override
            public Validator getValidator() {
                return null;
            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

            }

            @Override
            public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

            }

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {

            }

            @Override
            public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

            }

            @Override
            public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {

            }

            @Override
            public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

            }

            @Override
            public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {

            }

            @Override
            public MessageCodesResolver getMessageCodesResolver() {
                return null;
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

            }

            @Override
            public void configureViewResolvers(ViewResolverRegistry registry) {

            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {

            }

            @Override
            public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/").allowedOrigins("*");
            }
        };
    }
}
