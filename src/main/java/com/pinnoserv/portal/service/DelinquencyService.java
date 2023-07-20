package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.DelinquencyById;
import com.pinnoserv.portal.custommodels.apiresponsedto.DelinquencyGetAll;
import com.pinnoserv.portal.entity.DelinquencyModel;

import java.util.List;

public interface DelinquencyService {
    CreateUpdateDeleteResponseDto createDelinquency(DelinquencyModel delinquencyModel);
    DelinquencyById findById(DelinquencyModel delinquencyModel);
    DelinquencyGetAll findAll();
    CreateUpdateDeleteResponseDto updateById(DelinquencyModel delinquencyModel);
    CreateUpdateDeleteResponseDto deleteById(DelinquencyModel delinquencyModel);

}
