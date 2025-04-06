package com.jeffrey.E_COMMERCE_APP.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.jeffrey.E_COMMERCE_APP.dtos.ProductRequest;
import com.jeffrey.E_COMMERCE_APP.models.Product;
import com.jeffrey.E_COMMERCE_APP.services.ProductService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;


    @QueryMapping
    List<Product> getAllProducts(){
        return productService.getAll();
    }

    @QueryMapping
    Product getProductById(@Argument Long id){
        return productService.getById(id);
    }

    @MutationMapping
    Product createProduct(@Argument ProductRequest productRequest){
        return productService.create(productRequest);
    }

    @MutationMapping
    Product updateProduct(@Argument Long id, @Argument ProductRequest productRequest){
        return productService.update(id, productRequest);
    }

    @MutationMapping
    Boolean deleteProduct(@Argument Long id){
        productService.delete(id);
        return true;
    }
    
}
