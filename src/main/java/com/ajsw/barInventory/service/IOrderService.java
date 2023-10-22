package com.ajsw.barInventory.service;

import com.ajsw.barInventory.domain.dto.RequestOrderPostDto;
import com.ajsw.barInventory.domain.entity.OrderrEntity;

import java.util.List;

public interface IOrderService {
    List<OrderrEntity> getAll();
    OrderrEntity createOrder(RequestOrderPostDto dates);
    OrderrEntity getById(int id);
}
