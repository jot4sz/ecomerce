package com.ecomerce.api.domain.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Null;

import java.util.Date;

public record CustomerPatchRequestDTO(String fullName,
                                      @Email(message = "Invalid email format")
                                      String email,
                                      String phone,
                                      @Null
                                      String cpf,
                                      @Null
                                      Date dateBirth
                                      ){
}
