package com.ajsw.barInventory.service;

import com.ajsw.barInventory.domain.dto.table.RequestTablePostDto;
import com.ajsw.barInventory.domain.dto.table.Table;

import java.util.List;

public interface ITableService {
    List<Table> getAll();
    Table createTable(RequestTablePostDto dates);
    Table getById(int id);
    List<Table> getByIdBar(int id);
    Boolean setDisposeTable(int id);
}
