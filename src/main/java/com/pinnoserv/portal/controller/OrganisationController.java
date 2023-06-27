package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.OrganisationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/organisation")
@CrossOrigin
public class OrganisationController {
    private static final Logger log = LoggerFactory.getLogger(OrganisationController.class);
    private OrganisationService organisationService;
    public OrganisationController(OrganisationService organisationService){
        this.organisationService = organisationService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrganisation(@RequestHeader("Authorization") String Authorization, @RequestBody() Organisation organisation){
        log.info("----------------------Initiated Creating of Organisation------------------------------------");
        organisationService.createOrganisation(organisation);
        try{

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(organisation);

    }

    @PostMapping("/getById")
    public ResponseEntity<?> getOrganisationById(@RequestBody Organisation organisation){

        int orgCode = Integer.parseInt(organisation.getOrganisationCode());
        organisationService.getById(orgCode);

        return ResponseEntity.ok(organisation);
    }

}
