package com.ajsw.barInventory.repository;

import com.ajsw.barInventory.domain.entity.TableeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITableRepository extends JpaRepository<TableeEntity, Integer> {
    public List<TableeEntity> findByIdBar(Integer idBar);
}
