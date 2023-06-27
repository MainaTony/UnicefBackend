package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

    @Override
    boolean existsById(Long aLong);
    Optional<Organisation> findById(Long aLong);
    @Override
    List<Organisation> findAll();
}
