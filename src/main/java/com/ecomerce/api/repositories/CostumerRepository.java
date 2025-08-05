package com.ecomerce.api.repositories;

import com.ecomerce.api.domain.costumer.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CostumerRepository extends JpaRepository<Costumer, UUID> {
}
