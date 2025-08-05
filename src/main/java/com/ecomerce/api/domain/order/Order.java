package com.ecomerce.api.domain.order;


import com.ecomerce.api.domain.costumer.Costumer;
import com.ecomerce.api.domain.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private UUID id;

    private String paymentMethod;
    private String status;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> products = new ArrayList<>();

    private Date orderDate;
    private BigDecimal totalPrice;
    private Integer discont;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;
}
