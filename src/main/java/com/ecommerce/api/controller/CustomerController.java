package com.ecommerce.api.controller;

import com.ecommerce.api.domain.customer.CustomerPatchRequestDTO;
import com.ecommerce.api.domain.customer.CustomerRequestDTO;
import com.ecommerce.api.domain.customer.CustomerResponseDTO;
import com.ecommerce.api.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> create(@Valid @RequestBody CustomerRequestDTO body){
        CustomerResponseDTO newCustomer = this.customerService.createCustomer(body);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(newCustomer.id())
                .toUri();
        return ResponseEntity.created(location).body(newCustomer);
    }

    @GetMapping("{customerId}")
    public ResponseEntity<CustomerResponseDTO> getById(@PathVariable UUID customerId){
        CustomerResponseDTO customerResponseDTO = this.customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customerResponseDTO);
    }

    @PatchMapping("{customerId}")
    public ResponseEntity<CustomerResponseDTO> updatePartialById(@PathVariable UUID customerId, @Valid @RequestBody CustomerPatchRequestDTO body){
        CustomerResponseDTO updatedCustomer = this.customerService.updatePartialById(customerId, body);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID customerId){
        this.customerService.deleteById(customerId);
        return ResponseEntity.noContent().build();
    }
}
