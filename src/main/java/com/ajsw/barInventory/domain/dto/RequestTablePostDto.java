package com.ajsw.barInventory.domain.dto;

import lombok.Data;

@Data
public class RequestTablePostDto {
    private String reference;
    private String image;
    private Byte dispose;
    private Integer idBar;
}
