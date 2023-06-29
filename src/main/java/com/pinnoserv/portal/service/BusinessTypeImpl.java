package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.BusinessType;
import com.pinnoserv.portal.repositories.BusinessTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusinessTypeImpl implements BusinessTypeService{
    @Autowired
    BusinessTypeRepository businessTypeRepository;

    @Override
    public BusinessType getBusinessById(BusinessType businessType) {
        Long id = businessType.getId();
        BusinessType myBusiness = null;
        try {
            if (businessTypeRepository.existsById(id)) {
                myBusiness = businessTypeRepository.findById(id).get();
            }
        } catch (Exception e) {

        }

        return myBusiness;
    }

    @Override
    public List<BusinessType> getAllBusinesses() {
        List<BusinessType> allBusiness= null;
        try{
            allBusiness = businessTypeRepository.findAll();

        } catch (Exception e){}
        return allBusiness;
    }
}
