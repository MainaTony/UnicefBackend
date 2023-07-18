package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.entity.DataSource;
import com.pinnoserv.portal.service.DataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datasource")
@Slf4j
public class DataSourceBestController {
    @Autowired
    DataSourceService dataSourceService;
    @PostMapping("/create")
    public ResponseEntity<String> createDataSource(@RequestBody DataSource dataSource){

        try{
            log.info("Begin Create endpoint");
            dataSourceService.createDataSource(dataSource);
        } catch (Exception e){

        }
        return ResponseEntity.ok("Datasource Created");
    }
//    @PostMapping("/getAll")
//    public ResponseEntity<List<DataSource>> findAll(){
//
//        return ResponseEntity.ok(List<DataSource>);
//    }

//    @PostMapping("/findById")
//    public ResponseEntity<DataSource> getById(){
//
//        return ResponseEntity.ok()
//    }
    @PostMapping("/updateById")
    public ResponseEntity<String> updateById(){
        return ResponseEntity.ok("Update Successful");
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> delete(){
        return ResponseEntity.ok("Deleted Successfully");
    }
}
