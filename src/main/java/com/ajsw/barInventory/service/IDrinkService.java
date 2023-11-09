package com.ajsw.barInventory.service;

import com.ajsw.barInventory.domain.dto.drink.Drink;
import com.ajsw.barInventory.domain.dto.drink.RequestDrinkPostDto;
import com.ajsw.barInventory.domain.entity.DrinkEntity;

import java.util.List;

public interface IDrinkService {
    List<Drink> getByBar(Integer id);
    List<Drink> getAll();
    Drink createDrink(RequestDrinkPostDto dates);
    Drink getById(Integer id);
}
