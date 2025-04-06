package com.jeffrey.E_COMMERCE_APP.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeffrey.E_COMMERCE_APP.dtos.ProductRequest;
import com.jeffrey.E_COMMERCE_APP.models.Product;
import com.jeffrey.E_COMMERCE_APP.repository.ProductRepository;
import com.jeffrey.E_COMMERCE_APP.services.ProductService;

import lombok.AllArgsConstructor;


@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        List <Product>  products = productRepository.findAll();
        return products;
    }
    @Override
    public Product getById(Long id) {
        Product  product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        return product;
    }
    @Override
    public Product create(ProductRequest productRequest) {
        Product product = new  Product(productRequest.name(), productRequest.price());
        productRepository.save(product);
        return product;
    }
    @Override
    public Product update(Long id, ProductRequest productRequest) {
        Product  product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        productRepository.save(product);
        return product;
        
    }
    @Override
    public void delete(Long id) {
        Product  product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        productRepository.delete(product);
        
    }
    
}
