package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ApiUsers;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.repositories.DelinquencyRepository;
import com.pinnoserv.portal.repositories.DelinquencyViewRepository;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.RestTemplateServices;
import com.pinnoserv.portal.utils.SharedFunctions;
import com.pinnoserv.portal.view.DeliquencyModelView;
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
    DelinquencyRepository delinquencyRepository;

    @Autowired
    DelinquencyViewRepository delinquencyViewRepository;

    @PostMapping("/getAll")
    public ResponseEntity<?> getDelinquencyByProductId(@RequestBody() Map<String, Object> requestParams) {
        LOG.info("---------------------------STARTING 'Fetch Delinquency' ----------------------------");
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
            List<DeliquencyModelView> delinquency = delinquencyViewRepository.findAllByProductIdFk(new BigInteger(productId));
            if (delinquency.isEmpty()) {
                LOG.info("DID NOT FIND Delinquency >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Not Found!");
                apiResponse.setResponseCode("01");
                apiResponse.setRecordCount(0);
                apiResponse.setEntity("Did not find any Delinquency for params " + requestParams);
                LOG.info("---------------------------ENDING 'GET Delinquency BY ID'--------------------------------'");
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
            }
            LOG.info("NUMBER OF Delinquency FOUND >> {}" + delinquency.size());
            apiResponse.setRecordCount(delinquency.size());
            apiResponse.setEntity(delinquency);
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
            apiResponse.setResponseDescription("Error! Could not fetch Delinquency");
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING 'GET Delinquency BY ID' WITH ID >> " + productId + "--------------------------------'");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LOG.info("---------------------------ENDING 'GET Delinquency BY ID' WITH ID >> " + productId + "--------------------------------'");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/listAll")
    public ResponseEntity<?> getAllDelinquency() {
        LOG.info("---------------------------STARTING 'FETCH ALL DELINQUENCYS' ----------------------------");
        ApiResponse apiResponse = new ApiResponse();
        try {
            List<DeliquencyModelView> deliquencys = delinquencyViewRepository.findAll();
            if (deliquencys.isEmpty()) {
                LOG.info("DID NOT FIND ANY DELINQUENCYS >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Not Found!");
                apiResponse.setResponseCode("01");
                apiResponse.setRecordCount(0);
                apiResponse.setEntity("Did not find any DELINQUENCYS");
                LOG.info("---------------------------ENDING 'GET ALL DELINQUENCYS'--------------------------------'");
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
            }
            LOG.info("NUMBER OF DELINQUENCYS FOUND >> {}" + deliquencys.size());
            apiResponse.setRecordCount(deliquencys.size());
            apiResponse.setEntity(deliquencys);
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
            apiResponse.setResponseDescription("Error! Could not fetch Any DELINQUENCYS");
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING GET ALL DELINQUENCYS --------------------------------'");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LOG.info("---------------------------ENDING 'GET ALL DELINQUENCYS --------------------------------'");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addNewDelinquencyModel(@RequestHeader("Authorization") String Authorization, @RequestBody() DelinquencyModel delinquencyModel) {
        LOG.info("---------------------------STARTING 'ADD NEW Delinquency' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            ApiUsers user = sharedFunctions.verifyToken(Authorization);
            if(user != null) {
            }
            delinquencyModel.setIntrash("NO");
            DelinquencyModel savedDelinquency = delinquencyRepository.saveAndFlush(delinquencyModel);
            apiResponse.setEntity(savedDelinquency);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Delinquency Model Saved.");
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
            apiResponse.setResponseDescription("Error! Could not add Delinquency Model");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING 'ADD NEW Delinquency Model'--------------------------------'");
        }
        return new ResponseEntity<>(apiResponse, responseStatus);
    }

    @PostMapping("/updateById")
    public ResponseEntity<?> updateById(@RequestHeader("Authorization") String Authorization, @RequestBody() DelinquencyModel delinquencyModel) {
        LOG.info("---------------------------STARTING 'UPDATE Delinquency Model' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            Optional<DelinquencyModel> delinquencySearch = delinquencyRepository.findByDeliquencyModelId(delinquencyModel.getDeliquencyModelId());
            if (!delinquencySearch.isPresent()) {
                LOG.info("Delinquency Model NOT FOUND >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Delinquency Model Not Found!");
                apiResponse.setResponseCode("01");
                responseStatus = HttpStatus.OK;
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            DelinquencyModel delinquencyEntity = delinquencySearch.get();
            ApiUsers user = sharedFunctions.verifyToken(Authorization);
            /*if(user != null)
                delinquencyEntity.setUpdatedBy(user.getId());*/
            delinquencyEntity.setProductIdFk(delinquencyModel.getProductIdFk());
            delinquencyEntity.setAction(delinquencyModel.getAction());
            delinquencyEntity.setPeriod(delinquencyModel.getPeriod());
            delinquencyEntity.setPenalty(delinquencyModel.getPenalty());
            delinquencyEntity.setPenaltyType(delinquencyModel.getPenaltyType());
            delinquencyEntity.setCandefault(delinquencyModel.getCandefault());
            delinquencyEntity.setCanblacklist(delinquencyModel.getCanblacklist());
            delinquencyEntity.setDaysafterdefault(delinquencyModel.getDaysafterdefault());
            delinquencyEntity.setDaystosuspension(delinquencyModel.getDaystosuspension());
            delinquencyEntity.setCansuspend(delinquencyModel.getCansuspend());
            delinquencyRepository.save(delinquencyEntity);
            apiResponse.setEntity(delinquencyEntity);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Delinquency Model Saved.");
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
            apiResponse.setResponseDescription("Error! Could not add Delinquency Model");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
        }
        LOG.info("---------------------------ENDING 'UPDATE Delinquency Model'--------------------------------'");
        return new ResponseEntity<>(apiResponse, responseStatus);
    }

    @PostMapping("/viewById")
    public ResponseEntity<?> viewById(@RequestBody() Map<String, Object> requestParams) {
        LOG.info("---------------------------STARTING 'VIEW DELINQUENCY' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            String delinquencyId = requestParams.containsKey("delinquencyId") ? requestParams.get("delinquencyId").toString() : null;
            if (delinquencyId == null) {
                apiResponse.setResponseCode("01");
                apiResponse.setResponseDescription("Error! Parameter delinquencyId is required.");
                responseStatus = HttpStatus.BAD_REQUEST;
                LOG.info("PARAMETER {delinquencyId} NOT FOUND IN REQUEST >> RETURNING WITH RESPONSE CODE >> {}", apiResponse.getResponseCode());
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            Optional<DeliquencyModelView> deliquencySearch = delinquencyViewRepository.findByDeliquencyModelId(new BigInteger(delinquencyId));
            if (!deliquencySearch.isPresent()) {
                LOG.info("DELINQUENCY NOT FOUND >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Delinquency Not Found!");
                apiResponse.setResponseCode("01");
                responseStatus = HttpStatus.OK;
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            DeliquencyModelView delinquencyEntity = deliquencySearch.get();
            apiResponse.setEntity(delinquencyEntity);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Delinquency Fetched.");
            LOG.info("OK! RETURNING WITH STATUS CODE 00");
        } catch (Exception e) {
            LOG.error("ERROR! COULD NOT FETCH DELINQUENCY >> " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause() != null ? e.getCause().toString() : "");
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not View Delinquency");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
        }
        LOG.info("---------------------------ENDING 'VIEW DELINQUENCY'--------------------------------'");
        return new ResponseEntity<>(apiResponse, responseStatus);
    }
}
