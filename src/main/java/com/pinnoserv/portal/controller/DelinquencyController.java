package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ApiUsers;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.repositories.DelinquencyRepository;
//import com.pinnoserv.portal.repositories.DelinquencyViewRepository;
//import com.pinnoserv.portal.repositories.DelinquencyViewRepository;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.DelinquencyService;
import com.pinnoserv.portal.service.RestTemplateServices;
import com.pinnoserv.portal.utils.SharedFunctions;
//import com.pinnoserv.portal.view.DeliquencyModelView;
import com.pinnoserv.portal.entity.DelinquencyModel;
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
@RequestMapping("/delinquency")
public class DelinquencyController {

    private static final Logger LOG = LoggerFactory.getLogger(DelinquencyController.class);

    @Autowired
    private Environment environment;

    @Autowired
    DatabaseService dbService;

    @Autowired
    RestTemplateServices restTemplateService;

    @Autowired
    SharedFunctions sharedFunctions;

    @Autowired
    DelinquencyService delinquencyService;


    @PostMapping("/create")
    public ApiResponse addNewDelinquencyModel(@RequestBody DelinquencyModel delinquencyModel) {
        return delinquencyService.createDelinquency(delinquencyModel);
    }


    @PostMapping("/viewById")
    public ApiResponse viewById(@RequestBody DelinquencyModel delinquencyModel) {
        return delinquencyService.findById(delinquencyModel);
    }


    @PostMapping("/getAll")
    public ApiResponse getAllDelinquency() {
        return delinquencyService.findAll();
    }

    @DeleteMapping("/delete")
    public ApiResponse deleteDelinquency(@RequestBody DelinquencyModel delinquencyModel){
        return delinquencyService.deleteById(delinquencyModel);
    }

    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody DelinquencyModel delinquencyModel) {
        return delinquencyService.updateById(delinquencyModel);
    }
}
