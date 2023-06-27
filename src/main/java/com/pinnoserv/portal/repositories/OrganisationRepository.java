package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

//    boolean findByOrganisationCode(Integer integer);
//    Organisation findByOrganisationCode(Integer integer);
}
