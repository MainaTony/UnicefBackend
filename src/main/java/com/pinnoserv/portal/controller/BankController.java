package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.Banks;
import com.pinnoserv.portal.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banks")
public class BankController {
    @Autowired
    BankService bankService;
    @PostMapping("/create")
    public ApiResponse createBank(@RequestBody Banks banks){
        return bankService.createBank(banks);
    }

}
