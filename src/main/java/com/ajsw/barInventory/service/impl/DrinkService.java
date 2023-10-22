package com.ajsw.barInventory.service.impl;

import com.ajsw.barInventory.domain.dto.RequestDrinkPostDto;
import com.ajsw.barInventory.domain.entity.DrinkEntity;
import com.ajsw.barInventory.repository.IDrinkRepository;
import com.ajsw.barInventory.service.IDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService implements IDrinkService {

    @Autowired
    private IDrinkRepository _drinkRepository;

    @Override
    public List<DrinkEntity> getAll() {
        return _drinkRepository.findAll();
    }
    public DrinkEntity getById(Integer id){

        return _drinkRepository.findById(id).orElse(null);
    }

    @Override
    public DrinkEntity createDrink(RequestDrinkPostDto dates) {

        try{
            DrinkEntity drink = new DrinkEntity();

            drink.setDescription(dates.getDescription());
            drink.setImage(dates.getImage());
            drink.setName(dates.getName());
            drink.setPrice(dates.getPrice());

            return _drinkRepository.save(drink);
        }catch (Exception ex){

            System.out.println(ex.getMessage());
            return  null;
        }
    }
}
