package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.Banks;
import com.pinnoserv.portal.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banks")
public class BankController {
    @Autowired
    BankService bankService;
    @PostMapping("/create")
    public ApiResponse createBank(@RequestBody Banks banks){
        return bankService.createBank(banks);
    }
    @PostMapping("/getById")
    public ApiResponse getById(@RequestBody Banks banks){
        return bankService.findBankById(banks);
    }

    @PostMapping("/getAll")
    public ApiResponse getaAll(){
        return bankService.findAllBanks();
    }
    @PostMapping("/deleteById")
    public ApiResponse deleteById(@RequestBody Banks banks){
        return bankService.deleteBank(banks);
    }

}
