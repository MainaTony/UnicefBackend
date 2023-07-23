package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
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
    public ApiResponse createDataSource(@RequestBody DataSource dataSource){
        return dataSourceService.createDataSource(dataSource);
    }
    @PostMapping("/getAll")
    public ApiResponse findAll() {
        return  dataSourceService.findAll();
    }

    @PostMapping("/getById")
    public ApiResponse getById(@RequestBody DataSource dataSource) {
        return dataSourceService.findById(dataSource);
    }

    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody DataSource dataSource){
        return dataSourceService.updataDataSource(dataSource);
    }
    @DeleteMapping("/delete")
    public ApiResponse delete(@RequestBody DataSource dataSource){
        return dataSourceService.deleteDataSource(dataSource);
    }
}
