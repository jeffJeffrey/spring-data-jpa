package com.jeffrey.E_COMMERCE_APP.services;

import java.util.List;

import com.jeffrey.E_COMMERCE_APP.dtos.BillRequest;
import com.jeffrey.E_COMMERCE_APP.models.Bill;

public interface BillService {

    
    Bill GetById(Long id);
    List <Bill> getAll();
    Bill create(BillRequest billRequest);
}
