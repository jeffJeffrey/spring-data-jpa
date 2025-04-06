package com.jeffrey.E_COMMERCE_APP.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.jeffrey.E_COMMERCE_APP.dtos.BillRequest;
import com.jeffrey.E_COMMERCE_APP.models.Bill;
import com.jeffrey.E_COMMERCE_APP.services.BillService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BillController {

    private final BillService billService;

    @QueryMapping
    List<Bill> getAllBills(){
        return billService.getAll();
    }
    @QueryMapping
    Bill getBillById(@Argument Long id){
        return billService.GetById(id);
    }


    @MutationMapping
    Bill createBill(@Argument BillRequest billRequest){
        return billService.create(billRequest);
    }


    
}