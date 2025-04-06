package com.jeffrey.E_COMMERCE_APP.services;

import java.util.List;

import com.jeffrey.E_COMMERCE_APP.dtos.ProductRequest;
import com.jeffrey.E_COMMERCE_APP.models.Product;

public interface ProductService {

    List<Product> getAll();
    Product  getById(Long id);
    Product create(ProductRequest productRequest);
    Product update(Long id, ProductRequest productRequest);
    void delete(Long id);
    
}
