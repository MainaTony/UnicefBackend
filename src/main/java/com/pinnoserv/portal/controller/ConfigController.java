package com.pinnoserv.portal.controller;

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
    public ResponseEntity<Config> createConfig(@RequestBody Config config){
        Config configResponse = null;
        try{
            configResponse = configService.createConfig(config);
        } catch (Exception e){

        }
        return ResponseEntity.ok(configResponse);
    }
    @PostMapping("/getById")
    public ResponseEntity<Config> getConfigById(@RequestBody Config config){
        Config configId = null;
        try{
            configId = configService.getConfigById(config);
        } catch (Exception e){}
        return ResponseEntity.ok(configId);
    }
    @PostMapping("getAll")
    public ResponseEntity<List<Config>> getAllConfigs(){
        List<Config> allConfigs = null;
        try{
            allConfigs = configService.getAllConfigs();
        } catch (Exception e){}
        return ResponseEntity.ok(allConfigs);
    }
    @PostMapping("/updateById")
    public ResponseEntity<Config> updateConfigById(@RequestBody Config config){
        Config updateConfig = null;
        try{
            updateConfig = configService.updateById(config);
        } catch (Exception e){

        }
        return ResponseEntity.ok(updateConfig);
    }
    @PostMapping("/delete")
    public ResponseEntity<String> deleteConfig(@RequestBody Config config){
        try{
            configService.deleteById(config);
        } catch (Exception e){

        }
        return ResponseEntity.ok("Config Deleted Successfully");
    }
}
