package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.DataSource;
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
public interface DataSourceRepository extends JpaRepository<DataSource, BigInteger> {
    Optional<DataSource> findByDataSourceId(BigInteger id);

    List<DataSource> findAllByOrganisationIdFk(BigInteger organisationId);
}