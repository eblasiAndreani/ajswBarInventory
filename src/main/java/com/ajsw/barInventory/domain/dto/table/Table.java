package com.ajsw.barInventory.domain.dto.table;

import lombok.Data;

@Data
public class Table {
    private int id;
    private String reference;
    private String image;
    private Byte dispose;
    private Integer idBar;
}
