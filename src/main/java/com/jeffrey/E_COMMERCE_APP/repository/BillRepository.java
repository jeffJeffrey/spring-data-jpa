package com.jeffrey.E_COMMERCE_APP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeffrey.E_COMMERCE_APP.models.Bill;

public interface BillRepository  extends JpaRepository <Bill, Long>{
    
}
