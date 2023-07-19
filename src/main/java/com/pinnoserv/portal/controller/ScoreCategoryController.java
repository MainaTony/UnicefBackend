package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ApiUsers;
import com.pinnoserv.portal.entity.ScoreCategory;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.repositories.ScoreCategoryRepository;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.RestTemplateServices;
import com.pinnoserv.portal.service.ScoreCategoryService;
import com.pinnoserv.portal.utils.SharedFunctions;
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
@RequestMapping("/scorecategory")
public class ScoreCategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(ScoreCategoryController.class);

    @Autowired
    private Environment environment;

    @Autowired
    DatabaseService dbService;

    @Autowired
    RestTemplateServices restTemplateService;

    @Autowired
    SharedFunctions sharedFunctions;

    @Autowired
    ScoreCategoryRepository scoreCategoryRepository;

    @Autowired
    ScoreCategoryService scoreCategoryService;

    @PostMapping("/create")
    public ResponseEntity<String> addNewScoreCategoryMaster(@RequestBody() ScoreCategory scoreCategory) {
        try{
            scoreCategoryService.createScoreCategory(scoreCategory);
        } catch (Exception e){

        }
        return ResponseEntity.ok("Score Category Created Successfully");
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<ScoreCategory>> getScoreCategoryByProductId(@RequestBody() Map<String, Object> requestParams) {
        List<ScoreCategory> scoreCategories = null;
        try{
            scoreCategories = scoreCategoryService.getAll();
        } catch (Exception e){
        }
        return ResponseEntity.ok(scoreCategories);
    }
    @PostMapping("/getById")
    public ResponseEntity<ScoreCategory> getById(@RequestBody ScoreCategory scoreCategory){
        ScoreCategory idScoreCategory = null;
        try {
            idScoreCategory = scoreCategoryService.getById(scoreCategory);
        } catch (Exception e){

        }

        return ResponseEntity.ok(idScoreCategory);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody ScoreCategory scoreCategory){
        try {
            scoreCategoryService.getById(scoreCategory);
        } catch (Exception e){

        }
        return ResponseEntity.ok("Score Category deleted Successfully");
    }

    @PostMapping("/updateById")
    public ResponseEntity<String> updateById(@RequestBody ScoreCategory scoreCategory) {
        try {
            scoreCategoryService.updateById(scoreCategory);
        } catch (Exception e){

        }
        return ResponseEntity.ok("Score Category Updated Successfully");
    }
}
