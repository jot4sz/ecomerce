package com.ecomerce.api.controller;

import com.ecomerce.api.domain.customer.CustomerEntity;
import com.ecomerce.api.domain.customer.CustomerRequestDTO;
import com.ecomerce.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerEntity> create(@RequestBody CustomerRequestDTO body){
        CustomerEntity newCustomer = this.customerService.createCustomer(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }
}
