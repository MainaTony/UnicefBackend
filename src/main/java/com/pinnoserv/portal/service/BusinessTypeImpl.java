package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.BusinessTypeByIdDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.BusinessTypeGetAll;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.entity.BusinessType;
import com.pinnoserv.portal.repositories.BusinessTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Service
@Slf4j
public class BusinessTypeImpl implements BusinessTypeService{
    @Autowired
    BusinessTypeRepository businessTypeRepository;

    ApiResponse apiResponse = new ApiResponse();
    @Override
    public ApiResponse getBusinessById(BusinessType businessType) {

        BusinessType myBusiness = null;
        try {
            Long id = businessType.getId();
            if (businessTypeRepository.existsById(id)) {
                myBusiness = businessTypeRepository.findById(id).get();
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(BUSINESS_TYPE_FETCHED);
                apiResponse.setEntity(myBusiness);
                return apiResponse;
            }
            if(!businessTypeRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(BUSINESS_TYPE_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(UNCAUGHT_ERROR);
                apiResponse.setEntity(null);
                return apiResponse;
    }

    @Override
    public ApiResponse getAllBusinesses() {
        List<BusinessType> allBusiness = null;

            allBusiness = businessTypeRepository.findAll();
            if(!allBusiness.isEmpty()){
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(BUSINESS_TYPE_ALL_FETCHED);
                apiResponse.setEntity(allBusiness);
                return apiResponse;

            }
            if(allBusiness.isEmpty()){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(BUSINESS_TYPE_NOT_EXIST);
                apiResponse.setEntity(allBusiness);
                return apiResponse;
            }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(UNCAUGHT_ERROR);
        apiResponse.setEntity(null);
        return apiResponse;
    }

    @Override
    public ApiResponse updateById(BusinessType businessType) {
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
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(BUSINESS_TYPE_UPDATED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!businessTypeRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(BUSINESS_TYPE_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(UNCAUGHT_ERROR);
                apiResponse.setEntity(null);
                return apiResponse;
    }

    @Override
    public ApiResponse deleteById(BusinessType businessType) {
        Long id = businessType.getId();
        try{
            if(businessTypeRepository.existsById(id)){
                businessTypeRepository.deleteById(id);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(BUSINESS_TYPE_DELETED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!businessTypeRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(BUSINESS_TYPE_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(UNCAUGHT_ERROR);
                apiResponse.setEntity(null);
                return apiResponse;
    }
}
