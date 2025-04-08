package com.jeffrey.E_COMMERCE_APP;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jeffrey.E_COMMERCE_APP.models.Bill;
import com.jeffrey.E_COMMERCE_APP.models.Customer;
import com.jeffrey.E_COMMERCE_APP.models.Product;
import com.jeffrey.E_COMMERCE_APP.models.ProductItem;
import com.jeffrey.E_COMMERCE_APP.repository.BillRepository;
import com.jeffrey.E_COMMERCE_APP.repository.CustomerRepository;
import com.jeffrey.E_COMMERCE_APP.repository.ProductItemRepository;
import com.jeffrey.E_COMMERCE_APP.repository.ProductRepository;

@SpringBootApplication
public class ECommerceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceAppApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            CustomerRepository customerRepository,
            ProductRepository productRepository,
            ProductItemRepository productItemRepository,
            BillRepository billRepository) {
        return args -> {
            // 1. Création des clients
            Customer cust1 = new Customer("John Doe", "john.doe@gmail.com");
            Customer cust2 = new Customer("Jane Smith", "jane.smith@yahoo.com");
            Customer cust3 = new Customer("Robert Johnson", "robert.j@hotmail.com");
            Customer cust4 = new Customer("Emily Davis", "emily.d@outlook.com");
            Customer cust5 = new Customer("Michael Brown", "michael.b@gmail.com");

            customerRepository.saveAll(List.of(cust1, cust2, cust3, cust4, cust5));

            // 2. Création des produits
            Product p1 = new Product("Laptop", 999.99);
            Product p2 = new Product("Smartphone", 699.99);
            Product p3 = new Product("Headphones", 149.99);
            Product p4 = new Product("Keyboard", 79.99);
            Product p5 = new Product("Mouse", 29.99);
            Product p6 = new Product("Monitor", 199.99);
            Product p7 = new Product("Tablet", 349.99);
            Product p8 = new Product("Smartwatch", 249.99);
            Product p9 = new Product("Printer", 179.99);
            Product p10 = new Product("External HDD", 89.99);

            productRepository.saveAll(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

            // 3. Création des factures et items
            Date today = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(today);

            // Facture 1
            cal.add(Calendar.DATE, -5);
            Date date1 = cal.getTime();
            Bill bill1 = new Bill(cust1, date1, cust1.getId());
            billRepository.save(bill1);

            ProductItem item1 = new ProductItem(bill1, 1, p1.getId(), p1);
            ProductItem item2 = new ProductItem(bill1, 2, p3.getId(), p3);
            productItemRepository.saveAll(List.of(item1, item2));

            // Facture 2
            cal.add(Calendar.DATE, 3);
            Date date2 = cal.getTime();
            Bill bill2 = new Bill(cust2, date2, cust2.getId());
            billRepository.save(bill2);

            ProductItem item3 = new ProductItem(bill2, 1, p2.getId(), p2);
            ProductItem item4 = new ProductItem(bill2, 1, p5.getId(), p5);
            ProductItem item5 = new ProductItem(bill2, 1, p8.getId(), p8);
            productItemRepository.saveAll(List.of(item3, item4, item5));

            // Facture 3
            cal.add(Calendar.DATE, 2);
            Date date3 = cal.getTime();
            Bill bill3 = new Bill(cust3, date3, cust3.getId());
            billRepository.save(bill3);

            ProductItem item6 = new ProductItem(bill3, 3, p4.getId(), p4);
            ProductItem item7 = new ProductItem(bill3, 1, p6.getId(), p6);
            productItemRepository.saveAll(List.of(item6, item7));

            // Facture 4
            cal.add(Calendar.DATE, 1);
            Date date4 = cal.getTime();
            Bill bill4 = new Bill(cust1, date4, cust1.getId());
            billRepository.save(bill4);

            ProductItem item8 = new ProductItem(bill4, 1, p7.getId(), p7);
            ProductItem item9 = new ProductItem(bill4, 2, p10.getId(), p10);
            productItemRepository.saveAll(List.of(item8, item9));

            // Facture 5
            cal.add(Calendar.DATE, 4);
            Date date5 = cal.getTime();
            Bill bill5 = new Bill(cust4, date5, cust4.getId());
            billRepository.save(bill5);

            ProductItem item10 = new ProductItem(bill5, 1, p9.getId(), p9);
            productItemRepository.save(item10);

            // Mise à jour des relations
            bill1.setProductItems(List.of(item1, item2));
            bill2.setProductItems(List.of(item3, item4, item5));
            bill3.setProductItems(List.of(item6, item7));
            bill4.setProductItems(List.of(item8, item9));
            bill5.setProductItems(List.of(item10));

            billRepository.saveAll(List.of(bill1, bill2, bill3, bill4, bill5));

            // Mise à jour des clients avec leurs factures
            cust1.setBills(List.of(bill1, bill4));
            cust2.setBills(List.of(bill2));
            cust3.setBills(List.of(bill3));
            cust4.setBills(List.of(bill5));

            customerRepository.saveAll(List.of(cust1, cust2, cust3, cust4));
        };
    }
}