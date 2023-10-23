package com.ajsw.barInventory.repository;

import com.ajsw.barInventory.domain.entity.TableeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITableRepository extends JpaRepository<TableeEntity, Integer> {
}
