package com.ecommerce.api.domain.customer;

import java.util.Date;
import java.util.UUID;

public record CustomerResponseDTO(UUID id,
                                  String fullName,
                                  String email,
                                  String phone,
                                  String cpf,
                                  Date dateBirth) {
}