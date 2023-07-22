//package com.pinnoserv.portal.controller;
//
//import com.pinnoserv.portal.entity.ScoreParamMaster;
//import com.pinnoserv.portal.service.ScoreParamMasterService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/scoreParamMaster")
//public class ScoreParamMasterController {
//    ScoreParamMasterService scoreParamMasterService;
//    public ScoreParamMasterController(ScoreParamMasterService scoreParamMasterService){
//        this.scoreParamMasterService = scoreParamMasterService;
//    }
//    @PostMapping("/create")
//    public ResponseEntity<ScoreParamMaster> createScoreParamMaster(@RequestBody ScoreParamMaster scoreParamMaster){
//        ScoreParamMaster scoreParamMasterResponse = null;
//        try{
//            scoreParamMasterResponse = scoreParamMasterService.createScoreParamMaster(scoreParamMaster);
//        } catch (Exception e){
//
//        }
//        return ResponseEntity.ok(scoreParamMasterResponse);
//    }
//    @PostMapping("/getById")
//    public ResponseEntity<ScoreParamMaster> getScoreParamMasterById(@RequestBody ScoreParamMaster scoreParamMaster){
//        ScoreParamMaster scoreParamMasterId = null;
//        try{
//            scoreParamMasterId = scoreParamMasterService.getScoreParamMasterById(scoreParamMaster);
//        } catch (Exception e){}
//        return ResponseEntity.ok(scoreParamMasterId);
//    }
//    @PostMapping("getAll")
//    public ResponseEntity<List<ScoreParamMaster>> getAllConfigs(){
//        List<ScoreParamMaster> allScoreParaMasters = null;
//        try{
//            allScoreParaMasters = scoreParamMasterService.getAllScoreParamMaster();
//        } catch (Exception e){}
//        return ResponseEntity.ok(allScoreParaMasters);
//    }
//    @PostMapping("/updateById")
//    public ResponseEntity<ScoreParamMaster> updateScoreParamMasterById(@RequestBody ScoreParamMaster scoreParamMaster){
//        ScoreParamMaster updateScoreParamMaster = null;
//        try{
//            updateScoreParamMaster = scoreParamMasterService.updateById(scoreParamMaster);
//        } catch (Exception e){
//
//        }
//        return ResponseEntity.ok(updateScoreParamMaster);
//    }
//    @PostMapping("/delete")
//    public ResponseEntity<String> deleteScoreParamMaster(@RequestBody ScoreParamMaster scoreParamMaster){
//        try{
//            scoreParamMasterService.deleteById(scoreParamMaster);
//        } catch (Exception e){
//
//        }
//        return ResponseEntity.ok("Score Param Master Deleted Successfully");
//    }
//}
