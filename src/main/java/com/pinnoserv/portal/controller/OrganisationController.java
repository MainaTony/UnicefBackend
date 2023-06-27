package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.OrganisationService;
import javassist.bytecode.stackmap.BasicBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

        try{
            organisationService.createOrganisation(organisation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(organisation);

    }

    @PostMapping("/getById")
    public ResponseEntity<Organisation> getOrganisationById(@RequestBody Organisation organisation) {
        Organisation org = null;
        try {
            org = organisationService.getById(organisation);
        } catch (Exception e) {

        }
        return ResponseEntity.ok(org);
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<Organisation>> getAll() {

        List<Organisation> allOrgs = null;
        try {
            allOrgs = organisationService.getAll();
        } catch (Exception e) {

        }
        return ResponseEntity.ok(allOrgs);
    }
    @PostMapping("/updateById")
    public ResponseEntity<Organisation> updateById(@RequestBody Organisation organisation) {

        Organisation myOrg = null;
        try {
            myOrg = organisationService.updateById(organisation);
        } catch (Exception e) {

        }

        return ResponseEntity.ok(myOrg);
    }


}
