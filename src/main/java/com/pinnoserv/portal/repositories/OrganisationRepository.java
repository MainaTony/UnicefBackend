package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    
}
