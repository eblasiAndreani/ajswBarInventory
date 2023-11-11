package com.ajsw.barInventory.domain.dto.table;

import com.ajsw.barInventory.domain.dto.BarDto;
import lombok.Data;

@Data
public class Table {
    private int id;
    private boolean dispose;
    private BarDto Bar;
    private Integer chair;
}
