package com.ajsw.barInventory.domain.dto.drink;

import lombok.Data;

@Data
public class Drink {
    private int id;
    private String name;
    private String description;
    private String image;
    private double price;
    private int idBar;
}
