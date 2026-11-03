package com.npi.order.write.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.npi.order.write.dto.CreateOrderRequest;
import com.npi.order.write.dto.OrderResponse;
import com.npi.order.write.dto.UpdateOrderRequest;
import com.npi.order.write.service.OrderCommandService;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderCommandController {

    private final OrderCommandService orderCommandService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderCommandService.createOrder(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrderStatus(
            @PathVariable String id,
            @Valid @RequestBody UpdateOrderRequest request) {
        return ResponseEntity.ok(orderCommandService.updateOrderStatus(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        orderCommandService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}