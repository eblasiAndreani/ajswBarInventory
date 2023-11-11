package com.ajsw.barInventory.repository;

import com.ajsw.barInventory.domain.entity.OrderdrinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDrinkRepository extends JpaRepository<OrderdrinkEntity, Integer> {
}
