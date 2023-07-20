package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.OrganisationById;
import com.pinnoserv.portal.custommodels.apiresponsedto.OrganisationGetAll;
import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.repositories.OrganisationRepository;
import lombok.Builder;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrganisationServiceImpl implements OrganisationService{
    private OrganisationRepository organisationRepository;
    public OrganisationServiceImpl(OrganisationRepository organisationRepository){
        this.organisationRepository = organisationRepository;

    }
    Logger log = LoggerFactory.getLogger(OrganisationServiceImpl.class);
    @Override
    public CreateUpdateDeleteResponseDto createOrganisation(Organisation organisation) {
        log.info("");
        Organisation orgCreated = Organisation.builder()
                .createdBy(2)
                .dateCreated(LocalDateTime.now())
                .intrash("No")
                .status(Boolean.TRUE)
                .organisationName(organisation.getOrganisationName())
                .organisationCode(organisation.getOrganisationCode())
                .businessType(organisation.getBusinessType())
                .organisationAddress(organisation.getOrganisationAddress())
                .organisationPhone(organisation.getOrganisationPhone())
                .organisationEmail(organisation.getOrganisationEmail())
                .build();
        organisationRepository.save(orgCreated);

        try {
            log.info("-------------Persisting Organisation to Database------------");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public OrganisationById getById(Organisation organisation) {
        Long orgCode = organisation.getId();
        log.info("Initiating Get By Id, Value  {} ", orgCode);
//        Steps
//        Check if org exist
//        Fetch details of the organisation

        Organisation org = null;
        try {
            if (organisationRepository.existsById(orgCode)) {
                log.info("Id is Available");
                org = organisationRepository.findById(orgCode).get();
                log.info("Response from the repository {}", org);
            }
            log.info("Id is Not Available");
        } catch (Exception e) {

        }
        return org;
    }

    @Override
    public OrganisationGetAll getAll() {
//        Steps
//        1. Check if org Code exists
//        2. Fetch all the organisations
        List<Organisation> allOrgs = null;
        try{
            allOrgs = organisationRepository.findAll();
            if(allOrgs.isEmpty()){
            log.info("The List is empty");
            }
        }
        catch (Exception e){

        }

        return allOrgs;
    }

    @Override
    public CreateUpdateDeleteResponseDto updateById(Organisation organisation) {
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
                int businessType = organisation.getBusinessType();
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
                if (businessType != 0) {
                    dbOrganisation.setBusinessType(businessType);
                }
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
            }
        } catch (Exception e) {

        }
        return dbOrganisation;
    }

    @Override
    public CreateUpdateDeleteResponseDto deleteById(Organisation organisation) {
//        Check if the organisation exists
//        Delete the organisation

        Long orgCode = organisation.getId();

        try{
            if(organisationRepository.existsById(orgCode)){
                organisationRepository.deleteById(orgCode);
            }
        } catch(Exception e){

        }
    }
}
