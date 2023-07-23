package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ApiUsers;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.repositories.ProgramRepository;
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

    @PostMapping("/create")
    public ApiResponse addNewProgram(@RequestBody() Program program) {
        return programService.createProgram(program);

    }

    @PostMapping("/viewById")
    public ApiResponse viewById(@RequestBody() Program program) {
        return programService.getById(program);

    }

    @PostMapping("/getAll")
    public ApiResponse getProgramsByOrgId() {
        return programService.getAll();
    }

    @DeleteMapping("/delete")
    public ApiResponse deleteProgram(@RequestBody Program program) {
        return programService.deleteById(program);
    }

    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody() Program program) {
        return programService.updateById(program);
    }
    
}
