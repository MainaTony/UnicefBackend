package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ScoreParam;
import com.pinnoserv.portal.service.ConfigService;
import com.pinnoserv.portal.service.ScoreParamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scoreParam")
@Slf4j
public class ScoreParamController {
    ScoreParamService scoreParamService;
    public ScoreParamController (ScoreParamService scoreParamService){
        this.scoreParamService = scoreParamService;
    }
    @PostMapping("/create")
    public ApiResponse createScoreParam(@RequestBody ScoreParam scoreParam){
        return scoreParamService.createScoreParam(scoreParam);
    }
    @PostMapping("/getById")
    public ApiResponse getScoreParamById(@RequestBody ScoreParam scoreParam){
        return scoreParamService.getScoreParamById(scoreParam);
    }
    @PostMapping("getAll")
    public ApiResponse getAllConfigs(){
        return scoreParamService.getAllScoreParams();
    }
    @PostMapping("/updateById")
    public ApiResponse updateScoreParamById(@RequestBody ScoreParam scoreParam){
        return scoreParamService.updateById(scoreParam);
    }
    @PostMapping("/delete")
    public ApiResponse deleteScoreParam(@RequestBody ScoreParam scoreParam){
        return scoreParamService.deleteById(scoreParam);
    }
}
