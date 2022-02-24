package com.airblox.learningspringboot.controller;

import java.util.HashMap;
import java.util.Map;

import com.airblox.learningspringboot.model.Product;

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
    private static Map<String, Product> productRepo = new HashMap<>();
    static{
        Product honey = new Product();
        honey.setId("1");
        honey.setName("honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("almond");
        productRepo.put(almond.getId(), almond);
    }

    @RequestMapping(value = "/products", method=RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED); 
    }

    @RequestMapping(value = "/products/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) throws ProductNotFoundException{
        if(!productRepo.containsKey(id)){
            throw new ProductNotFoundException();
        }
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value="/products")
    public ResponseEntity<Object> getProduct(
        @RequestParam(value = "name", required=false, defaultValue="honey") String name){
            return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id)
    {
        productRepo.remove(id);
        return new ResponseEntity<>("Successfully deleted Product", HttpStatus.OK);
    }


}