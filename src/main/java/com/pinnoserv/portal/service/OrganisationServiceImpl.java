package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.OrganisationById;
import com.pinnoserv.portal.custommodels.apiresponsedto.OrganisationGetAll;
import com.pinnoserv.portal.entity.BusinessType;
import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.repositories.BusinessTypeRepository;
import com.pinnoserv.portal.repositories.OrganisationRepository;
import lombok.Builder;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Service
public class OrganisationServiceImpl implements OrganisationService{
    @Autowired
    private OrganisationRepository organisationRepository;
    @Autowired
    private BusinessTypeRepository businessTypeRepository;
    public OrganisationServiceImpl(OrganisationRepository organisationRepository){
        this.organisationRepository = organisationRepository;

    }
    Logger log = LoggerFactory.getLogger(OrganisationServiceImpl.class);
    ApiResponse apiResponse = new ApiResponse();
    @Override
    public ApiResponse createOrganisation(Organisation organisation) {

        try {
            log.info("-------------Persisting Organisation to Database------------");
            Long businessId = organisation.getBusinessTypeId();
            log.info("Business id from postman {}, ", businessId);
            BusinessType myBusinessObject = businessTypeRepository.findById(businessId).get();

            log.info("Object from db {}, ", myBusinessObject);

                Organisation orgCreated = Organisation.builder()
                        .createdBy(2)
                        .dateCreated(LocalDateTime.now())
                        .intrash("No")
                        .status(Boolean.TRUE)
//                        .organisationName(organisation.getOrganisationName())
                        .organisationCode(organisation.getOrganisationCode())
//                        .businessType(myBusinessObject)
                        .organisationAddress(organisation.getOrganisationAddress())
                        .organisationPhone(organisation.getOrganisationPhone())
                        .organisationEmail(organisation.getOrganisationEmail())
                        .businessType(organisation.getBusinessType())
                        .build();
                organisationRepository.save(orgCreated);

//                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
//                        .ResponseCode(SUCCESS_RESPONSE)
//                        .ResponseMessage(ORGANISATION_CREATED)
//                        .build();
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(ORGANISATION_CREATED);
                apiResponse.setEntity(null);
                return apiResponse;
//            if(organisationRepository.existsById(id)){
////                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
////                        .ResponseCode(UNSUCCESS_RESPONSE)
////                        .ResponseMessage(ORGANISATION_EXISTS)
////                        .build();
//                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
//                apiResponse.setResponseDescription(ORGANISATION_EXISTS);
//                apiResponse.setEntity(null);
//                return apiResponse;
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse getById(Organisation organisation) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            Long orgCode = organisation.getId();
            log.info("Initiating Get By Id, Value  {} ", orgCode);
            Organisation org = null;
            if (organisationRepository.existsById(orgCode)) {
                log.info("Id is Available");
                org = organisationRepository.findById(orgCode).get();
                log.info("Response from the repository {}", org);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(ORGANISATION_FETCHED);
                apiResponse.setEntity(org);
                return apiResponse;
            }
            if (!organisationRepository.existsById(orgCode)){
                log.info("Id is Not Available");
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(ORGANISATION_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }

        } catch (Exception e) {
            new RuntimeException();
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(UNCAUGHT_ERROR);
        apiResponse.setEntity(null);
        return apiResponse;
    }

    @Override
    public ApiResponse getAll() {
        List<Organisation> allOrgs = null;
        try {
            allOrgs = organisationRepository.findAll();
            if (!allOrgs.isEmpty()) {
                log.info("Get All Success");
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(ORGANISATION_ALL_FETCHED);
                apiResponse.setEntity(allOrgs);
                return apiResponse;
            }
            if (allOrgs.isEmpty()) {
                log.info("Get All Not Successful");
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(ORGANISATION_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(UNCAUGHT_ERROR);
        apiResponse.setEntity(null);
        return apiResponse;
    }

    @Override
    public ApiResponse updateById(Organisation organisation) {
//        Check if the Organisation exists
//        Update the only values that have values in them and leave out the empty ones

        Organisation dbOrganisation = null;
        try {

            Long orgCode = organisation.getId();
            log.info("Update Id : {}", orgCode);

            if (organisationRepository.existsById(orgCode)) {
//                Organisation updateOrganisation = Organisation.builder()
//                        .build();
                dbOrganisation = organisationRepository.findById(orgCode).get();

                String orgName = organisation.getOrganisationName();
                String organisationCode = organisation.getOrganisationCode();
                BusinessType businessType = organisation.getBusinessType();
                String organisationAddress = organisation.getOrganisationAddress();
                String organisationPhone = organisation.getOrganisationPhone();
                String organisationEmail = organisation.getOrganisationEmail();

                log.info("My Update Data : {}", orgName);

                if (!orgName.isEmpty() && !orgName.equalsIgnoreCase(dbOrganisation.getOrganisationName())) {
                    dbOrganisation.setOrganisationName(orgName);
                }
                if (!organisationCode.isEmpty() && !organisationCode.equalsIgnoreCase(dbOrganisation.getOrganisationCode())){
                    dbOrganisation.setOrganisationCode(organisationCode);
                }
//                if (businessType != 0) {
//                    dbOrganisation.setBusinessType(businessType);
//                }
                if (!organisationAddress.isEmpty() && !organisationAddress.equalsIgnoreCase(dbOrganisation.getOrganisationAddress())) {
                    dbOrganisation.setOrganisationAddress(organisationAddress);
                }
                if (!organisationPhone.isEmpty() && !organisationPhone.equalsIgnoreCase(dbOrganisation.getOrganisationPhone())) {
                    dbOrganisation.setOrganisationPhone(organisationPhone);
                }
                if (!organisationEmail.isEmpty() && !organisationEmail.equalsIgnoreCase(dbOrganisation.getOrganisationEmail())) {
                    dbOrganisation.setOrganisationEmail(organisationEmail);
                }
                organisationRepository.save(dbOrganisation);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(ORGANISATION_UPDATED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(ORGANISATION_NOT_UPDATED);
        apiResponse.setEntity(null);
        return apiResponse;
    }

    @Override
    public ApiResponse deleteById(Organisation organisation) {
//        Check if the organisation exists
//        Delete the organisation

        Long orgCode = organisation.getId();

        try{
            if(organisationRepository.existsById(orgCode)){
                organisationRepository.deleteById(orgCode);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(ORGANISATION_DELETED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!organisationRepository.existsById(orgCode)){
                organisationRepository.deleteById(orgCode);
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(ORGANISATION_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch(Exception e){
            throw new RuntimeException(e);
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(UNCAUGHT_ERROR);
        apiResponse.setEntity(null);
        return apiResponse;
    }
}
