package com.npi.order.write.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CreateOrderRequest(
    @NotBlank String customerId,
    @NotBlank String productName,
    @NotNull @Min(1) Integer quantity,
    @NotNull @DecimalMin("0.01") BigDecimal totalPrice
) {}