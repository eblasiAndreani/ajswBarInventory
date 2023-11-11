package com.ajsw.barInventory.service;

import com.ajsw.barInventory.domain.dto.orderDrink.OrderDrinkDto;

import java.util.List;

public interface IOrderDrinkService {

    public void createOrderDrink(Integer idOrder, int idDrink, Double amount);
    public void CreateListOrderDrink(List<OrderDrinkDto> drinkDtoList, Integer idOrder);
}
