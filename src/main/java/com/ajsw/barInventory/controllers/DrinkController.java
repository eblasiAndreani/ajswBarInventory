package com.ajsw.barInventory.controllers;

import com.ajsw.barInventory.domain.dto.RequestDrinkPostDto;
import com.ajsw.barInventory.domain.entity.DrinkEntity;
import com.ajsw.barInventory.service.IDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/drinks")
public class DrinkController {
    @Autowired
    private IDrinkService _drinkService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DrinkEntity>> getAllPayment(){

        try {

            List<DrinkEntity> drinks = _drinkService.getAll();
            return ResponseEntity.ok(drinks);

        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
    @GetMapping("/getById")
    public ResponseEntity<DrinkEntity> getById(Integer id){

        try{

            DrinkEntity drink =_drinkService.getById(id);
            if (drink != null){
                return ResponseEntity.ok(drink);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<DrinkEntity> postDrink(@RequestBody RequestDrinkPostDto dates){

        try{
            DrinkEntity newDrink = _drinkService.createDrink(dates);

            if (newDrink !=null){
                return ResponseEntity.status(HttpStatus.CREATED).body(newDrink);
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}

