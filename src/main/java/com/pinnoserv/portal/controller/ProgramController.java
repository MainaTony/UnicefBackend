package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ApiUsers;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.repositories.ProgramRepository;
//import com.pinnoserv.portal.repositories.ProgramViewRepository;
import com.pinnoserv.portal.repositories.ProgramViewRepository;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.ProgramService;
import com.pinnoserv.portal.service.RestTemplateServices;
import com.pinnoserv.portal.utils.SharedFunctions;
//import com.pinnoserv.portal.view.ProgramView;
import com.pinnoserv.portal.entity.Program;
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
@RequestMapping("/program")
public class ProgramController {

    private static final Logger LOG = LoggerFactory.getLogger(ProgramController.class);

    @Autowired
    ProgramService programService;

    @Autowired
    private Environment environment;

    @Autowired
    DatabaseService dbService;

    @Autowired
    RestTemplateServices restTemplateService;

    @Autowired
    SharedFunctions sharedFunctions;

    @Autowired
    ProgramRepository programRepository;

//    @Autowired
    ProgramViewRepository programViewRepository;

    @PostMapping("/create")
    public ResponseEntity<String> addNewProgram(@RequestBody() Program program) {

        try {
            programService.createProgram(program);

        } catch (Exception e) {

        }
        return ResponseEntity.ok("Product Created Successfully");

    }

    @PostMapping("/viewById")
    public ResponseEntity<Program> viewById(@RequestBody() Program program) {
        Program programResponse = null;
        try {
            programResponse = programService.getById(program);
            return ResponseEntity.ok(programResponse);
        } catch (Exception e) {
        }
    return ResponseEntity.ok(programResponse);

    }


    @PostMapping("/getAll")
    public ResponseEntity<List<Program>> getProgramsByOrgId() {
        List<Program> AllPrograms = null;
        try{
            AllPrograms = programService.getAll();
        } catch (Exception e){

        }
        return ResponseEntity.ok(AllPrograms);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProgram(@RequestBody Program program) {
        try{
            programService.deleteById(program);
        } catch (Exception e){

        }
        return ResponseEntity.ok("Program Deleted Successfully");

    }


    @PostMapping("/updateById")
    public ResponseEntity<String> updateById(@RequestBody() Program program) {
        try{
            programService.updateById(program);
        }
        catch (Exception e){

        }

        return ResponseEntity.ok("Program Deleted Successfully");

    }


}
