package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.repositories.OrganisationRepository;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrganisationServiceImpl implements OrganisationService{
    private OrganisationRepository organisationRepository;
    public OrganisationServiceImpl(OrganisationRepository organisationRepository){
        this.organisationRepository = organisationRepository;

    }
    Logger log = LoggerFactory.getLogger(OrganisationServiceImpl.class);
    @Override
    public String createOrganisation(Organisation organisation) {
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
    public Organisation getById(Organisation organisation) {
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
}
