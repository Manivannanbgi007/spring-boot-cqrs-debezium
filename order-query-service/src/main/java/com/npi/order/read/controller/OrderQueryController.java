package com.npi.order.read.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.npi.order.read.dto.OrderQueryResponse;
import com.npi.order.read.service.OrderQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderQueryController {

    private final OrderQueryService orderQueryService;

    @GetMapping
    public ResponseEntity<List<OrderQueryResponse>> getAllOrders() {
        return ResponseEntity.ok(orderQueryService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderQueryResponse> getOrderById(@PathVariable String id) {
        return orderQueryService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderQueryResponse>> getOrdersByCustomer(@PathVariable String customerId) {
        return ResponseEntity.ok(orderQueryService.getOrdersByCustomer(customerId));
    }
}
