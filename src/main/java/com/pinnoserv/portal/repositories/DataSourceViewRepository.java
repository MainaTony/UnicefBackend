package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.DataSource;
import com.pinnoserv.portal.view.DataSourceView;
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
public interface DataSourceViewRepository extends JpaRepository<DataSource, Integer> {
    Optional<DataSource> findByDataSourceId(Integer id);

    List<DataSource> findAllByOrganisationIdFk(Integer organisationId);

    List<DataSource> findAll();
}