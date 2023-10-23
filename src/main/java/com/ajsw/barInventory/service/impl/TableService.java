package com.ajsw.barInventory.service.impl;

import com.ajsw.barInventory.domain.dto.RequestTablePostDto;
import com.ajsw.barInventory.domain.entity.TableeEntity;
import com.ajsw.barInventory.repository.ITableRepository;
import com.ajsw.barInventory.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService implements ITableService {
    @Autowired
    private ITableRepository _tableRepository;
    @Override
    public List<TableeEntity> getAll() {
        return _tableRepository.findAll();
    }
    @Override
    public TableeEntity getById(int id){

        return _tableRepository.findById(id).orElse(null);
    }

    @Override
    public TableeEntity createTable(RequestTablePostDto dates) {

        try{
            TableeEntity newTable = new TableeEntity();

            dates.setDispose(newTable.getDispose());
            dates.setReference(newTable.getReference());
            dates.setImage(newTable.getImage());
            dates.setIdBar(dates.getIdBar());

            return _tableRepository.save(newTable);
        }catch (Exception ex){

            System.out.println(ex.getMessage());
            return  null;
        }
    }
}
