package com.ajsw.barInventory.domain.dto.order;

import com.ajsw.barInventory.domain.dto.orderDrink.OrderDrinkDto;
import lombok.Data;

import java.util.List;

@Data
public class RequestOrderPostDto {
    private Integer partialPrice;
    private Integer idTable;
    private Integer idPayment;
    private Integer idUsurious;
    private List<OrderDrinkDto> drinks;
}
