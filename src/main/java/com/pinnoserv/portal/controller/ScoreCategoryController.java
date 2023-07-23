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
    public ApiResponse addNewScoreCategoryMaster(@RequestBody() ScoreCategory scoreCategory) {
        return scoreCategoryService.createScoreCategory(scoreCategory);
    }

    @PostMapping("/getAll")
    public ApiResponse getScoreCategoryByProductId(@RequestBody() ScoreCategory scoreCategory) {
        return scoreCategoryService.getAll();
    }
    @PostMapping("/getById")
    public ApiResponse getById(@RequestBody ScoreCategory scoreCategory){
        return scoreCategoryService.getById(scoreCategory);
    }

    @DeleteMapping("/delete")
    public ApiResponse delete(@RequestBody ScoreCategory scoreCategory){
        return scoreCategoryService.getById(scoreCategory);
    }

    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody ScoreCategory scoreCategory) {
        return scoreCategoryService.updateById(scoreCategory);
    }
}
