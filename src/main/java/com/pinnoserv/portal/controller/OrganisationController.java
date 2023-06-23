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

        Organisation newOrganisation = new Organisation();
        newOrganisation.setCreatedBy(1);
        newOrganisation.setDateCreated(LocalDateTime.now());
        newOrganisation.setIntrash("No");
        newOrganisation.setStatus(Boolean.TRUE);

        newOrganisation.setBusinessType(organisation.getBusinessType());
        newOrganisation.setOrganisationEmail(organisation.getOrganisationEmail());
        newOrganisation.setOrganisationPhone(organisation.getOrganisationPhone());
        newOrganisation.setOrganisationName(organisation.getOrganisationName());
        newOrganisation.setOrganisationCode(organisation.getOrganisationCode());
        newOrganisation.setOrganisationAddress(organisation.getOrganisationAddress());

        log.info("My Organisation Details {}", newOrganisation);


        return ResponseEntity.ok(newOrganisation);

    }
}
