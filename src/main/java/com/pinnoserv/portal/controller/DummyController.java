package com.pinnoserv.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DummyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DummyController.class);
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> dummy()
    {
        LOGGER.info("PORTAL SERVICE IS UP");
        return ResponseEntity.status(200).body("my dummy controller works");
    }
}