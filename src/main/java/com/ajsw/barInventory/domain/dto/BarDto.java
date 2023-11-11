package com.ajsw.barInventory.domain.dto;

import lombok.Data;

@Data
public class BarDto {
    private int id;
    private String name;
    private String description;
    private String logo;
    private Double latitude;
    private Double longitude;
}
