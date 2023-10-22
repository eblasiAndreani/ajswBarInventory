package com.ajsw.barInventory.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class RequestDrinkPostDto {
    private String name;
    private String description;
    private String image;
    private double price;
}
