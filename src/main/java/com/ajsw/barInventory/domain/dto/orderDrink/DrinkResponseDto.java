package com.ajsw.barInventory.domain.dto.orderDrink;

import com.ajsw.barInventory.domain.dto.drink.Drink;
import lombok.Data;

@Data
public class DrinkResponseDto extends Drink {
    private Integer amount;
}

