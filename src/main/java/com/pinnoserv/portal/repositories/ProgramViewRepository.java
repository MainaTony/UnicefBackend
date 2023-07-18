package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.Program;
//import com.pinnoserv.portal.view.ProgramView;
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
public interface ProgramViewRepository extends JpaRepository<Program, Integer> {
    Optional<Program> findByProgramId(Integer id);

    List<Program> findAllByOrganisationIdFk(Integer organisationId);

    List<Program> findAll();
}