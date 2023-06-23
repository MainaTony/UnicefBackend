package com.pinnoserv.portal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organisation")
@CrossOrigin
public class OrganisationController {

    @PostMapping("/create")
    public ResponseEntity<String> createOrganisation(){

        return ResponseEntity.ok("Organisation Works");

    }
}
