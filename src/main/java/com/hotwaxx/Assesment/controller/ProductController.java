package com.hotwaxx.Assesment.controller;

import com.hotwaxx.Assesment.entity.Person;
import com.hotwaxx.Assesment.entity.Product;
import com.hotwaxx.Assesment.repository.ProductRepository;
import com.hotwaxx.Assesment.util.GenerateRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @PostMapping
    public Product crr(@RequestBody Product product){
        GenerateRandom obj  = new GenerateRandom() ;
        product.setProductId(obj.generateValue() );

        return productRepository.save(product) ;
    }



}
