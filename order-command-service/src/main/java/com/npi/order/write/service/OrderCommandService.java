package com.npi.order.write.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npi.order.write.dto.CreateOrderRequest;
import com.npi.order.write.dto.OrderResponse;
import com.npi.order.write.dto.UpdateOrderRequest;
import com.npi.order.write.entity.OrderEntity;
import com.npi.order.write.repository.OrderRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderCommandService {

    private final OrderRepository orderRepository;

    @Transactional
    public OrderResponse createOrder(CreateOrderRequest request) {
        OrderEntity entity = OrderEntity.builder()
                .id(UUID.randomUUID().toString())
                .customerId(request.customerId())
                .productName(request.productName())
                .quantity(request.quantity())
                .totalPrice(request.totalPrice())
                .status("CREATED")
                .build();

        OrderEntity saved = orderRepository.save(entity);
        return mapToResponse(saved);
    }

    @Transactional
    public OrderResponse updateOrderStatus(String id, UpdateOrderRequest request) {
        OrderEntity entity = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + id));

        entity.setStatus(request.status());
        OrderEntity updated = orderRepository.save(entity);
        return mapToResponse(updated);
    }

    @Transactional
    public void deleteOrder(String id) {
        if (!orderRepository.existsById(id)) {
            throw new EntityNotFoundException("Order not found with ID: " + id);
        }
        orderRepository.deleteById(id);
    }

    private OrderResponse mapToResponse(OrderEntity entity) {
        return new OrderResponse(
                entity.getId(),
                entity.getCustomerId(),
                entity.getProductName(),
                entity.getQuantity(),
                entity.getTotalPrice(),
                entity.getStatus()
        );
    }
}
