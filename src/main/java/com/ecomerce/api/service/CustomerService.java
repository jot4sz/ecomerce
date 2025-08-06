package com.ecomerce.api.service;

import com.ecomerce.api.domain.customer.CustomerEntity;
import com.ecomerce.api.domain.customer.CustomerRequestDTO;
import com.ecomerce.api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity createCustomer(CustomerRequestDTO data){
        CustomerEntity newCustomer = new CustomerEntity();

        newCustomer.setFullName(data.fullName());
        newCustomer.setEmail(data.email());
        newCustomer.setPhone(data.phone());
        newCustomer.setCpf(data.cpf());
        newCustomer.setDateBirth(new Date(data.dateBirth()));

        customerRepository.save(newCustomer);

        return newCustomer;
    }
}
