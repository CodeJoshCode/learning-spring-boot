package com.airblox.learningspringboot.controller;

import java.util.HashMap;
import java.util.Map;

import com.airblox.learningspringboot.model.Product;
import com.airblox.learningspringboot.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController{
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method=RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        System.out.println(product.getName());
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED); 
    }

    @RequestMapping(value = "/products/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) throws ProductNotFoundException{
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value="/products")
    public ResponseEntity<Object> getProduct(
        @RequestParam(value = "name", required=false, defaultValue="honey") String name){
            return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id)
    {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Successfully deleted Product", HttpStatus.OK);
    }


}