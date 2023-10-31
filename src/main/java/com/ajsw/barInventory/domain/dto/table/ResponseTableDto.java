package com.ajsw.barInventory.domain.dto.table;

import com.ajsw.barInventory.domain.dto.Errors;
import lombok.Data;

@Data
public class ResponseTableDto {
    private Table body;
    private Errors errors;
}
