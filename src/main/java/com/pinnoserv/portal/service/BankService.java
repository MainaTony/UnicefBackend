package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.Banks;

public interface BankService {
    ApiResponse createBank(Banks banks);
    ApiResponse findBankById(Banks banks);
    ApiResponse findAllBanks();
    ApiResponse updateBankById(Banks banks);
    ApiResponse deleteBank(Banks banks);

}
