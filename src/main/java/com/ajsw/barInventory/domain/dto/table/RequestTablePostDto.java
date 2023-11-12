package com.ajsw.barInventory.domain.dto.table;

import lombok.Data;

@Data
public class RequestTablePostDto {
    private String reference;
    private String image;
    private Byte dispose;
    private Integer idBar;
    private Integer chair;
}
