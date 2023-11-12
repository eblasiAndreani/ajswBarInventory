package com.ajsw.barInventory.service.impl;

import com.ajsw.barInventory.domain.dto.table.RequestTablePostDto;
import com.ajsw.barInventory.domain.dto.table.Table;
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
    public List<Table> getByIdBar(int id) {
        List<TableeEntity> tableEntities = _tableRepository.findByIdBar(id);
        List<Table> tableList = new ArrayList<>();

        for (TableeEntity tableEntity: tableEntities) {
            tableList.add(TableEntityToTable(tableEntity));
        }
        return tableList;
    }
    @Override
    public Boolean setDisposeTable(int id) {
        try {
            TableeEntity tableeEntity = _tableRepository.findById(id).orElse(null);

            if (tableeEntity != null){
                tableeEntity.setDispose(Byte.parseByte("0"));
                _tableRepository.save(tableeEntity);
                return true;
            }
            return false;

        }catch (Exception e){
            return false;
        }
    }
    @Override
    public Table createTable(RequestTablePostDto dates) {

        try{
            TableeEntity newTable = new TableeEntity();


            newTable.setDispose(dates.getDispose());
            newTable.setIdBar(dates.getIdBar());
            newTable.setChair(dates.getChair());

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
            table.setDispose( (dates.getDispose() == 1) );
            table.setBar(CallingService.FindBarById(String.valueOf(dates.getIdBar())));
            table.setId(dates.getId());
            table.setChair(dates.getChair());

            return table;
        }
        return  null;
    }
}
