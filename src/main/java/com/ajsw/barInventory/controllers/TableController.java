package com.ajsw.barInventory.controllers;

import com.ajsw.barInventory.domain.dto.Errors;
import com.ajsw.barInventory.domain.dto.table.RequestTablePostDto;
import com.ajsw.barInventory.domain.dto.table.ResponseTableDto;
import com.ajsw.barInventory.domain.dto.table.ResponseTablesDto;
import com.ajsw.barInventory.domain.dto.table.Table;
import com.ajsw.barInventory.service.ITableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/table")
public class TableController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TableController.class);
    @Autowired
    private ITableService _tableService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseTablesDto> getAllTable(){

        ResponseTablesDto tablesDto = new ResponseTablesDto();

        try {

            List<Table> tables = _tableService.getAll();
            tablesDto.setBody(tables);

            return ResponseEntity.ok(tablesDto);

        }catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            tablesDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(tablesDto);
        }

    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseTableDto> getById(@PathVariable Integer id){

        ResponseTableDto responseTableDto = new ResponseTableDto();

        try{

            Table table = _tableService.getById(id);
            if (table != null){
                responseTableDto.setBody(table);
                return ResponseEntity.ok(responseTableDto);
            }else {
                responseTableDto.setErrors(new Errors(204, "No se encontró table",null));
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseTableDto);
            }

        }catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            responseTableDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseTableDto);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<ResponseTableDto> postTAble(@RequestBody RequestTablePostDto dates){

        ResponseTableDto responseTableDto = new ResponseTableDto();

        try{

            Table newTable = _tableService.createTable(dates);
            responseTableDto.setBody(newTable);

            return ResponseEntity.status(HttpStatus.CREATED).body(responseTableDto);


        }catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            responseTableDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseTableDto);
        }

    }

    @GetMapping("/getByBar/{id}")
    public ResponseEntity<ResponseTablesDto> getAllTable(@PathVariable Integer id){

        ResponseTablesDto tablesDto = new ResponseTablesDto();

        try {

            List<Table> tables = _tableService.getByIdBar(id);
            tablesDto.setBody(tables);

            return ResponseEntity.ok(tablesDto);

        }catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            tablesDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(tablesDto);
        }

    }

    @PutMapping("/setDispose/{id}")
    public ResponseEntity<Boolean> setDisposeTable(@PathVariable Integer id){

        return ResponseEntity.ok(_tableService.setDisposeTable(id));
    }
}
