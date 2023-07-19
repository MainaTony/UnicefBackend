package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ApiUsers;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.repositories.DelinquencyRepository;
//import com.pinnoserv.portal.repositories.DelinquencyViewRepository;
import com.pinnoserv.portal.repositories.DelinquencyViewRepository;
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
    public ResponseEntity<String> addNewDelinquencyModel(@RequestBody DelinquencyModel delinquencyModel) {
        try{
            delinquencyService.createDelinquency(delinquencyModel);
        }
        catch (Exception e){

        }
        return ResponseEntity.ok("Delinquency Created Succesfully");

    }


    @PostMapping("/viewById")
    public ResponseEntity<DelinquencyModel> viewById(@RequestBody DelinquencyModel delinquencyModel) {
        DelinquencyModel idDelinquency = null;
        try{
            idDelinquency = delinquencyService.findById(delinquencyModel);
        }
        catch (Exception e){

        }
        return ResponseEntity.ok(idDelinquency);
    }


    @PostMapping("/getAll")
    public ResponseEntity<List<DelinquencyModel>> getAllDelinquency() {
        List<DelinquencyModel> delinquencyModels = null;
        try{
            delinquencyModels = delinquencyService.findAll();
        }
        catch (Exception e){
        }
        return ResponseEntity.ok(delinquencyModels);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDelinquency(@RequestBody DelinquencyModel delinquencyModel){
        try{
            delinquencyService.deleteById(delinquencyModel);
        }
        catch (Exception e){
        }
        return ResponseEntity.ok("Delinquency Deleted Successfully");
    }

    @PostMapping("/updateById")
    public ResponseEntity<String> updateById(@RequestBody DelinquencyModel delinquencyModel) {
        try{
            delinquencyService.updateById(delinquencyModel);
        }
        catch (Exception e){

        }
    return ResponseEntity.ok("Delinquency Model Updated successfully");
    }
}
