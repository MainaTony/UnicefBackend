package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.view.ProgramView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mwendwakelvin
 */
@Repository
public interface ProgramViewRepository extends JpaRepository<ProgramView, BigInteger> {
    Optional<ProgramView> findByProgramId(BigInteger id);

    List<ProgramView> findAllByOrganisationId(BigInteger organisationId);

    List<ProgramView> findAll();
}