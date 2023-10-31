package com.ajsw.barInventory.domain.dto.table;

import com.ajsw.barInventory.domain.dto.Errors;
import com.ajsw.barInventory.domain.dto.order.Order;
import lombok.Data;

import java.util.List;
@Data
public class ResponseTablesDto {
    private List<Table> body;
    private Errors errors;
}
