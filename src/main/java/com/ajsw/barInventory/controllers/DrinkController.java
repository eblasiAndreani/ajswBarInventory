package com.ajsw.barInventory.controllers;

import com.ajsw.barInventory.domain.dto.DrinkDto;
import com.ajsw.barInventory.domain.entity.Drink;
import com.ajsw.barInventory.repositories.DrinkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    private final DrinkDAO drinkDAO;

    @Autowired
    public DrinkController(DrinkDAO drinkDAO) {
        this.drinkDAO = drinkDAO;
    }

    @PostMapping
    public void createDrink(@RequestBody DrinkDto drinkDto) {
        Drink drink = new Drink();
        drink.setName(drinkDto.getName());
        drink.setDescription(drinkDto.getDescription());
        drink.setImage(drinkDto.getImage());
        drink.setPrice(drinkDto.getPrice());
        drinkDAO.saveDrink(drink);
    }

    @GetMapping("/{id}")
    public Drink getDrink(@PathVariable int id) {
        var obj = drinkDAO.getDrink(id);
        return obj;
    }

    @GetMapping
    public List<Drink> getAllDrinks() {
        return drinkDAO.getAllDrinks();
    }

    @PutMapping("/{id}")
    public void updateDrink(@PathVariable int id, @RequestBody DrinkDto drinkDto) {
        Drink existingDrink = drinkDAO.getDrink(id);
        if (existingDrink != null) {
            existingDrink.setName(drinkDto.getName());
            existingDrink.setDescription(drinkDto.getDescription());
            existingDrink.setImage(drinkDto.getImage());
            existingDrink.setPrice(drinkDto.getPrice());
            drinkDAO.updateDrink(existingDrink);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteDrink(@PathVariable int id) {
        drinkDAO.deleteDrink(id);
    }
}

