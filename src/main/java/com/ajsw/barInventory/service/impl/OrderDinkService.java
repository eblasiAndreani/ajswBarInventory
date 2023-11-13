package com.ajsw.barInventory.service.impl;

import com.ajsw.barInventory.domain.dto.drink.Drink;
import com.ajsw.barInventory.domain.dto.orderDrink.DrinkResponseDto;
import com.ajsw.barInventory.domain.dto.orderDrink.OrderDrinkDto;
import com.ajsw.barInventory.domain.entity.OrderdrinkEntity;
import com.ajsw.barInventory.repository.IOrderDrinkRepository;
import com.ajsw.barInventory.service.IDrinkService;
import com.ajsw.barInventory.service.IOrderDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDinkService implements IOrderDrinkService {
    @Autowired
    private IOrderDrinkRepository _orderDrinkRepository;
    @Autowired
    private IDrinkService _DrinkService;

    @Override
    public void CreateListOrderDrink(List<OrderDrinkDto> drinkDtoList, Integer idOrder){
        for (OrderDrinkDto x : drinkDtoList) {
            createOrderDrink(idOrder, x.getDrink() , x.getAmount());
        }
    }
    @Override
    public void createOrderDrink(Integer idOrder, int idDrink, Integer amount ) {
        OrderdrinkEntity orderdrinkEntity = new OrderdrinkEntity();

        orderdrinkEntity.setIdOrder(idOrder);
        orderdrinkEntity.setIdDrink(idDrink);
        orderdrinkEntity.setAmount(amount);

        _orderDrinkRepository.save(orderdrinkEntity);
    }
    @Override
    public List<DrinkResponseDto> FindByOrder(Integer order){
        List<DrinkResponseDto> response = new ArrayList<DrinkResponseDto>();
        List<OrderdrinkEntity> orderdrinkList = _orderDrinkRepository.findByIdOrder(order);

        for (OrderdrinkEntity x: orderdrinkList) {

            Drink drink = _DrinkService.getById(x.getIdDrink());

            DrinkResponseDto  drinkResponse = new DrinkResponseDto();

            drinkResponse.setAmount(x.getAmount());
            drinkResponse.setId(drink.getId());
            drinkResponse.setName(drink.getName());
            drinkResponse.setDescription(drink.getDescription());
            drinkResponse.setImage(drink.getImage());
            drinkResponse.setPrice(drink.getPrice());
            drinkResponse.setIdBar(drink.getIdBar());

            response.add(drinkResponse);
        }

        return response;
    }
}
