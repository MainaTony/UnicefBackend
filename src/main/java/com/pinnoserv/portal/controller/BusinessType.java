package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ApiUsers;
import com.pinnoserv.portal.entity.DataSource;
//import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.repositories.BusinessTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pinnoserv.portal.entity.BusinessTypeModel ;
import com.pinnoserv.portal.utils.* ;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/businesstype")
public class BusinessType {
    @Autowired
    SharedFunctions sharedFunctions;
    @Autowired
    BusinessTypeRepository businessTypeRepository;
    @Autowired
    Environment environment;
    private static final Logger LOG = LoggerFactory.getLogger(BusinessType.class);

    @PostMapping("/create")
    public ResponseEntity<?> addNewBusinessType(@RequestHeader("Authorization") String Authorization, @RequestBody() BusinessTypeModel businessTypeModel) {
        LOG.info("---------------------------STARTING 'ADD NEW BUSINESS TYPE' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            LOG.info("---------------------------ACCESSING THE APIUSER TABLE--------------------------------");
            ApiUsers user = sharedFunctions.verifyToken(Authorization);

            LOG.info("---------------------------AFTER ACCESSING THE USER TABLE--------------------------------");

            if(user != null) {
                businessTypeModel.setDateCreated(new Date(System.currentTimeMillis()));
                businessTypeModel.setCreatedByFk(user.getId());
//                businessTypeModel.setOrganisationsById((Collection<Organisation>) user.getOrganisationIdFk());
                businessTypeModel.setIntrash("NO");
            }
            BusinessTypeModel savedBusinessType = businessTypeRepository.saveAndFlush(businessTypeModel);

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
            apiResponse.setResponseDescription("Error! Could not add Business Type");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING 'ADD NEW DATA SOURCE'--------------------------------'");
        }
        return new ResponseEntity<>(apiResponse, responseStatus);
    }

    @PostMapping("/success")
    public String success(){
        return "Business Type Controller works";
    }

}
