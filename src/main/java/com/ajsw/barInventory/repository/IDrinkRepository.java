package com.ajsw.barInventory.repository;

import com.ajsw.barInventory.domain.entity.DrinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDrinkRepository extends JpaRepository<DrinkEntity, Integer> {
}
