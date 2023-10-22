package com.ajsw.barInventory.repository;

import com.ajsw.barInventory.domain.entity.OrderrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderrEntity, Integer> {

}