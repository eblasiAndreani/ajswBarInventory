package com.ajsw.barInventory.controllers;

import com.ajsw.barInventory.domain.dto.Errors;
import com.ajsw.barInventory.domain.dto.order.Order;
import com.ajsw.barInventory.domain.dto.order.RequestOrderPostDto;
import com.ajsw.barInventory.domain.dto.order.ResponseOrderDto;
import com.ajsw.barInventory.domain.dto.order.ResponseOrdersDto;
import com.ajsw.barInventory.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/v1/order")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private IOrderService _orderService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseOrdersDto> getAllOrder(){
        ResponseOrdersDto ordersDto = new ResponseOrdersDto();
        try {

            List<Order> orders = _orderService.getAll();
            ordersDto.setBody(orders);
            return ResponseEntity.ok(ordersDto);

        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
            ordersDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ordersDto);
        }

    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseOrderDto> getById(@PathVariable Integer id){
        ResponseOrderDto orderDto = new ResponseOrderDto();
        try{

            Order order =_orderService.getById(id);
            if (order != null){
                orderDto.setBody(order);
                return ResponseEntity.ok(orderDto);
            }else {
                orderDto.setErrors(new Errors(204, "No se encontró Order",null));
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(orderDto);
            }

        }catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            orderDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(orderDto);
        }

    }
    @PostMapping("/create")
    public ResponseEntity<ResponseOrderDto> postOrder(@RequestBody RequestOrderPostDto dates){
        ResponseOrderDto orderDto = new ResponseOrderDto();
        try{

            Order newOrder = _orderService.createOrder(dates);
            orderDto.setBody(newOrder);

            return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);

        }catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            orderDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(orderDto);
        }
    }
    @GetMapping("/getByUser/{id}")
    public ResponseEntity<ResponseOrdersDto> GetOrderByUser(@PathVariable Integer id){

        ResponseOrdersDto ordersDto = new ResponseOrdersDto();
        try {

            List<Order> orders = _orderService.getOrderByUsuario(id);
            ordersDto.setBody(orders);
            return ResponseEntity.ok(ordersDto);

        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
            ordersDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ordersDto);
        }
    }

    @GetMapping("/getByTable/{id}")
    public ResponseEntity<ResponseOrdersDto> GetOrderByTable(@PathVariable Integer id){

        ResponseOrdersDto ordersDto = new ResponseOrdersDto();
        try {

            List<Order> orders = _orderService.getOrderByTable(id);
            ordersDto.setBody(orders);
            return ResponseEntity.ok(ordersDto);

        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
            ordersDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ordersDto);
        }
    }
}
