package com.ajsw.barInventory.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class DrinkDto {
    private String name;
    private String description;
    private String image;
    private BigDecimal price;
}
