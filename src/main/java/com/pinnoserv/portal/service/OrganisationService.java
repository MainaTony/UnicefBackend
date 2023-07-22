package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.OrganisationById;
import com.pinnoserv.portal.custommodels.apiresponsedto.OrganisationGetAll;
import com.pinnoserv.portal.entity.Organisation;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrganisationService {
     ApiResponse createOrganisation(Organisation organisation);
     ApiResponse getById(Organisation organisation);
     ApiResponse getAll();
     ApiResponse updateById(Organisation organisation);
     ApiResponse deleteById(Organisation organisation);
}
