package com.jeffrey.E_COMMERCE_APP.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeffrey.E_COMMERCE_APP.dtos.BillRequest;
import com.jeffrey.E_COMMERCE_APP.dtos.ProducItemRequest;
import com.jeffrey.E_COMMERCE_APP.models.Bill;
import com.jeffrey.E_COMMERCE_APP.models.Customer;
import com.jeffrey.E_COMMERCE_APP.models.Product;
import com.jeffrey.E_COMMERCE_APP.models.ProductItem;
import com.jeffrey.E_COMMERCE_APP.repository.BillRepository;
import com.jeffrey.E_COMMERCE_APP.repository.CustomerRepository;
import com.jeffrey.E_COMMERCE_APP.repository.ProductItemRepository;
import com.jeffrey.E_COMMERCE_APP.repository.ProductRepository;
import com.jeffrey.E_COMMERCE_APP.services.BillService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Override
    public Bill GetById(Long id) {
        Bill bill = billRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("customer not found"));
        return bill;
    }

    @Override
    public List<Bill> getAll() {
        List<Bill> bills = billRepository.findAll();
        return bills;
    }

    @Override
    public Bill create(BillRequest billRequest) {
        Customer customer = customerRepository.findById(billRequest.customerID())
                .orElseThrow(
                        () -> new IllegalArgumentException("Customer not found with id: " + billRequest.customerID()));

        Bill bill = new Bill(customer, new Date(), billRequest.customerID());
        Bill savedBill = billRepository.save(bill);

    if (savedBill.getProductItems() == null) {
        savedBill.setProductItems(new ArrayList<>());
    }

    for (ProducItemRequest pi : billRequest.productItems()) {
        Product product = productRepository.findById(pi.productID())
            .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + pi.productID()));

        ProductItem productItem = new ProductItem(
            savedBill, 
            pi.quantity(), 
            pi.productID(), 
            product
        );
        
        ProductItem savedItem = productItemRepository.save(productItem);
        savedBill.getProductItems().add(savedItem);
    }

    return billRepository.save(savedBill);
    }

}
