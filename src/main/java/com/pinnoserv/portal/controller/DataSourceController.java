package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.entity.ApiUsers;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.DataSource;
import com.pinnoserv.portal.repositories.DataSourceRepository;
//import com.pinnoserv.portal.repositories.DataSourceViewRepository;
import com.pinnoserv.portal.repositories.DataSourceViewRepository;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.RestTemplateServices;
import com.pinnoserv.portal.utils.SharedFunctions;
//import com.pinnoserv.portal.view.DataSourceView;
import com.pinnoserv.portal.view.DataSourceView;
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
@RequestMapping("/datasource")
public class DataSourceController {

    private static final Logger LOG = LoggerFactory.getLogger(DataSourceController.class);

    @Autowired
    private Environment environment;

    @Autowired
    DatabaseService dbService;

    @Autowired
    RestTemplateServices restTemplateService;

    @Autowired
    SharedFunctions sharedFunctions;

    @Autowired
    DataSourceRepository dataSourceRepository;

    @Autowired
    DataSourceViewRepository dataSourceViewRepository;
//
//    @PostMapping("/getAll")
//    public ResponseEntity<?> getDataSourceByOrgId(@RequestBody() Map<String, Object> requestParams) {
//        LOG.info("---------------------------STARTING 'FETCH DATA SOURCE' ----------------------------");
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
//            List<DataSourceView> dataSource = dataSourceViewRepository.findAllByOrganisationIdFk(new BigInteger(orgId));
//            if (dataSource.isEmpty()) {
//                LOG.info("DID NOT FIND DATA SOURCE >> RETURNING WITH STATUS CODE 01");
//                apiResponse.setResponseDescription("Not Found!");
//                apiResponse.setResponseCode("01");
//                apiResponse.setRecordCount(0);
//                apiResponse.setEntity("Did not find any DataSource for params " + requestParams);
//                LOG.info("---------------------------ENDING 'GET DATA SOURCE BY ID'--------------------------------'");
//                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//            }
//            LOG.info("NUMBER OF DATA SOURCE FOUND >> {}" + dataSource.size());
//            apiResponse.setRecordCount(dataSource.size());
//            apiResponse.setEntity(dataSource);
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
//            apiResponse.setResponseDescription("Error! Could not fetch DATA SOURCE");
//            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
//            LOG.info("---------------------------ENDING 'GET DATA SOURCE BY ID' WITH ID >> " + orgId + "--------------------------------'");
//            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        LOG.info("---------------------------ENDING 'GET DATA SOURCE BY ID' WITH ID >> " + orgId + "--------------------------------'");
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

//    @PostMapping("/listAll")
//    public ResponseEntity<?> getAllDataSource() {
//        LOG.info("---------------------------STARTING 'FETCH ALL DATA SOURCE' ----------------------------");
//        ApiResponse apiResponse = new ApiResponse();
//        try {
//            List<DataSourceView> dataSource = dataSourceViewRepository.findAll();
//            if (dataSource.isEmpty()) {
//                LOG.info("DID NOT FIND ANY DATA SOURCE >> RETURNING WITH STATUS CODE 01");
//                apiResponse.setResponseDescription("Not Found!");
//                apiResponse.setResponseCode("01");
//                apiResponse.setRecordCount(0);
//                apiResponse.setEntity("Did not find any DataSource");
//                LOG.info("---------------------------ENDING 'GET ALL DATA SOURCE'--------------------------------'");
//                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//            }
//            LOG.info("NUMBER OF DATA SOURCE FOUND >> {}" + dataSource.size());
//            apiResponse.setRecordCount(dataSource.size());
//            apiResponse.setEntity(dataSource);
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
//            apiResponse.setResponseDescription("Error! Could not fetch DATA SOURCE");
//            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
//            LOG.info("---------------------------ENDING 'GET ALL DATA SOURCES' --------------------------------'");
//            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        LOG.info("---------------------------ENDING 'GET DATA ALL SOURCES' --------------------------------'");
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

