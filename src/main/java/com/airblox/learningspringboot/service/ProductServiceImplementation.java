package com.airblox.learningspringboot.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.airblox.learningspringboot.model.Product;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation implements ProductService {
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

    @Override
    public void createProduct(Product product) {
        System.out.println(product.getName());
        productRepo.put(product.getId(), product);
        
    }

    @Override
    public void updateProduct(String id, Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepo.remove(id);
        
    }

    @Override
    public Collection<Product> getProducts() {
        return productRepo.values();
    }
    
}
