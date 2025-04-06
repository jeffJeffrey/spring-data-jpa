package com.jeffrey.E_COMMERCE_APP.models;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private Long productID;

    @ManyToOne(fetch = FetchType.LAZY)
    private Bill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    

    public ProductItem(Bill bill, int quantity, Long productID, Product product) {
        this.quantity = quantity;
        this.bill = bill;
        this.product = product;
        this.productID = productID;
    }
    
}