package com.airblox.learningspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {

    @Autowired
    private TestRestTemplate template;

    /*
        perform a GET request and expect a success status
        and a response with the basic string we provide at that input
    */
    @Test
    public void getHello() throws Exception{
        ResponseEntity<String> response =  template.getForEntity("/", String.class);
        assertThat(response.getBody()).isEqualTo("Greetings from Josh in Spring Boot!");
    }
    
}
