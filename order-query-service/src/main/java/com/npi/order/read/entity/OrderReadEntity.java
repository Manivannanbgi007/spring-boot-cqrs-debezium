package com.npi.order.read.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderReadEntity {

    @Id
    private String id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "product_name")
    private String productName;

    private Integer quantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}