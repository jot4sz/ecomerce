package com.ecommerce.api.domain.product;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDTO(UUID id,
                                 String name,
                                 String brand,
                                 String description,
                                 BigDecimal price,
                                 String technicalInfo,
                                 Boolean available) {
}
