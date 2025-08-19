package com.ecomerce.api.domain.address;


import com.ecomerce.api.domain.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String cep;
    private String street;
    private String city;
    private String uf;
    private String complement;
    private Integer number;
    private Boolean defaultAddress;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
