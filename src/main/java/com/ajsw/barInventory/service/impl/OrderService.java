package com.ajsw.barInventory.service.impl;

import com.ajsw.barInventory.domain.dto.RequestOrderPostDto;
import com.ajsw.barInventory.domain.entity.OrderrEntity;
import com.ajsw.barInventory.repository.IOrderRepository;
import com.ajsw.barInventory.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository _orderRepository;

    @Override
    public List<OrderrEntity> getAll() {
        return _orderRepository.findAll();
    }
    @Override
    public OrderrEntity getById(int id){

        return _orderRepository.findById(id).orElse(null);
    }

    @Override
    public OrderrEntity createOrder(RequestOrderPostDto dates) {

        try{
            OrderrEntity order = new OrderrEntity();

            order.setIdPayment(dates.getIdPayment());
            order.setIdTable(dates.getIdTable());
            order.setObservation(dates.getObservation());
            order.setIdUsuario(dates.getIdUsurious());
            order.setPartialPrice(dates.getPartialPrice());

            return _orderRepository.save(order);
        }catch (Exception ex){

            System.out.println(ex.getMessage());
            return  null;
        }
    }
}
