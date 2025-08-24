package com.ecommerce.api.repositories;

import com.ecommerce.api.domain.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
    List<AddressEntity> findByCustomerId(UUID customerId);

    Optional<AddressEntity> findByIdAndCustomerId(UUID addressId, UUID customerId);
}
