package com.ajsw.barInventory.domain.dto.drink;

import com.ajsw.barInventory.domain.dto.Errors;
import lombok.Data;

import java.util.List;
@Data
public class ResponseDrinksDto {
    private List<Drink> body;
    private Errors errors;
}
