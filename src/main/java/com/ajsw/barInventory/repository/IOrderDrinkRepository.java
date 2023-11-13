package com.ajsw.barInventory.repository;

import com.ajsw.barInventory.domain.entity.OrderdrinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderDrinkRepository extends JpaRepository<OrderdrinkEntity, Integer> {
    public List<OrderdrinkEntity> findByIdOrder(Integer idOrder);
}
