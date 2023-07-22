package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.OrganisationById;
import com.pinnoserv.portal.custommodels.apiresponsedto.OrganisationGetAll;
import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.OrganisationService;
import javassist.bytecode.stackmap.BasicBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.ORGANISATION_CREATED;
import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.SUCCESS_RESPONSE;

@RestController
@RequestMapping("/organisation")
public class OrganisationController {
    private static final Logger log = LoggerFactory.getLogger(OrganisationController.class);
    private OrganisationService organisationService;
    public OrganisationController(OrganisationService organisationService){
        this.organisationService = organisationService;
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create")
    public ApiResponse createOrganisation(@RequestBody() Organisation organisation){
        log.info("----------------------Initiated Creating of Organisation------------------------------------");
        return organisationService.createOrganisation(organisation);
    }

    @PostMapping("/getById")
    public ApiResponse getOrganisationById(@RequestBody Organisation organisation) {
        return organisationService.getById(organisation);
    }

    @PostMapping("/getAll")
    public ApiResponse getAll() {
        return organisationService.getAll();
    }

    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody Organisation organisation) {
        return organisationService.updateById(organisation);
    }

    @DeleteMapping("/deleteById")
    public ApiResponse deleteOrganisation(@RequestBody Organisation organisation){
    return organisationService.deleteById(organisation);
    }


}
