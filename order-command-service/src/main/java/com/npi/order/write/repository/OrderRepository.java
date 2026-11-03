package com.npi.order.write.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npi.order.write.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}