package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ScoreCategory;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.repositories.ScoreCategoryRepository;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.RestTemplateServices;
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

    @PostMapping("/getAll")
    public ResponseEntity<?> getScoreCategoryByProductId(@RequestBody() Map<String, Object> requestParams) {
        LOG.info("---------------------------STARTING 'FETCH SCORE CATEGORY' ----------------------------");
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
            List<ScoreCategory> scoreCategoryList = scoreCategoryRepository.findAllByProductIdFk(new BigInteger(productId));
            if (scoreCategoryList.isEmpty()) {
                LOG.info("DID NOT FIND Score Category >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Not Found!");
                apiResponse.setResponseCode("01");
                apiResponse.setRecordCount(0);
                apiResponse.setEntity("Did not find any Score Category Records for params " + requestParams);
                LOG.info("---------------------------ENDING 'Get Score Category BY ID'--------------------------------'");
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
            }
            LOG.info("NUMBER OF Score Category Records FOUND >> {}" + scoreCategoryList.size());
            apiResponse.setRecordCount(scoreCategoryList.size());
            apiResponse.setEntity(scoreCategoryList);
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
            apiResponse.setResponseDescription("Error! Could not fetch Score Category Records");
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING 'GET Score Category WITH PRODUCT ID >> " + productId + "--------------------------------'");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LOG.info("---------------------------ENDING 'GET Score Category WITH PRODUCT ID >> " + productId + "--------------------------------'");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addNewScoreCategoryMaster(@RequestHeader("Authorization") String Authorization, @RequestBody() ScoreCategory scoreCategory) {
        LOG.info("---------------------------STARTING 'Add New Score Category' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            Users user = sharedFunctions.verifyToken(Authorization);
            if(user != null) {
            }
            scoreCategory.setIntrash("NO");
            ScoreCategory savedScoreCategory = scoreCategoryRepository.saveAndFlush(scoreCategory);
            apiResponse.setEntity(savedScoreCategory);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Score Category saved.");
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
            apiResponse.setResponseDescription("Error! Could not add Score Category");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING 'Add New Score Category'--------------------------------'");
        }
        return new ResponseEntity<>(apiResponse, responseStatus);
    }

    @PostMapping("/updateById")
    public ResponseEntity<?> updateById(@RequestHeader("Authorization") String Authorization, @RequestBody() ScoreCategory scoreCategory) {
        LOG.info("---------------------------STARTING 'UPDATE Score Category' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            Optional<ScoreCategory> scoreCategorySearch = scoreCategoryRepository.findById(scoreCategory.getId());
            if (!scoreCategorySearch.isPresent()) {
                LOG.info("Score Category Not Found >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Score Category Not Found!");
                apiResponse.setResponseCode("01");
                responseStatus = HttpStatus.OK;
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            ScoreCategory scoreCategoryEntity = scoreCategorySearch.get();
            Users user = sharedFunctions.verifyToken(Authorization);
            /*if(user != null)
                scoreCategoryEntity.setUpdatedBy(user.getId());*/
            scoreCategoryEntity.setName(scoreCategory.getName());
            scoreCategoryEntity.setProductIdFk(scoreCategory.getProductIdFk());
            scoreCategoryEntity.setContribution(scoreCategory.getContribution());
            scoreCategoryEntity.setUsed(scoreCategory.getUsed());
            scoreCategoryEntity.setScMasterIdFk(scoreCategory.getScMasterIdFk());
            scoreCategoryRepository.save(scoreCategoryEntity);
            apiResponse.setEntity(scoreCategoryEntity);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Score Category Saved.");

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
            apiResponse.setResponseDescription("Error! Could not add Score Category");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
        }
        LOG.info("---------------------------ENDING 'UPDATE Score Category'--------------------------------'");
        return new ResponseEntity<>(apiResponse, responseStatus);
    }
}
