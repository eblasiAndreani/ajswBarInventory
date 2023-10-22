package com.ajsw.barInventory.controllers;

import com.ajsw.barInventory.domain.dto.RequestDrinkPostDto;
import com.ajsw.barInventory.domain.dto.RequestOrderPostDto;
import com.ajsw.barInventory.domain.entity.DrinkEntity;
import com.ajsw.barInventory.domain.entity.OrderrEntity;
import com.ajsw.barInventory.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class OrderController {
    @Autowired
    private IOrderService _orderService;

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderrEntity>> getAllPayment(){

        try {

            List<OrderrEntity> orders = _orderService.getAll();
            return ResponseEntity.ok(orders);

        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
    @GetMapping("/getById")
    public ResponseEntity<OrderrEntity> getById(int id){

        try{

            OrderrEntity order =_orderService.getById(id);
            if (order != null){
                return ResponseEntity.ok(order);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<OrderrEntity> postDrink(@RequestBody RequestOrderPostDto dates){

        try{

            OrderrEntity newOrder = _orderService.createOrder(dates);

            if (newOrder !=null){
                return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}
