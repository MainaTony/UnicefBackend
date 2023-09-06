package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.BusinessTypeByIdDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.BusinessTypeGetAll;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.entity.BusinessType;

import java.util.List;

public interface BusinessTypeService {
    ApiResponse getBusinessById(BusinessType businessType);
    ApiResponse getAllBusinesses();
    ApiResponse updateById(BusinessType businessType);
    ApiResponse deleteById(BusinessType businessType);

}
