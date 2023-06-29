package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.BusinessType;

import java.util.List;

public interface BusinessTypeService {
    BusinessType getBusinessById(BusinessType businessType);
    List<BusinessType> getAllBusinesses();
    BusinessType updateById(BusinessType businessType);

    void deleteById(BusinessType businessType);

}
