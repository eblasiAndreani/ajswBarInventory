package com.ajsw.barInventory.repository;

import com.ajsw.barInventory.domain.entity.DrinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDrinkRepository extends JpaRepository<DrinkEntity, Integer> {
    public List<DrinkEntity> findByIdBar(int bar);
}
