package com.ajsw.barInventory.service;

import com.ajsw.barInventory.domain.dto.table.RequestTablePostDto;
import com.ajsw.barInventory.domain.dto.table.Table;
import com.ajsw.barInventory.domain.entity.TableeEntity;

import java.util.List;

public interface ITableService {
    List<Table> getAll();
    Table createTable(RequestTablePostDto dates);
    Table getById(int id);
}
