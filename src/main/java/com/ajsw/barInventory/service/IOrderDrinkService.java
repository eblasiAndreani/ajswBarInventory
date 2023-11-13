package com.ajsw.barInventory.service;

import com.ajsw.barInventory.domain.dto.orderDrink.DrinkResponseDto;
import com.ajsw.barInventory.domain.dto.orderDrink.OrderDrinkDto;

import java.util.List;

public interface IOrderDrinkService {

    public void createOrderDrink(Integer idOrder, int idDrink, Integer amount);
    public void CreateListOrderDrink(List<OrderDrinkDto> drinkDtoList, Integer idOrder);
    public List<DrinkResponseDto> FindByOrder(Integer order);
}
