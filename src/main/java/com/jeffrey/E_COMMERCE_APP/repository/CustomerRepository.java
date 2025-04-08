package com.jeffrey.E_COMMERCE_APP.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jeffrey.E_COMMERCE_APP.models.Customer;


public interface CustomerRepository extends JpaRepository <Customer, Long> {
    
    Customer findByEmail(String email);
    
}
