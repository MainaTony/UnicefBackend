package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ScoreParamMaster;
import com.pinnoserv.portal.service.ScoreParamMasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scoreParamMaster")
public class ScoreParamMasterController {
    ScoreParamMasterService scoreParamMasterService;
    public ScoreParamMasterController(ScoreParamMasterService scoreParamMasterService){
        this.scoreParamMasterService = scoreParamMasterService;
    }
    @PostMapping("/create")
    public ApiResponse createScoreParamMaster(@RequestBody ScoreParamMaster scoreParamMaster){
        ScoreParamMaster scoreParamMasterResponse = null;
        return scoreParamMasterService.createScoreParamMaster(scoreParamMaster);
    }
    @PostMapping("/getById")
    public ApiResponse getScoreParamMasterById(@RequestBody ScoreParamMaster scoreParamMaster){
        return scoreParamMasterService.getScoreParamMasterById(scoreParamMaster);
    }
    @PostMapping("getAll")
    public ApiResponse getAllConfigs(){
        return scoreParamMasterService.getAllScoreParamMaster();
    }
    @PostMapping("/updateById")
    public ApiResponse updateScoreParamMasterById(@RequestBody ScoreParamMaster scoreParamMaster){
        return scoreParamMasterService.updateById(scoreParamMaster);
    }
    @PostMapping("/delete")
    public ApiResponse deleteScoreParamMaster(@RequestBody ScoreParamMaster scoreParamMaster){
        return scoreParamMasterService.deleteById(scoreParamMaster);
    }
}
