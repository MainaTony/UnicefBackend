package com.pinnoserv.portal.controller;

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
    public ResponseEntity<ScoreParam> createScoreParam(@RequestBody ScoreParam scoreParam){
        ScoreParam scoreParamResponse = null;
        try{
            scoreParamResponse = scoreParamService.createScoreParam(scoreParam);
        } catch (Exception e){

        }
        return ResponseEntity.ok(scoreParamResponse);
    }
    @PostMapping("/getById")
    public ResponseEntity<ScoreParam> getScoreParamById(@RequestBody ScoreParam scoreParam){
        ScoreParam scoreParamId = null;
        try{
            scoreParamId = scoreParamService.getScoreParamById(scoreParam);
        } catch (Exception e){}
        return ResponseEntity.ok(scoreParamId);
    }
    @PostMapping("getAll")
    public ResponseEntity<List<ScoreParam>> getAllConfigs(){
        List<ScoreParam> allScoreParams = null;
        try{
            allScoreParams = scoreParamService.getAllScoreParams();
        } catch (Exception e){}
        return ResponseEntity.ok(allScoreParams);
    }
    @PostMapping("/updateById")
    public ResponseEntity<ScoreParam> updateScoreParamById(@RequestBody ScoreParam scoreParam){
        ScoreParam updateScoreParam = null;
        try{
            updateScoreParam = scoreParamService.updateById(scoreParam);
        } catch (Exception e){

        }
        return ResponseEntity.ok(updateScoreParam);
    }
    @PostMapping("/delete")
    public ResponseEntity<String> deleteScoreParam(@RequestBody ScoreParam scoreParam){
        try{
            scoreParamService.deleteById(scoreParam);
        } catch (Exception e){

        }
        return ResponseEntity.ok("Score Param Deleted Successfully");
    }
}
