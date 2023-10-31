package com.ajsw.barInventory.service.impl;

import com.ajsw.barInventory.domain.dto.drink.Drink;
import com.ajsw.barInventory.domain.dto.order.Order;
import com.ajsw.barInventory.domain.dto.order.RequestOrderPostDto;
import com.ajsw.barInventory.domain.entity.DrinkEntity;
import com.ajsw.barInventory.domain.entity.OrderrEntity;
import com.ajsw.barInventory.repository.IOrderRepository;
import com.ajsw.barInventory.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class OrderService implements IOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private IOrderRepository _orderRepository;

    @Override
    public List<Order> getAll() {
        List<OrderrEntity> orderrEntityList = _orderRepository.findAll();
        List<Order> orderList = new ArrayList<>();

        for (OrderrEntity drinkEntity: orderrEntityList) {
            orderList.add(OrderEntityToOrder(drinkEntity));
        }

        return orderList;
    }
    @Override
    public Order getById(int id){

        OrderrEntity orderrEntity = _orderRepository.findById(id).orElse(null);

        return OrderEntityToOrder(orderrEntity);
    }
    @Override
    public Order createOrder(RequestOrderPostDto dates) {

        try{
            OrderrEntity order = new OrderrEntity();

            order.setIdPayment(dates.getIdPayment());
            order.setIdTable(dates.getIdTable());
            order.setObservation(dates.getObservation());
            order.setIdUsuario(dates.getIdUsurious());
            order.setPartialPrice(dates.getPartialPrice());

            _orderRepository.save(order);

            return OrderEntityToOrder(order);
        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
            throw ex;
        }
    }
    private Order OrderEntityToOrder(OrderrEntity dates){

        if (dates != null){
            Order order = new Order();
            order.setIdPayment(dates.getIdPayment());
            order.setIdTable(dates.getIdTable());
            order.setObservation(dates.getObservation());
            order.setIdUser(dates.getIdUsuario());
            order.setPartialPrice(dates.getPartialPrice());
            order.setId(dates.getId());

            return order;
        }
        return  null;
    }
}
