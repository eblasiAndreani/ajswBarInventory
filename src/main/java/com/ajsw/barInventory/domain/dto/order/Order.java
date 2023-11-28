package com.ajsw.barInventory.domain.dto.order;

import com.ajsw.barInventory.domain.dto.orderDrink.DrinkResponseDto;
import com.ajsw.barInventory.domain.dto.table.Table;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Order {
    private int id;
    private Double partialPrice;
    private Timestamp fechaAlta;
    private Table idTable;
    private Integer idPayment;
    private Integer idUser;
    private List<DrinkResponseDto> drinks;
}
