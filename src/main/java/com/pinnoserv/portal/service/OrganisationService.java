package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Organisation;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrganisationService {
     String createOrganisation(Organisation organisation);
     Organisation getById(Organisation orgCode);
     List<Organisation> getAll();
     Organisation updateById(Organisation organisation);

     void deleteById(Organisation organisation);
}
