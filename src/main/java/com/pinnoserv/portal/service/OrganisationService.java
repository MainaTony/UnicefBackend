package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Organisation;
import org.springframework.stereotype.Service;


public interface OrganisationService {
     String createOrganisation(Organisation organisation);
     int getById(int orgCode);
}
