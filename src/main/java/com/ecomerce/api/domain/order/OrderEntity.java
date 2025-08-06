package com.ecomerce.api.domain.order;


import com.ecomerce.api.domain.customer.CustomerEntity;
import com.ecomerce.api.domain.product.ProductEntity;
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
@Table(name = "customer_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String paymentMethod;
    private String status;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductEntity> products = new ArrayList<>();

    private Date orderDate;
    private BigDecimal totalPrice;
    private Integer discont;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
