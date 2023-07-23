package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.DelinquencyById;
import com.pinnoserv.portal.custommodels.apiresponsedto.DelinquencyGetAll;
import com.pinnoserv.portal.entity.DelinquencyModel;

import java.util.List;

public interface DelinquencyService {
    ApiResponse createDelinquency(DelinquencyModel delinquencyModel);
    ApiResponse findById(DelinquencyModel delinquencyModel);
    ApiResponse findAll();
    ApiResponse updateById(DelinquencyModel delinquencyModel);
    ApiResponse deleteById(DelinquencyModel delinquencyModel);

}
