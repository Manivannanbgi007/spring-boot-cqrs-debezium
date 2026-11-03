package com.npi.order.read.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npi.order.read.dto.OrderQueryResponse;
import com.npi.order.read.entity.OrderReadEntity;
import com.npi.order.read.repository.OrderReadRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderQueryService {

    private final OrderReadRepository orderReadRepository;

    public List<OrderQueryResponse> getAllOrders() {
        return orderReadRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    public Optional<OrderQueryResponse> getOrderById(String id) {
        return orderReadRepository.findById(id)
                .map(this::mapToResponse);
    }

    public List<OrderQueryResponse> getOrdersByCustomer(String customerId) {
        return orderReadRepository.findByCustomerId(customerId).stream()
                .map(this::mapToResponse)
                .toList();
    }

    private OrderQueryResponse mapToResponse(OrderReadEntity entity) {
        return new OrderQueryResponse(
                entity.getId(),
                entity.getCustomerId(),
                entity.getProductName(),
                entity.getQuantity(),
                entity.getTotalPrice(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
