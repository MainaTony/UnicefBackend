package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.pythonmodels.PaidOut;
import com.pinnoserv.portal.custommodels.pythonmodels.PythonResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class DummyController {
    @Autowired
    private final WebClient webClient;
    public DummyController(WebClient webClient){
        this.webClient = webClient;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(DummyController.class);
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> dummy()
    {
        LOGGER.info("PORTAL SERVICE IS UP");
        return ResponseEntity.status(200).body("my dummy controller works");
    }
}