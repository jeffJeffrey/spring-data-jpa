package com.jeffrey.E_COMMERCE_APP.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private Long customerID;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<ProductItem> productItems = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Bill(Date billingDate) {
        this.billingDate = billingDate;
    }

    public Bill(Customer customer, Date billingDate, Long customerID) {
        this.customer = customer;
        this.billingDate = billingDate;
        this.customerID = customerID;
    }

    
}
