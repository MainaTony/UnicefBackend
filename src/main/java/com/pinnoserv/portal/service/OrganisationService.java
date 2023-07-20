package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.OrganisationById;
import com.pinnoserv.portal.custommodels.apiresponsedto.OrganisationGetAll;
import com.pinnoserv.portal.entity.Organisation;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrganisationService {
     CreateUpdateDeleteResponseDto createOrganisation(Organisation organisation);
     OrganisationById getById(Organisation orgCode);
     OrganisationGetAll getAll();
     CreateUpdateDeleteResponseDto updateById(Organisation organisation);
     CreateUpdateDeleteResponseDto deleteById(Organisation organisation);
}
