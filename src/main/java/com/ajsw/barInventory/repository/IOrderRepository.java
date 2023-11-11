package com.ajsw.barInventory.repository;

import com.ajsw.barInventory.domain.entity.OrderrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<OrderrEntity, Integer> {
    public List<OrderrEntity> findByIdUsuario(int idUsuario);
}