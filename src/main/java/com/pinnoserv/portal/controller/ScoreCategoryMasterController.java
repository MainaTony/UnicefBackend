package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ApiUsers;
import com.pinnoserv.portal.entity.ScoreCategoryMaster;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.repositories.ScoreCategoryMasterRepository;
//import com.pinnoserv.portal.repositories.ScoreCategoryMasterViewRepository;
import com.pinnoserv.portal.repositories.ScoreCategoryMasterViewRepository;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.RestTemplateServices;
import com.pinnoserv.portal.service.ScoreCategoryMasterService;
import com.pinnoserv.portal.utils.SharedFunctions;
//import com.pinnoserv.portal.view.ScoreCategoryMasterView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.*;

@RestController
@RequestMapping("/scorecategorymaster")
public class ScoreCategoryMasterController {

    private static final Logger LOG = LoggerFactory.getLogger(ScoreCategoryMasterController.class);

    @Autowired
    private Environment environment;

    @Autowired
    DatabaseService dbService;

    @Autowired
    RestTemplateServices restTemplateService;

    @Autowired
    SharedFunctions sharedFunctions;

    @Autowired
    ScoreCategoryMasterRepository scoreCategoryMasterRepository;

    @Autowired
    ScoreCategoryMasterViewRepository scoreCategoryMasterViewRepository;

    @Autowired
    ScoreCategoryMasterService scoreCategoryMasterService;


    @PostMapping("/create")
    public ResponseEntity<String> addNewScoreCategoryMaster(@RequestBody ScoreCategoryMaster scoreCategoryMaster) {
        try{
            scoreCategoryMasterService.createScoreCategoryMaster(scoreCategoryMaster);
        }
        catch (Exception e){

        }
        return ResponseEntity.ok("Score Category Master Created Successfully");
    }


    @PostMapping("/viewById")
    public ResponseEntity<ScoreCategoryMaster> viewById(@RequestBody ScoreCategoryMaster scoreCategoryMaster) {
        ScoreCategoryMaster idScoreCategoryMaster = null;
        try{
            scoreCategoryMasterService.viewById(scoreCategoryMaster);
        }
        catch (Exception e){
        }
        return ResponseEntity.ok(idScoreCategoryMaster);
    }


    @PostMapping("/getAll")
    public ResponseEntity<List<ScoreCategoryMaster>> getScoreCategoryMasterByProductId(@RequestBody() Map<String, Object> requestParams) {
        List<ScoreCategoryMaster> scoreCategoryMasters = null;
        try{
            scoreCategoryMasters = scoreCategoryMasterService.getAll();
        } catch (Exception e){

        }
        return ResponseEntity.ok(scoreCategoryMasters);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteById(@RequestBody ScoreCategoryMaster scoreCategoryMaster){
        try{
            scoreCategoryMasterService.deleteById(scoreCategoryMaster);
        } catch (Exception e){
        }
        return ResponseEntity.ok("Score Category Master Deleted Successfully");
    }

    @PostMapping("/updateById")
    public ResponseEntity<String> updateById(@RequestBody ScoreCategoryMaster scoreCategoryMaster) {
        try{
            scoreCategoryMasterService.updateById(scoreCategoryMaster);
        } catch (Exception e){

        }
        return ResponseEntity.ok("Score Category Master Updated Successfully");
    }
}
