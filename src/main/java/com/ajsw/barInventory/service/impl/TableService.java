package com.ajsw.barInventory.service.impl;

import com.ajsw.barInventory.domain.dto.order.Order;
import com.ajsw.barInventory.domain.dto.table.RequestTablePostDto;
import com.ajsw.barInventory.domain.dto.table.Table;
import com.ajsw.barInventory.domain.entity.OrderrEntity;
import com.ajsw.barInventory.domain.entity.TableeEntity;
import com.ajsw.barInventory.repository.ITableRepository;
import com.ajsw.barInventory.service.ITableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService implements ITableService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TableService.class);
    @Autowired
    private ITableRepository _tableRepository;
    @Override
    public List<Table> getAll() {
        List<TableeEntity> tableEntities = _tableRepository.findAll();
        List<Table> tableList = new ArrayList<>();

        for (TableeEntity tableEntity: tableEntities) {
            tableList.add(TableEntityToTable(tableEntity));
        }

        return tableList;
    }
    @Override
    public Table getById(int id){
        TableeEntity tableeEntity = _tableRepository.findById(id).orElse(null);

        return TableEntityToTable(tableeEntity);
    }

    @Override
    public Table createTable(RequestTablePostDto dates) {

        try{
            TableeEntity newTable = new TableeEntity();

            dates.setDispose(newTable.getDispose());
            dates.setReference(newTable.getReference());
            dates.setImage(newTable.getImage());
            dates.setIdBar(dates.getIdBar());

            _tableRepository.save(newTable);

            return TableEntityToTable(newTable);
        }catch (Exception ex){

            LOGGER.error(ex.getMessage());
            throw ex;
        }
    }
    private Table TableEntityToTable(TableeEntity dates){
        if (dates != null){

            Table table = new Table();
            table.setDispose(dates.getDispose());
            table.setReference(dates.getReference());
            table.setImage(dates.getImage());
            table.setIdBar(dates.getIdBar());
            table.setId(dates.getId());

            return table;
        }
        return  null;
    }
}
