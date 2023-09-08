package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.responseutils.ResponseUtil;
import com.pinnoserv.portal.entity.Banks;
import com.pinnoserv.portal.repositories.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BankServiceImpl implements BankService{
    @Autowired
    BankRepository bankRepository;
    ApiResponse apiResponse = new ApiResponse();
    @Override
    public ApiResponse createBank(Banks banks) {
        log.info("Started the create request");
        Integer bankCode = banks.getBankCode();
        log.info("My Bank code is: {}", bankCode);

        Banks saveBank = Banks.builder()
                .bankName(banks.getBankName())
                .bankCode(banks.getBankCode())
                .build();
        bankRepository.save(saveBank);
        apiResponse.setEntity(null);
        apiResponse.setResponseCode("00");
        apiResponse.setResponseDescription(ResponseUtil.BANK_CREATED);

        return apiResponse;
    }

    @Override
    public ApiResponse findBankById(Banks banks) {
        Long id = banks.getId(); 
        log.info("My ID is: {}", id);
        try{
            Banks dbBank = bankRepository.findById(id).get();
            if(dbBank != null){
                apiResponse.setEntity(dbBank);
                apiResponse.setResponseCode("00");
                apiResponse.setResponseDescription(ResponseUtil.BANK_FETCHED);
                return apiResponse;
            }
        } catch (Exception e){
            apiResponse.setEntity(null);
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription(ResponseUtil.BANK_NOT_EXIST);
            return apiResponse;
        }

        apiResponse.setEntity(null);
        apiResponse.setResponseCode("01");
        apiResponse.setResponseDescription("Bank Code is empty");
        return apiResponse;
    }

    @Override
    public ApiResponse findAllBanks() {
        try{
        List<Banks> allBanks = bankRepository.findAll();
        if(allBanks != null){
            apiResponse.setEntity(allBanks);
            apiResponse.setResponseCode(ResponseUtil.SUCCESS_RESPONSE);
            apiResponse.setResponseDescription(ResponseUtil.BANK_ALL_FETCHED);
            return apiResponse;
        }
        } catch (Exception e){
            apiResponse.setEntity(null);
            apiResponse.setResponseCode(ResponseUtil.UNSUCCESS_RESPONSE);
            apiResponse.setResponseDescription(ResponseUtil.BANK_NOT_EXIST);
            return apiResponse;
        }
        apiResponse.setEntity(null);
        apiResponse.setResponseDescription(ResponseUtil.UNCAUGHT_ERROR);
        apiResponse.setResponseCode(ResponseUtil.UNSUCCESS_RESPONSE);
        return apiResponse;
    }

    @Override
    public ApiResponse updateBankById(Banks banks) {
        return null;
    }

    @Override
    public ApiResponse deleteBank(Banks banks) {
        try{
            Long id = banks.getId();
            Banks dbBank = bankRepository.findById(id).get();
            if (dbBank != null){
                bankRepository.deleteById(id);
                apiResponse.setResponseCode(ResponseUtil.SUCCESS_RESPONSE);
                apiResponse.setEntity(null);
                apiResponse.setResponseDescription(ResponseUtil.BANK_DELETED_SUCCESSFULLY);
                return apiResponse;
            }
        } catch (Exception e){
            apiResponse.setResponseCode(ResponseUtil.UNSUCCESS_RESPONSE);
            apiResponse.setEntity(null);
            apiResponse.setResponseDescription(ResponseUtil.BANK_NOT_DELETED);
            return apiResponse;
        }
        apiResponse.setResponseCode(ResponseUtil.UNSUCCESS_RESPONSE);
        apiResponse.setEntity(null);
        apiResponse.setResponseDescription(ResponseUtil.UNCAUGHT_ERROR);
        return apiResponse;
    }
}