    @PostMapping("/create")
    public ResponseEntity<?> addNewDataSource(@RequestHeader("Authorization") String Authorization, @RequestBody() DataSource dataSource) {
        LOG.info("---------------------------STARTING 'ADD NEW DATA SOURCE' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            LOG.info("---------------------------ACCESSING THE USERNAME AND PASSWORD IN THE USER TABLE--------------------------------");
            ApiUsers user = sharedFunctions.verifyToken(Authorization);
            LOG.info("---------------------------AFTER VERIFYING THE TOKEN, PROCEEDING TO CREATE DATASOURCE--------------------------------");
            if(user != null) {
                dataSource.setCreatedBy(user.getId());
                dataSource.setOrganisationIdFk(user.getOrganisationIdFk());
            }
            if(dataSource.getStatus() == null)
                dataSource.setStatus(new Integer("1"));
                dataSource.setDateCreated(new Date(System.currentTimeMillis()));
                dataSource.setAction("New");
                dataSource.setIntrash("NO");
                DataSource savedDatasource = dataSourceRepository.saveAndFlush(dataSource);
                apiResponse.setEntity(savedDatasource);
                apiResponse.setResponseCode("00");
                apiResponse.setResponseDescription("Success! DataSource saved.");
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
                apiResponse.setResponseDescription("Error! Could not add DataSource");
                responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                LOG.info("OK >> RETURNING WITH STATUS CODE 01");
                LOG.info("---------------------------ENDING 'ADD NEW DATA SOURCE'--------------------------------'");
        }
        return new ResponseEntity<>(apiResponse, responseStatus);
    }

//    @PostMapping("/updateById")
//    public ResponseEntity<?> updateById(@RequestHeader("Authorization") String Authorization, @RequestBody() DataSource dataSource) {
//        LOG.info("---------------------------STARTING 'UPDATE DATA SOURCE' --------------------------------");
//        ApiResponse apiResponse = new ApiResponse();
//        HttpStatus responseStatus = HttpStatus.OK;
//        try {
//            Optional<DataSource> dataSourceSearch = dataSourceRepository.findByDataSourceId(dataSource.getDataSourceId());
//            if (!dataSourceSearch.isPresent()) {
//                LOG.info("DATA SOURCE NOT FOUND >> RETURNING WITH STATUS CODE 01");
//                apiResponse.setResponseDescription("DataSource Not Found!");
//                apiResponse.setResponseCode("01");
//                responseStatus = HttpStatus.OK;
//                return new ResponseEntity<>(apiResponse, responseStatus);
//            }
//            DataSource dataSourceEntity = dataSourceSearch.get();
//            ApiUsers user = sharedFunctions.verifyToken(Authorization);
//            /*if(user != null)
//                dataSourceEntity.setUpdatedBy(user.getId());*/
//
//            dataSourceEntity.setName(dataSource.getName());
//            dataSourceEntity.setDataSourceUrl(dataSource.getDataSourceUrl());
//            dataSourceEntity.setExcelUrl(dataSource.getExcelUrl());
//            dataSourceEntity.setExcelPath(dataSource.getExcelPath());
//            dataSourceEntity.setDataSourceType(dataSource.getDataSourceType());
//            dataSourceEntity.setDataUsage(dataSource.getDataUsage());
//            dataSourceEntity.setStatus(dataSource.getStatus());
//            dataSource.setAction("Update");
//            dataSourceEntity.setExpiry(dataSource.getExpiry());
//            dataSourceEntity.setScoringDataSize(dataSource.getScoringDataSize());
//            dataSourceRepository.save(dataSourceEntity);
//            apiResponse.setEntity(dataSourceEntity);
//            apiResponse.setResponseCode("00");
//            apiResponse.setResponseDescription("Success! DataSource Saved.");
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
//            apiResponse.setResponseDescription("Error! Could not add DataSource");
//            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
//        }
//        LOG.info("---------------------------ENDING 'UPDATE DATA SOURCE'--------------------------------'");
//        return new ResponseEntity<>(apiResponse, responseStatus);
//    }

    @PostMapping("/viewById")
    public ResponseEntity<?> viewById(@RequestBody() Map<String, Object> requestParams) {
        LOG.info("---------------------------STARTING 'VIEW DATA SOURCE' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            String dataSourceId = requestParams.containsKey("dataSourceId") ? requestParams.get("dataSourceId").toString() : null;
            if (dataSourceId == null) {
                apiResponse.setResponseCode("01");
                apiResponse.setResponseDescription("Error! Parameter dataSourceId is required.");
                responseStatus = HttpStatus.BAD_REQUEST;
                LOG.info("PARAMETER {dataSourceId} NOT FOUND IN REQUEST >> RETURNING WITH RESPONSE CODE >> {}", apiResponse.getResponseCode());
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            Optional<DataSourceView> dataSourceSearch = dataSourceViewRepository.findByDataSourceId(new Integer(dataSourceId));
            if (!dataSourceSearch.isPresent()) {
                LOG.info("DATA SOURCE NOT FOUND >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Data Source Not Found!");
                apiResponse.setResponseCode("01");
                responseStatus = HttpStatus.OK;
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            DataSourceView dataSourceEntity = dataSourceSearch.get();
            apiResponse.setEntity(dataSourceEntity);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Data Source Fetched.");
            LOG.info("OK! RETURNING WITH STATUS CODE 00");
        } catch (Exception e) {
            LOG.error("ERROR! COULD NOT FETCH DATA SOURCE >> " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause() != null ? e.getCause().toString() : "");
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not View DATA SOURCE");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
        }
        LOG.info("---------------------------ENDING 'VIEW DATA SOURCE'--------------------------------'");
        return new ResponseEntity<>(apiResponse, responseStatus);
    }
}
