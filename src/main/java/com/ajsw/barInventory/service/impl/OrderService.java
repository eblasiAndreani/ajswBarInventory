package com.ajsw.barInventory.service.impl;

import com.ajsw.barInventory.domain.dto.order.Order;
import com.ajsw.barInventory.domain.dto.order.RequestOrderPostDto;
import com.ajsw.barInventory.domain.entity.OrderrEntity;
import com.ajsw.barInventory.repository.IOrderRepository;
import com.ajsw.barInventory.service.IOrderDrinkService;
import com.ajsw.barInventory.service.IOrderService;
import com.ajsw.barInventory.service.ITableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Service

public class OrderService implements IOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private IOrderRepository _orderRepository;
    @Autowired
    private IOrderDrinkService _orderDrinkService;
    @Autowired
    private ITableService _tableService;

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
    public List<Order> getOrderByUsuario(int id) {
        List<OrderrEntity> orderrEntityList = _orderRepository.findByIdUsuario(id);
        List<Order> orderList = new ArrayList<>();

        for (OrderrEntity drinkEntity: orderrEntityList) {
            orderList.add(OrderEntityToOrder(drinkEntity));
        }

        return orderList;
    }

    public List<Order> getOrderByTable(int id) {
        List<OrderrEntity> orderrEntityList = _orderRepository.findByIdTable(id);
        List<Order> orderList = new ArrayList<>();

        for (OrderrEntity drinkEntity: orderrEntityList) {
            orderList.add(OrderEntityToOrder(drinkEntity));
        }

        return orderList;
    }

    @Override
    public Order createOrder(RequestOrderPostDto dates) {

        try{
            OrderrEntity order = new OrderrEntity();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            order.setIdPayment(dates.getIdPayment());
            order.setIdTable(dates.getIdTable());
            order.setIdUsuario(Integer.parseInt(dates.getIdUser()));
            order.setPartialPrice(dates.getPartialPrice());
            order.setFechaAlta(timestamp);

            _orderRepository.save(order);

            _orderDrinkService.CreateListOrderDrink(dates.getDrinks(), order.getId());

            _tableService.setDisposeTable(dates.getIdTable());

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
            order.setIdTable(_tableService.getById(dates.getIdTable()));
            order.setIdUser(dates.getIdUsuario());
            order.setPartialPrice(dates.getPartialPrice());
            order.setId(dates.getId());
            order.setFechaAlta(dates.getFechaAlta());
            order.setDrinks(_orderDrinkService.FindByOrder(dates.getId()));
            return order;
        }
        return  null;
    }

}
