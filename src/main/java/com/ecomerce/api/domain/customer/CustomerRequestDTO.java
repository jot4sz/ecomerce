package com.ecomerce.api.domain.customer;


import com.ecomerce.api.validation.CPF;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record CustomerRequestDTO(@NotBlank
                                 String fullName,
                                 @Email(message = "Invalid email format")
                                 String email,
                                 @NotBlank
                                 String phone,
                                 @CPF
                                 String cpf,
                                 @JsonFormat(pattern = "dd/MM/yyyy")
                                 Date dateBirth
) {
}
