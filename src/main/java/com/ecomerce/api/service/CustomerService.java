package com.ecomerce.api.service;

import com.ecomerce.api.domain.customer.CustomerEntity;
import com.ecomerce.api.domain.customer.CustomerPatchRequestDTO;
import com.ecomerce.api.domain.customer.CustomerRequestDTO;
import com.ecomerce.api.domain.customer.CustomerResponseDTO;
import com.ecomerce.api.domain.mapper.CustomerMapper;
import com.ecomerce.api.exception.CustomerNotFoundException;
import com.ecomerce.api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    public CustomerResponseDTO createCustomer(CustomerRequestDTO data){
        return customerMapper.toDTO(
                customerRepository.save(
                        customerMapper.toEntity(data)));
    }

    public CustomerResponseDTO getCustomerById(UUID id) {
        return customerMapper.toDTO(
                this.customerRepository.findById(id)
                        .orElseThrow(CustomerNotFoundException::new));
    }

    public CustomerResponseDTO updatePartialById(UUID customerId, CustomerPatchRequestDTO data) {
        CustomerEntity existingCustomer = this.customerRepository.findById(customerId)
                .orElseThrow(CustomerNotFoundException::new);
        customerMapper.updatePartialCustomerFromDTO(data, existingCustomer);
        return customerMapper.toDTO(
                customerRepository.save(existingCustomer));
    }

    public void deleteById(UUID id){
        customerRepository.delete(
                customerRepository.findById(id)
                        .orElseThrow(CustomerNotFoundException::new));
    }
}
