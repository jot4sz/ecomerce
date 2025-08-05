package com.ecomerce.api.domain.address;


import com.ecomerce.api.domain.costumer.Costumer;
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
public class Address {

    @Id
    @GeneratedValue
    private UUID id;

    private String street;
    private String cep;
    private String city;
    private String uf;
    private String complement;
    private Integer number;
    private Boolean defaultAddress;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

}
