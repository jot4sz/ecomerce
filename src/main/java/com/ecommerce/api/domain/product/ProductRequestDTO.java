package com.ecommerce.api.domain.product;

import java.math.BigDecimal;

public record ProductRequestDTO(String name,
                                String brand,
                                String description,
                                BigDecimal price,
                                String technicalInfo,
                                Boolean available
                                ) {
}
