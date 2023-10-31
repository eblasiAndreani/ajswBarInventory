package com.ajsw.barInventory.controllers;

import com.ajsw.barInventory.domain.dto.Errors;
import com.ajsw.barInventory.domain.dto.drink.Drink;
import com.ajsw.barInventory.domain.dto.drink.RequestDrinkPostDto;
import com.ajsw.barInventory.domain.dto.drink.ResponseDrinkDto;
import com.ajsw.barInventory.domain.dto.drink.ResponseDrinksDto;
import com.ajsw.barInventory.service.IDrinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/drinks")
public class DrinkController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DrinkController.class);
    @Autowired
    private IDrinkService _drinkService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDrinksDto> getAllPayment(){
        ResponseDrinksDto drinksDto = new ResponseDrinksDto();
        try {

            List<Drink> drinks = _drinkService.getAll();
            drinksDto.setBody(drinks);

            return ResponseEntity.ok(drinksDto);

        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
            drinksDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(drinksDto);
        }

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDrinkDto> getById(@PathVariable Integer id){
        ResponseDrinkDto drinkDto = new ResponseDrinkDto();
        try{

            Drink drink =_drinkService.getById(id);

            if (drink != null){
                drinkDto.setBody(drink);
                return ResponseEntity.ok(drinkDto);
            }else {
                drinkDto.setErrors(new Errors(204, "No se encontró Bar",null));
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(drinkDto);
            }

        }catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            drinkDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(drinkDto);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDrinkDto> postDrink(@RequestBody RequestDrinkPostDto dates){

        ResponseDrinkDto drinkDto = new ResponseDrinkDto();

        try{

            Drink newDrink = _drinkService.createDrink(dates);
            drinkDto.setBody(newDrink);

            return ResponseEntity.status(HttpStatus.CREATED).body(drinkDto);

        }catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            drinkDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(drinkDto);
        }

    }
}

