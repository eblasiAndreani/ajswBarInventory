package com.ajsw.barInventory.domain.dto.order;

import com.ajsw.barInventory.domain.dto.Errors;
import lombok.Data;

import java.util.List;
@Data
public class ResponseOrderDto {
    private Order body;
    private Errors errors;
}
