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
    public ApiResponse addNewScoreCategoryMaster(@RequestBody ScoreCategoryMaster scoreCategoryMaster) {
        return scoreCategoryMasterService.createScoreCategoryMaster(scoreCategoryMaster);
    }


    @PostMapping("/viewById")
    public ApiResponse viewById(@RequestBody ScoreCategoryMaster scoreCategoryMaster) {
        return scoreCategoryMasterService.viewById(scoreCategoryMaster);
    }


    @PostMapping("/getAll")
    public ApiResponse getScoreCategoryMasterByProductId(@RequestBody() Map<String, Object> requestParams) {
        return scoreCategoryMasterService.getAll();
    }

    @DeleteMapping("/delete")
    public ApiResponse deleteById(@RequestBody ScoreCategoryMaster scoreCategoryMaster){
        return scoreCategoryMasterService.deleteById(scoreCategoryMaster);
    }

    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody ScoreCategoryMaster scoreCategoryMaster) {
        return scoreCategoryMasterService.updateById(scoreCategoryMaster);
    }
}
