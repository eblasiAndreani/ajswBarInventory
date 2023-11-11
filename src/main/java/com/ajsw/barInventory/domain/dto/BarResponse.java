package com.ajsw.barInventory.domain.dto;

import lombok.Data;

@Data
public class BarResponse {
    private BarDto body;
    private Errors errors;
}
