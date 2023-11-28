package com.ajsw.barInventory.service;

import com.ajsw.barInventory.domain.dto.order.Order;
import com.ajsw.barInventory.domain.dto.order.RequestOrderPostDto;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();
    Order createOrder(RequestOrderPostDto dates);
    Order getById(int id);
    List<Order> getOrderByUsuario(int id);

    List<Order> getOrderByTable(int id);



}
