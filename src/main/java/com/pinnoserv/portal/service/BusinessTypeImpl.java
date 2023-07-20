package com.pinnoserv.portal.service;

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

    @Override
    public BusinessTypeByIdDto getBusinessById(BusinessType businessType) {

        BusinessType myBusiness = null;
        try {
            Long id = businessType.getId();
            if (businessTypeRepository.existsById(id)) {
                myBusiness = businessTypeRepository.findById(id).get();
                BusinessTypeByIdDto businessTypeByIdDto = BusinessTypeByIdDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .businessType(myBusiness)
                        .build();
                return businessTypeByIdDto;
            }
            if(!businessTypeRepository.existsById(id)){
                BusinessTypeByIdDto businessTypeByIdDto = BusinessTypeByIdDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(BUSINESS_TYPE_NOT_EXIST)
                        .businessType(null)
                        .build();
                return businessTypeByIdDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BusinessTypeByIdDto businessTypeByIdDto = BusinessTypeByIdDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage("Not Found")
                .businessType(null)
                .build();
        return businessTypeByIdDto;
    }

    @Override
    public BusinessTypeGetAll getAllBusinesses() {
        List<BusinessType> allBusiness= null;
        try{
            allBusiness = businessTypeRepository.findAll();
            if(!allBusiness.isEmpty()){
                BusinessTypeGetAll businessTypeGetAll = BusinessTypeGetAll.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .businessType(allBusiness)
                        .build();
                return businessTypeGetAll;
            }
            if(allBusiness.isEmpty()){
                BusinessTypeGetAll businessTypeGetAll = BusinessTypeGetAll.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .businessType(null)
                        .build();
                return businessTypeGetAll;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        BusinessTypeGetAll businessTypeGetAll = BusinessTypeGetAll.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .businessType(null)
                .build();
        return businessTypeGetAll;
    }

    @Override
    public CreateUpdateDeleteResponseDto updateById(BusinessType businessType) {
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
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(BUSINESS_TYPE_CREATED)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!businessTypeRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(BUSINESS_TYPE_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(BUSINESS_TYPE_NOT_CREATED)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public CreateUpdateDeleteResponseDto deleteById(BusinessType businessType) {
        Long id = businessType.getId();
        try{
            if(businessTypeRepository.existsById(id)){
                businessTypeRepository.deleteById(id);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(BUSINESS_TYPE_DELETED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!businessTypeRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(BUSINESS_TYPE_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(BUSINESS_TYPE_NOT_DELETED)
                .build();
        return createUpdateDeleteResponseDto;
    }
}
