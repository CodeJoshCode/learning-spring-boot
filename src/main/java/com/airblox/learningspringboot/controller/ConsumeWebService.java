package com.airblox.learningspringboot.controller;

import java.nio.charset.Charset;
import java.util.Arrays;

import com.airblox.learningspringboot.LearningSpringBootApplication;
import com.airblox.learningspringboot.model.Product;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeWebService {
    // if it's a bean, it can be autowired
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/template/products")
    public String getProductList(){
        HttpEntity<String> entity = new HttpEntity<>(getHeaders());
        return restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
    }

    // had to disable cors and csrf protection to use this and put, delete
    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProduct(@RequestBody Product product){
        HttpEntity<Product> entity = new HttpEntity<Product>(product, getHeaders());
        return restTemplate.exchange("http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        HttpEntity<Product> entity = new HttpEntity<Product>(product, getHeaders());
        return restTemplate.exchange("http://localhost:8080/products/" + id, HttpMethod.PUT, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") String id){
        HttpEntity<String> entity = new HttpEntity<>(getHeaders());
        return restTemplate.exchange("http://localhost:8080/products/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }


    // auth headers will always be the same in this case
    public static HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders(){{
            String auth = "user" + ":" + "password";
            byte[] encodedAuth = Base64.encodeBase64( 
            auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set("Authorization", authHeader);
        }};
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

}
