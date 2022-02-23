package com.airblox.learningspringboot.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("Remote host: " + request.getRemoteHost());
        System.out.println("Remote address: " + request.getRemoteAddr());
        filterChain.doFilter(request, response);
        // TODO: figure out how response filtering work
    }

    @Override
    public void init(FilterConfig filterConfig){}
    
}
