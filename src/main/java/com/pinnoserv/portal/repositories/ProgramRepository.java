package com.pinnoserv.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pinnoserv.portal.entity.Program;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mwendwakelvin
 */
@Repository
public interface ProgramRepository extends JpaRepository<Program, BigInteger> {
    Optional<Program> findByProgramId(BigInteger id);

    List<Program> findAllByOrganisationIdFk(BigInteger organisationId);
}