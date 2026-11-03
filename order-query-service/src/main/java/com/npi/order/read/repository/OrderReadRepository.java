package com.npi.order.read.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npi.order.read.entity.OrderReadEntity;

import java.util.List;

@Repository
public interface OrderReadRepository extends JpaRepository<OrderReadEntity, String> {
    List<OrderReadEntity> findByCustomerId(String customerId);
}