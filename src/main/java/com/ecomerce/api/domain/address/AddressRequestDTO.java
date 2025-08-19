package com.ecomerce.api.domain.address;

import jakarta.validation.constraints.*;

public record AddressRequestDTO(@NotBlank
                                @Size(max = 8)
                                String cep,
                                @NotBlank
                                String street,
                                @NotBlank
                                String city,
                                @NotBlank
                                @Size(max = 2)
                                String uf,
                                String complement,
                                @NotNull
                                @PositiveOrZero
                                Integer number,
                                @NotNull
                                Boolean defaultAddress) {
}