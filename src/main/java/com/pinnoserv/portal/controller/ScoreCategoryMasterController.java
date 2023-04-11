package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ApiUsers;
import com.pinnoserv.portal.entity.ScoreCategoryMaster;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.repositories.ScoreCategoryMasterRepository;
import com.pinnoserv.portal.repositories.ScoreCategoryMasterViewRepository;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.RestTemplateServices;
import com.pinnoserv.portal.utils.SharedFunctions;
import com.pinnoserv.portal.view.ScoreCategoryMasterView;
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

    @PostMapping("/getAll")
    public ResponseEntity<?> getScoreCategoryMasterByProductId(@RequestBody() Map<String, Object> requestParams) {
        LOG.info("---------------------------STARTING 'FETCH SCORE CATEGORY MASTER' ----------------------------");
        LOG.info("PARAMS GOTTEN >> {}", requestParams);
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus httpStatus = null;
        String productId = requestParams.containsKey("productId") ? requestParams.get("productId").toString() : null;
        if (productId == null) {
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Parameter productId is required.");
            httpStatus = HttpStatus.BAD_REQUEST;
            LOG.info("PARAMETER {productId} NOT FOUND IN REQUEST >> RETURNING WITH RESPONSE CODE >> {}", apiResponse.getResponseCode());
            return new ResponseEntity<>(apiResponse, httpStatus);
        }
        try {
            List<ScoreCategoryMasterView> scoreCategoryMasterList = scoreCategoryMasterViewRepository.findAllByProductIdFk(new BigInteger(productId));
            if (scoreCategoryMasterList.isEmpty()) {
                LOG.info("DID NOT FIND Score Category Master >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Not Found!");
                apiResponse.setResponseCode("01");
                apiResponse.setRecordCount(0);
                apiResponse.setEntity("Did not find any Score Category Master Records for params " + requestParams);
                LOG.info("---------------------------ENDING 'Get Score Category Master BY ID'--------------------------------'");
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
            }
            LOG.info("NUMBER OF Score Category Master Records FOUND >> {}" + scoreCategoryMasterList.size());
            apiResponse.setRecordCount(scoreCategoryMasterList.size());
            apiResponse.setEntity(scoreCategoryMasterList);
            apiResponse.setResponseCode("00");
            LOG.info("OK >> RETURNING WITH STATUS CODE 00");
        } catch (Exception e) {
            LOG.error("ERROR! " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause().toString());
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not fetch Score Category Master Records");
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING 'GET Score Category Master BY ID' WITH ID >> " + productId + "--------------------------------'");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LOG.info("---------------------------ENDING 'GET Score Category Master BY ID' WITH ID >> " + productId + "--------------------------------'");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/listAll")
    public ResponseEntity<?> getAllScoreCategoryMaster() {
        LOG.info("---------------------------STARTING 'FETCH ALL SCORE CATEGORY MASTER' ----------------------------");
        ApiResponse apiResponse = new ApiResponse();
        try {
            List<ScoreCategoryMasterView> scoreCategoryMaster = scoreCategoryMasterViewRepository.findAll();
            if (scoreCategoryMaster.isEmpty()) {
                LOG.info("DID NOT FIND ANY SCORE CATEGORY MASTER >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Not Found!");
                apiResponse.setResponseCode("01");
                apiResponse.setRecordCount(0);
                apiResponse.setEntity("Did not find any Score Category Master");
                LOG.info("---------------------------ENDING 'GET ALL SCORE CATEGORY MASTER'--------------------------------'");
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
            }
            LOG.info("NUMBER OF SCORE CATEGORY MASTER FOUND >> {}" + scoreCategoryMaster.size());
            apiResponse.setRecordCount(scoreCategoryMaster.size());
            apiResponse.setEntity(scoreCategoryMaster);
            apiResponse.setResponseCode("00");
            LOG.info("OK >> RETURNING WITH STATUS CODE 00");
        } catch (Exception e) {
            LOG.error("ERROR! " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause().toString());
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not fetch Any Score Category Master");
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING GET ALL SCORE CATEGORY MASTER --------------------------------'");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LOG.info("---------------------------ENDING 'GET ALL SCORE CATEGORY MASTER --------------------------------'");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addNewScoreCategoryMaster(@RequestHeader("Authorization") String Authorization, @RequestBody() ScoreCategoryMaster scoreCategoryMaster) {
        LOG.info("---------------------------STARTING 'Add New Score Category Master' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            ApiUsers user = sharedFunctions.verifyToken(Authorization);
            if(user != null) {
            }
            //private String used;
            ScoreCategoryMaster savedScoreCategoryMaster = scoreCategoryMasterRepository.saveAndFlush(scoreCategoryMaster);
            apiResponse.setEntity(savedScoreCategoryMaster);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Score Category Master saved.");
        } catch (Exception e) {
            LOG.error("ERROR! COULD NOT SAVE >> " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause().toString());
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not add Score Category Master");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING 'Add New Score Category Master'--------------------------------'");
        }
        return new ResponseEntity<>(apiResponse, responseStatus);
    }

    @PostMapping("/updateById")
    public ResponseEntity<?> updateById(@RequestHeader("Authorization") String Authorization, @RequestBody() ScoreCategoryMaster scoreCategoryMaster) {
        LOG.info("---------------------------STARTING 'UPDATE Score Category Master' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            Optional<ScoreCategoryMaster> scoreCategoryMasterSearch = scoreCategoryMasterRepository.findById(scoreCategoryMaster.getId());
            if (!scoreCategoryMasterSearch.isPresent()) {
                LOG.info("Score Category Master Not Found >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Score Category Master Not Found!");
                apiResponse.setResponseCode("01");
                responseStatus = HttpStatus.OK;
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            ScoreCategoryMaster scoreCategoryMasterEntity = scoreCategoryMasterSearch.get();
            ApiUsers user = sharedFunctions.verifyToken(Authorization);
            /*if(user != null)
                scoreCategoryMasterEntity.setUpdatedBy(user.getId());*/
            scoreCategoryMasterEntity.setName(scoreCategoryMaster.getName());
            scoreCategoryMasterEntity.setProductIdFk(scoreCategoryMaster.getProductIdFk());
            scoreCategoryMasterEntity.setContribution(scoreCategoryMaster.getContribution());
            scoreCategoryMasterEntity.setUsed(scoreCategoryMaster.getUsed());
            scoreCategoryMasterRepository.save(scoreCategoryMasterEntity);
            apiResponse.setEntity(scoreCategoryMasterEntity);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Score Category Master Saved.");
            LOG.info("OK! RETURNING WITH STATUS CODE 00");
        } catch (Exception e) {
            LOG.error("ERROR! COULD NOT UPDATE >> " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause() != null ? e.getCause().toString() : "");
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not add Score Category Master");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
        }
        LOG.info("---------------------------ENDING 'UPDATE Score Category Master'--------------------------------'");
        return new ResponseEntity<>(apiResponse, responseStatus);
    }

    @PostMapping("/viewById")
    public ResponseEntity<?> viewById(@RequestBody() Map<String, Object> requestParams) {
        LOG.info("---------------------------STARTING 'VIEW SCORE CATEGORY MASTER' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            String scoreCategoryMasterId = requestParams.containsKey("scoreCategoryMasterId") ? requestParams.get("scoreCategoryMasterId").toString() : null;
            if (scoreCategoryMasterId == null) {
                apiResponse.setResponseCode("01");
                apiResponse.setResponseDescription("Error! Parameter scoreCategoryMasterId is required.");
                responseStatus = HttpStatus.BAD_REQUEST;
                LOG.info("PARAMETER {scoreCategoryMasterId} NOT FOUND IN REQUEST >> RETURNING WITH RESPONSE CODE >> {}", apiResponse.getResponseCode());
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            Optional<ScoreCategoryMasterView> scoreCategoryMasterSearch = scoreCategoryMasterViewRepository.findById(new BigInteger(scoreCategoryMasterId));
            if (!scoreCategoryMasterSearch.isPresent()) {
                LOG.info("SCORE CATEGORY MASTER NOT FOUND >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Score Category Master Not Found!");
                apiResponse.setResponseCode("01");
                responseStatus = HttpStatus.OK;
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            ScoreCategoryMasterView scoreCategoryMasterEntity = scoreCategoryMasterSearch.get();
            apiResponse.setEntity(scoreCategoryMasterEntity);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Score Category Master Fetched.");
            LOG.info("OK! RETURNING WITH STATUS CODE 00");
        } catch (Exception e) {
            LOG.error("ERROR! COULD NOT FETCH SCORE CATEGORY MASTER >> " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause() != null ? e.getCause().toString() : "");
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not View Score Category Master");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
        }
        LOG.info("---------------------------ENDING 'VIEW SCORE CATEGORY MASTER'--------------------------------'");
        return new ResponseEntity<>(apiResponse, responseStatus);
    }
}
