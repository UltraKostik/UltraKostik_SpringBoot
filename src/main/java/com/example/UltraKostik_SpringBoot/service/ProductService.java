package com.example.UltraKostik_SpringBoot.service;

import com.example.UltraKostik_SpringBoot.model.User;
import com.example.UltraKostik_SpringBoot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(User product){
        productRepository.save(product);
    }

    public List<User> getAllProducts(){
        return productRepository.findAll();
    }
}
