package com.ajsw.barInventory.domain.dto.order;

import lombok.Data;

@Data
public class Order {
    private int id;
    private Integer partialPrice;
    private String observation;
    private Integer idTable;
    private Integer idPayment;
    private Integer idUser;
}
