package com.npi.order.write.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateOrderRequest(
    @NotBlank String status
) {}