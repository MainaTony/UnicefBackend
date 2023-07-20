package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.BusinessTypeByIdDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.BusinessTypeGetAll;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.entity.BusinessType;

import java.util.List;

public interface BusinessTypeService {
    BusinessTypeByIdDto getBusinessById(BusinessType businessType);
    BusinessTypeGetAll getAllBusinesses();
    CreateUpdateDeleteResponseDto updateById(BusinessType businessType);

    CreateUpdateDeleteResponseDto deleteById(BusinessType businessType);

}
