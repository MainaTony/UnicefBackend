package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.RestTemplateServices;
import com.pinnoserv.portal.utils.SharedFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Created by mwendwakelvin on 20/09/2018.
 */
@RestController
@RequestMapping("/api")
public class ApiRequestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiRequestController.class);

    @Autowired
    private Environment environment;

    @Autowired
    DatabaseService dbService;

    @Autowired
    RestTemplateServices restTemplateService;

    @Autowired
    SharedFunctions sharedFunctions;
}