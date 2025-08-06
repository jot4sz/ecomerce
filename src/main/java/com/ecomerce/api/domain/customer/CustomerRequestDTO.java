package com.ecomerce.api.domain.customer;


public record CustomerRequestDTO( String fullName,
                                  String email,
                                  String phone,
                                  String cpf,
                                  String dateBirth
) {
}
