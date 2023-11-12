package com.ajsw.barInventory.service.impl;

import com.ajsw.barInventory.controllers.DrinkController;
import com.ajsw.barInventory.domain.dto.drink.Drink;
import com.ajsw.barInventory.domain.dto.drink.RequestDrinkPostDto;
import com.ajsw.barInventory.domain.entity.DrinkEntity;
import com.ajsw.barInventory.repository.IDrinkRepository;
import com.ajsw.barInventory.service.IDrinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrinkService implements IDrinkService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DrinkService.class);

    @Autowired
    private IDrinkRepository _drinkRepository;

    @Override
    public List<Drink> getByBar(Integer id) {
        List<DrinkEntity> drinkEntityList = _drinkRepository.findByIdBar(id);
        List<Drink> drinkList = new ArrayList<>();

        for (DrinkEntity drinkEntity: drinkEntityList) {
            drinkList.add(DrinkEntityToDrink(drinkEntity));
        }
        return drinkList;
    }

    @Override
    public List<Drink> getAll() {
        List<DrinkEntity> drinkEntityList = _drinkRepository.findAll();
        List<Drink> drinkList = new ArrayList<>();

        for (DrinkEntity drinkEntity: drinkEntityList) {
            drinkList.add(DrinkEntityToDrink(drinkEntity));
        }

        return drinkList;
    }
    @Override
    public Drink getById(Integer id){
        DrinkEntity drinkEntity = _drinkRepository.findById(id).orElse(null);

        return DrinkEntityToDrink(drinkEntity);
    }

    @Override
    public Drink createDrink(RequestDrinkPostDto dates) {

        try{
            DrinkEntity drink = new DrinkEntity();

            drink.setDescription(dates.getDescription());
            drink.setImage(dates.getImage());
            drink.setName(dates.getName());
            drink.setPrice(dates.getPrice());
            drink.setIdBar(dates.getIdBar());

            _drinkRepository.save(drink);

            return DrinkEntityToDrink(drink);
        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
            throw ex;
        }
    }
    private Drink DrinkEntityToDrink(DrinkEntity drinkEntity){

        if (drinkEntity != null){
            Drink drink = new Drink();

            drink.setDescription(drinkEntity.getDescription());
            drink.setId(drinkEntity.getId());
            drink.setName(drinkEntity.getName());
            drink.setPrice(drinkEntity.getPrice());
            drink.setImage(drinkEntity.getImage());

            return drink;
        }else {
            return null;
        }
    }
}
