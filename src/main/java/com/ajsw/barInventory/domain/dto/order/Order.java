package com.ajsw.barInventory.domain.dto.order;

import com.ajsw.barInventory.domain.dto.table.Table;
import lombok.Data;

@Data
public class Order {
    private int id;
    private Integer partialPrice;
    private Table idTable;
    private Integer idPayment;
    private Integer idUser;
}
