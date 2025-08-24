package com.ecommerce.api.service;

import com.ecommerce.api.domain.address.AddressEntity;
import com.ecommerce.api.domain.address.AddressRequestDTO;
import com.ecommerce.api.domain.address.AddressResponseDTO;
import com.ecommerce.api.domain.customer.CustomerEntity;
import com.ecommerce.api.domain.mapper.AddressMapper;
import com.ecommerce.api.exception.AddressNotFoundException;
import com.ecommerce.api.exception.CustomerNotFoundException;
import com.ecommerce.api.repositories.AddressRepository;
import com.ecommerce.api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressMapper addressMapper;

    public AddressResponseDTO addAddressToCustomer(UUID customerId, AddressRequestDTO data){
        CustomerEntity customer = this.customerRepository.findById(customerId)
                .orElseThrow(CustomerNotFoundException::new);

        return addressMapper.toDTO(
                this.addressRepository.save(
                        addressMapper.toEntity(data, customer)));
    }

    public List<AddressResponseDTO> getAddressesByCustomerId(UUID customerId) {
        CustomerEntity customer = this.customerRepository.findById(customerId)
                .orElseThrow(CustomerNotFoundException::new);

        return addressMapper.toDTOList(
                this.addressRepository.findByCustomerId(customer.getId()));
    }

    public AddressResponseDTO getAddressById(UUID customerId, UUID addressId) {
        AddressEntity address = this.addressRepository.findByIdAndCustomerId(addressId, customerId)
                .orElseThrow(() -> new AddressNotFoundException("Address not found for this customer"));
        return addressMapper.toDTO(address);
    }

    public void deleteById(UUID customerId, UUID addressId) {
        AddressEntity address = this.addressRepository.findByIdAndCustomerId(addressId, customerId)
                .orElseThrow(() -> new AddressNotFoundException("Address not found for this customer"));
        this.addressRepository.delete(address);
    }
}
