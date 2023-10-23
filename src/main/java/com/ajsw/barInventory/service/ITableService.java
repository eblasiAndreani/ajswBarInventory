package com.ajsw.barInventory.service;

import com.ajsw.barInventory.domain.dto.RequestTablePostDto;
import com.ajsw.barInventory.domain.entity.TableeEntity;

import java.util.List;

public interface ITableService {
    List<TableeEntity> getAll();
    TableeEntity createTable(RequestTablePostDto dates);
    TableeEntity getById(int id);
}
