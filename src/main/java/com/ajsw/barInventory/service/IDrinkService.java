package com.ajsw.barInventory.service;

import com.ajsw.barInventory.domain.dto.RequestDrinkPostDto;
import com.ajsw.barInventory.domain.entity.DrinkEntity;

import java.util.List;

public interface IDrinkService {
    List<DrinkEntity> getAll();
    DrinkEntity createDrink(RequestDrinkPostDto dates);
    DrinkEntity getById(Integer id);
}
