package com.ecommerce.api.controller;

import com.ecommerce.api.domain.address.AddressRequestDTO;
import com.ecommerce.api.domain.address.AddressResponseDTO;
import com.ecommerce.api.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer/{customerId}/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponseDTO> addAddress(@PathVariable UUID customerId,@Valid @RequestBody AddressRequestDTO body){
        AddressResponseDTO address = addressService.addAddressToCustomer(customerId, body);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(address.id())
                .toUri();
        return ResponseEntity.created(location).body(address);
    }

    @GetMapping
    public ResponseEntity<List<AddressResponseDTO>> getAddresses(@PathVariable UUID customerId){
        List<AddressResponseDTO> addresses = addressService.getAddressesByCustomerId(customerId);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("{addressId}")
    public ResponseEntity<AddressResponseDTO> getById(@PathVariable UUID customerId, @PathVariable UUID addressId){
        AddressResponseDTO address = addressService.getAddressById(customerId, addressId);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("{addressId}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID customerId, @PathVariable UUID addressId){
        this.addressService.deleteById(customerId, addressId);
        return ResponseEntity.noContent().build();
    }
}
