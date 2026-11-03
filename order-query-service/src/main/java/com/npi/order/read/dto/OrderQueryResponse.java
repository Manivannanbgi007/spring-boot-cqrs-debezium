package com.npi.order.read.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderQueryResponse(
    String id,
    String customerId,
    String productName,
    Integer quantity,
    BigDecimal totalPrice,
    String status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
