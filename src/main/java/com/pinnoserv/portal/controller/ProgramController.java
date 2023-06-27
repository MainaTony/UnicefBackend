//package com.pinnoserv.portal.controller;
//
//import com.pinnoserv.portal.custommodels.ApiResponse;
//import com.pinnoserv.portal.entity.ApiUsers;
//import com.pinnoserv.portal.entity.Users;
//import com.pinnoserv.portal.repositories.ProgramRepository;
////import com.pinnoserv.portal.repositories.ProgramViewRepository;
//import com.pinnoserv.portal.repositories.ProgramViewRepository;
//import com.pinnoserv.portal.service.DatabaseService;
//import com.pinnoserv.portal.service.RestTemplateServices;
//import com.pinnoserv.portal.utils.SharedFunctions;
////import com.pinnoserv.portal.view.ProgramView;
//import com.pinnoserv.portal.entity.Program;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.math.BigInteger;
//import java.util.*;
//
//@RestController
//@RequestMapping("/program")
//public class ProgramController {
//
//    private static final Logger LOG = LoggerFactory.getLogger(ProgramController.class);
//
//    @Autowired
//    private Environment environment;
//
//    @Autowired
//    DatabaseService dbService;
//
//    @Autowired
//    RestTemplateServices restTemplateService;
//
//    @Autowired
//    SharedFunctions sharedFunctions;
//
//    @Autowired
//    ProgramRepository programRepository;
//
//    @Autowired
//    ProgramViewRepository programViewRepository;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> addNewProgram(@RequestHeader("Authorization") String Authorization, @RequestBody() Program program) {
//        LOG.info("---------------------------STARTING 'ADD NEW PROGRAM' --------------------------------");
//        ApiResponse apiResponse = new ApiResponse();
//        HttpStatus responseStatus = HttpStatus.OK;
//        try {
//            ApiUsers user = sharedFunctions.verifyToken(Authorization);
//            if(user != null) {
//                program.setCreatedBy(user.getId());
//                program.setOrganisationIdFk(user.getOrganisationIdFk());
//            }
//            if(program.getStatus() == null)
//                program.setStatus(new Integer("1"));
//                program.setDateCreated(new Date(System.currentTimeMillis()));
//                program.setIntrash("NO");
//                Program savedProgram = programRepository.saveAndFlush(program);
//                apiResponse.setEntity(savedProgram);
//                apiResponse.setResponseCode("00");
//                apiResponse.setResponseDescription("Success! Program saved.");
//        } catch (Exception e) {
//            LOG.error("ERROR! COULD NOT SAVE >> " + e.getMessage());
//            e.printStackTrace();
//            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
//                Map<String, String> error = new HashMap();
//                error.put("error", e.getMessage());
//                error.put("cause", e.getCause().toString());
//                apiResponse.setEntity(error);
//            }
//            apiResponse.setResponseCode("01");
//            apiResponse.setResponseDescription("Error! Could not add Program");
//            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
//            LOG.info("---------------------------ENDING 'ADD NEW PROGRAM'--------------------------------'");
//        }
//        return new ResponseEntity<>(apiResponse, responseStatus);
//    }
//
//    @PostMapping("/viewById")
//    public ResponseEntity<?> viewById(@RequestBody() Map<String, Object> requestParams) {
//        LOG.info("---------------------------STARTING 'VIEW PROGRAM' --------------------------------");
//        ApiResponse apiResponse = new ApiResponse();
//        HttpStatus responseStatus = HttpStatus.OK;
//        try {
//            String programId = requestParams.containsKey("programId") ? requestParams.get("programId").toString() : null;
////            String dataSourceId = requestParams.containsKey("dataSourceId") ? requestParams.get("dataSourceId").toString() : null;
//            if (programId == null) {
//                apiResponse.setResponseCode("01");
//                apiResponse.setResponseDescription("Error! Parameter programId is required.");
//                responseStatus = HttpStatus.BAD_REQUEST;
//                LOG.info("PARAMETER {programId} NOT FOUND IN REQUEST >> RETURNING WITH RESPONSE CODE >> {}", apiResponse.getResponseCode());
//                return new ResponseEntity<>(apiResponse, responseStatus);
//            }
//            Optional<Program> programSearch = programViewRepository.findByProgramId(new Integer(programId));
//            if (!programSearch.isPresent()) {
//                LOG.info("PROGRAM NOT FOUND >> RETURNING WITH STATUS CODE 01");
//                apiResponse.setResponseDescription("Program Not Found!");
//                apiResponse.setResponseCode("01");
//                responseStatus = HttpStatus.OK;
//                return new ResponseEntity<>(apiResponse, responseStatus);
//            }
//            Program programEntity = programSearch.get();
//            apiResponse.setEntity(programEntity);
//            apiResponse.setResponseCode("00");
//            apiResponse.setResponseDescription("Success! Program Fetched.");
//            LOG.info("OK! RETURNING WITH STATUS CODE 00");
//        } catch (Exception e) {
//            LOG.error("ERROR! COULD NOT FETCH PROGRAM >> " + e.getMessage());
//            e.printStackTrace();
//            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
//                Map<String, String> error = new HashMap();
//                error.put("error", e.getMessage());
//                error.put("cause", e.getCause() != null ? e.getCause().toString() : "");
//                apiResponse.setEntity(error);
//            }
//            apiResponse.setResponseCode("01");
//            apiResponse.setResponseDescription("Error! Could not View Program");
//            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
//        }
//        LOG.info("---------------------------ENDING 'VIEW PROGRAM'--------------------------------'");
//        return new ResponseEntity<>(apiResponse, responseStatus);
//    }
//
//
//    @PostMapping("/getAll")
//    public ResponseEntity<?> getProgramsByOrgId(@RequestBody() Map<String, Object> requestParams) {
//        LOG.info("---------------------------STARTING 'FETCH PROGRAMS' ----------------------------");
//        LOG.info("PARAMS GOTTEN >> {}", requestParams);
//        ApiResponse apiResponse = new ApiResponse();
//        HttpStatus httpStatus = null;
//        String orgId = requestParams.containsKey("organisationId") ? requestParams.get("organisationId").toString() : null;
//        if (orgId == null) {
//            apiResponse.setResponseCode("01");
//            apiResponse.setResponseDescription("Error! Parameter organisationId is required.");
//            httpStatus = HttpStatus.BAD_REQUEST;
//            LOG.info("PARAMETER {organisationId} NOT FOUND IN REQUEST >> RETURNING WITH RESPONSE CODE >> {}", apiResponse.getResponseCode());
//            return new ResponseEntity<>(apiResponse, httpStatus);
//        }
//        try {
//            List<Program> programs = programViewRepository.findAllByOrganisationIdFk(new Integer(orgId));
//            if (programs.isEmpty()) {
//                LOG.info("DID NOT FIND PROGRAMS >> RETURNING WITH STATUS CODE 01");
//                apiResponse.setResponseDescription("Not Found!");
//                apiResponse.setResponseCode("01");
//                apiResponse.setRecordCount(0);
//                apiResponse.setEntity("Did not find any Programs for params " + requestParams);
//                LOG.info("---------------------------ENDING 'GET PROGRAMS BY ID'--------------------------------'");
//                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//            }
//            LOG.info("NUMBER OF PROGRAMS FOUND >> {}" + programs.size());
//            apiResponse.setRecordCount(programs.size());
//            apiResponse.setEntity(programs);
//            apiResponse.setResponseCode("00");
//            LOG.info("OK >> RETURNING WITH STATUS CODE 00");
//        } catch (Exception e) {
//            LOG.error("ERROR! " + e.getMessage());
//            e.printStackTrace();
//            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
//                Map<String, String> error = new HashMap();
//                error.put("error", e.getMessage());
//                error.put("cause", e.getCause().toString());
//                apiResponse.setEntity(error);
//            }
//            apiResponse.setResponseCode("01");
//            apiResponse.setResponseDescription("Error! Could not fetch PROGRAMS");
//            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
//            LOG.info("---------------------------ENDING 'GET PROGRAMS BY ID' WITH ID >> " + orgId + "--------------------------------'");
//            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        LOG.info("---------------------------ENDING 'GET PROGRAMS BY ID' WITH ID >> " + orgId + "--------------------------------'");
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }
//
//    @PostMapping("/listAll")
//    public ResponseEntity<?> getAllPrograms() {
//        LOG.info("---------------------------STARTING 'FETCH ALL PROGRAMS' ----------------------------");
//        ApiResponse apiResponse = new ApiResponse();
//        try {
//            List<Program> programs = programViewRepository.findAll();
//            if (programs.isEmpty()) {
//                LOG.info("DID NOT FIND ANY PROGRAMS >> RETURNING WITH STATUS CODE 01");
//                apiResponse.setResponseDescription("Not Found!");
//                apiResponse.setResponseCode("01");
//                apiResponse.setRecordCount(0);
//                apiResponse.setEntity("Did not find any Programs");
//                LOG.info("---------------------------ENDING 'GET ALL PROGRAMS'--------------------------------'");
//                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//            }
//            LOG.info("NUMBER OF PROGRAMS FOUND >> {}" + programs.size());
//            apiResponse.setRecordCount(programs.size());
//            apiResponse.setEntity(programs);
//            apiResponse.setResponseCode("00");
//            LOG.info("OK >> RETURNING WITH STATUS CODE 00");
//        } catch (Exception e) {
//            LOG.error("ERROR! " + e.getMessage());
//            e.printStackTrace();
//            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
//                Map<String, String> error = new HashMap();
//                error.put("error", e.getMessage());
//                error.put("cause", e.getCause().toString());
//                apiResponse.setEntity(error);
//            }
//            apiResponse.setResponseCode("01");
//            apiResponse.setResponseDescription("Error! Could not fetch Any PROGRAMS");
//            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
//            LOG.info("---------------------------ENDING GET ALL PROGRAMS --------------------------------'");
//            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        LOG.info("---------------------------ENDING 'GET ALL PROGRAMS --------------------------------'");
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }
//
//
//
//    @PostMapping("/updateById")
//    public ResponseEntity<?> updateById(@RequestHeader("Authorization") String Authorization, @RequestBody() Program program) {
//        LOG.info("---------------------------STARTING 'UPDATE PROGRAM' --------------------------------");
//        ApiResponse apiResponse = new ApiResponse();
//        HttpStatus responseStatus = HttpStatus.OK;
//        try {
//            Optional<Program> programSearch = programRepository.findByProgramId(program.getProgramId());
//            if (!programSearch.isPresent()) {
//                LOG.info("PROGRAM NOT FOUND >> RETURNING WITH STATUS CODE 01");
//                apiResponse.setResponseDescription("Program Not Found!");
//                apiResponse.setResponseCode("01");
//                responseStatus = HttpStatus.OK;
//                return new ResponseEntity<>(apiResponse, responseStatus);
//            }
//            Program programEntity = programSearch.get();
//            ApiUsers user = sharedFunctions.verifyToken(Authorization);
//            /*if(user != null)
//                program.setUpdatedBy(user.getId());*/
//            programEntity.setDataSourceIdFk(program.getDataSourceIdFk());
//            programEntity.setName(program.getName());
//            programEntity.setDescription(program.getDescription());
//            programEntity.setPrimaryIdentityType(program.getPrimaryIdentityType());
//            programEntity.setStatus(program.getStatus());
//            programRepository.save(programEntity);
//            apiResponse.setEntity(programEntity);
//            apiResponse.setResponseCode("00");
//            apiResponse.setResponseDescription("Success! Program Saved.");
//            LOG.info("OK! RETURNING WITH STATUS CODE 00");
//        } catch (Exception e) {
//            LOG.error("ERROR! COULD NOT UPDATE >> " + e.getMessage());
//            e.printStackTrace();
//            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
//                Map<String, String> error = new HashMap();
//                error.put("error", e.getMessage());
//                error.put("cause", e.getCause() != null ? e.getCause().toString() : "");
//                apiResponse.setEntity(error);
//            }
//            apiResponse.setResponseCode("01");
//            apiResponse.setResponseDescription("Error! Could not add Program");
//            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
//        }
//        LOG.info("---------------------------ENDING 'UPDATE PROGRAM'--------------------------------'");
//        return new ResponseEntity<>(apiResponse, responseStatus);
//    }
//
//
//}
