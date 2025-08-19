package com.ecomerce.api.domain.address;

import java.util.UUID;

public record AddressResponseDTO(UUID id,
                                 String cep,
                                 String street,
                                 String city,
                                 String uf,
                                 String complement,
                                 Integer number,
                                 Boolean defaultAddress) {
}