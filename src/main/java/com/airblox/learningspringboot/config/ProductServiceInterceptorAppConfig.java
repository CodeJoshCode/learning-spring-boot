package com.airblox.learningspringboot.config;

import com.airblox.learningspringboot.controller.ProductServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Component
public class ProductServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    ProductServiceInterceptor productServiceInterceptor;

    @Autowired
    LocaleChangeInterceptor localeChangeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(productServiceInterceptor);
        registry.addInterceptor(localeChangeInterceptor);
    }
}
