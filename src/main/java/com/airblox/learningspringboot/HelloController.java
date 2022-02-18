package com.airblox.learningspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Author: Josh Simmons
Date: 2/14/22
Main controller class from https://spring.io/guides/gs/spring-boot/
for a simple hello world application.
*/
@RestController
public class HelloController {

    @Value("${response.text:\"I am a happy man\"}")
    private String responseText;

    // mapping at / to return a hello world text in the response body
    @GetMapping("/")
    public String index(){
        return responseText;
    }
}