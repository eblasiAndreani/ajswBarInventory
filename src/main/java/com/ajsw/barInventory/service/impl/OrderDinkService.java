package com.ajsw.barInventory.service.impl;

import com.ajsw.barInventory.domain.dto.orderDrink.OrderDrinkDto;
import com.ajsw.barInventory.domain.entity.OrderdrinkEntity;
import com.ajsw.barInventory.repository.IOrderDrinkRepository;
import com.ajsw.barInventory.service.IOrderDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDinkService implements IOrderDrinkService {
    @Autowired
    private IOrderDrinkRepository _orderDrinkRepository;

    @Override
    public void CreateListOrderDrink(List<OrderDrinkDto> drinkDtoList, Integer idOrder){
        for (OrderDrinkDto x : drinkDtoList) {
            createOrderDrink(idOrder, x.getDrink() , x.getAmount());
        }
    }
    @Override
    public void createOrderDrink(Integer idOrder, int idDrink, Double amount ) {
        OrderdrinkEntity orderdrinkEntity = new OrderdrinkEntity();

        orderdrinkEntity.setIdOrder(idOrder);
        orderdrinkEntity.setIdDrink(idDrink);
        orderdrinkEntity.setAmount(amount);

        _orderDrinkRepository.save(orderdrinkEntity);
    }
}
