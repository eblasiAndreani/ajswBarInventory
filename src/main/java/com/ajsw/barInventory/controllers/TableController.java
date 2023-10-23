package com.ajsw.barInventory.controllers;

import com.ajsw.barInventory.domain.dto.RequestTablePostDto;
import com.ajsw.barInventory.domain.entity.TableeEntity;
import com.ajsw.barInventory.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/table")
public class TableController {
    @Autowired
    private ITableService _tableService;

    @GetMapping("/getAll")
    public ResponseEntity<List<TableeEntity>> getAllPayment(){

        try {

            List<TableeEntity> tables = _tableService.getAll();
            return ResponseEntity.ok(tables);

        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
    @GetMapping("/getById")
    public ResponseEntity<TableeEntity> getById(int id){

        try{

            TableeEntity tablee = _tableService.getById(id);
            if (tablee != null){
                return ResponseEntity.ok(tablee);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<TableeEntity> postTAble(@RequestBody RequestTablePostDto dates){

        try{

            TableeEntity newTable = _tableService.createTable(dates);

            if (newTable !=null){
                return ResponseEntity.status(HttpStatus.CREATED).body(newTable);
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}
