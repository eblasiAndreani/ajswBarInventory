package com.ajsw.barInventory.domain.dto.drink;

import com.ajsw.barInventory.domain.dto.Errors;
import lombok.Data;

@Data
public class ResponseDrinkDto {
    private Drink body;
    private Errors errors;
}
