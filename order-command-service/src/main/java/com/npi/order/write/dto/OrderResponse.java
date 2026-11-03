package com.npi.order.write.dto;

import java.math.BigDecimal;

public record OrderResponse(
    String id,
    String customerId,
    String productName,
    Integer quantity,
    BigDecimal totalPrice,
    String status
) {}