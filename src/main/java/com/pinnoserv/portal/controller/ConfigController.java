package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.Config;
import com.pinnoserv.portal.service.ConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {
    ConfigService configService;
    public ConfigController(ConfigService configService){
        this.configService = configService;
    }
    @PostMapping("/create")
    public ApiResponse createConfig(@RequestBody Config config){
        return configService.createConfig(config);
    }
    @PostMapping("/getById")
    public ApiResponse getConfigById(@RequestBody Config config){
        return configService.getConfigById(config);
    }
    @PostMapping("getAll")
    public ApiResponse getAllConfigs(){
        return configService.getAllConfigs();
    }
    @PostMapping("/updateById")
    public ApiResponse updateConfigById(@RequestBody Config config){
        return configService.updateById(config);
    }
    @PostMapping("/delete")
    public ApiResponse deleteConfig(@RequestBody Config config){
        return configService.deleteById(config);
    }
}
