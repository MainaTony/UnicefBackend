package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.*;
import com.pinnoserv.portal.entity.ApiUsers;
//import com.pinnoserv.portal.entity.DataSource;
//import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.entity.BusinessType;
import com.pinnoserv.portal.repositories.BusinessTypeRepository;
import com.pinnoserv.portal.service.BusinessTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pinnoserv.portal.utils.* ;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@RestController
@RequestMapping("/businesstype")
@Slf4j
public class BusinessTypeController {
    @Autowired
    SharedFunctions sharedFunctions;
    @Autowired
    BusinessTypeRepository businessTypeRepository;
    @Autowired
    Environment environment;
    @Autowired
    BusinessTypeService businessTypeService;

    private static final Logger LOG = LoggerFactory.getLogger(BusinessTypeController.class);

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> addNewBusinessType(@RequestHeader("Authorization") String Authorization, @RequestBody() com.pinnoserv.portal.entity.BusinessType businessType) {
        LOG.info("---------------------------STARTING 'ADD NEW BUSINESS TYPE' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;

        try {
            LOG.info("---------------------------ACCESSING THE APIUSER TABLE--------------------------------");
            ApiUsers user = sharedFunctions.verifyToken(Authorization);

            LOG.info("---------------------------AFTER ACCESSING THE USER TABLE--------------------------------");

            if(user != null) {
                businessType.setDateCreated(LocalDateTime.now());
                businessType.setCreatedBy(user.getId());
//                businessTypeModel.setOrganisationsById((Collection<Organisation>) user.getOrganisationIdFk());
                businessType.setInTrash("NO");
            }
            com.pinnoserv.portal.entity.BusinessType savedBusinessType = businessTypeRepository.saveAndFlush(businessType);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription(BUSINESS_TYPE_CREATED);
            apiResponse.setEntity(null);
            return new ResponseEntity<>(apiResponse, responseStatus);

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
            CreateResponseDto businessTypeErrorResponse = CreateResponseDto.builder()
                    .ResponseCode(UNSUCCESS_RESPONSE)
                    .ResponseMessage(BUSINESS_TYPE_NOT_CREATED)
                    .build();
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING 'ADD NEW DATA SOURCE'--------------------------------'");
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(BUSINESS_TYPE_NOT_CREATED);
        apiResponse.setEntity(null);
        return new ResponseEntity<>(apiResponse, responseStatus);
    }

    @PostMapping("/success")
    public String success(){
        return "Business Type Controller works";
    }

    @PostMapping("/getById")
    public ApiResponse getBusinessTypeById(@RequestBody BusinessType businessType){
       return businessTypeService.getBusinessById(businessType);
            }

    @PostMapping("/getAll")
    public ApiResponse getAllBusinessTypes(){
           return businessTypeService.getAllBusinesses();
    }

    @PostMapping("/updateById")
    public ApiResponse geUpdateById(@RequestBody BusinessType businessType) {
            return businessTypeService.updateById(businessType);
    }

    @PostMapping("/deleteById")
    public ApiResponse deleteBusinessType(@RequestBody BusinessType businessType){
           return businessTypeService.deleteById(businessType);
    }
}
