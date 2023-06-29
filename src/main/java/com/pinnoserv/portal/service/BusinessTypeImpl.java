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

    @Override
    public BusinessType updateById(BusinessType businessType) {
        Long id = businessType.getId();
        BusinessType business = null;
        try {
            if (businessTypeRepository.existsById(id)) {
                business = businessTypeRepository.findById(id).get();
                String type = businessType.getType();
                String description = businessType.getDescription();
                if (!type.isEmpty() && !type.equalsIgnoreCase(business.getType())) {
                    business.setType(type);
                }
                if (!description.isEmpty() && !type.equalsIgnoreCase(business.getDescription())) {
                    business.setDescription(description);
                }
                businessTypeRepository.save(business);
            }
        } catch (Exception e) {

        }
        return business;
    }

    @Override
    public void deleteById(BusinessType businessType) {
        Long id = businessType.getId();

        try{
            if(businessTypeRepository.existsById(id)){
                businessTypeRepository.deleteById(id);
            }
        } catch (Exception e) {}
    }
}
