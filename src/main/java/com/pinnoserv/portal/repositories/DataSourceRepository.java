package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.DataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author tonymaina
 */
@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Long> {
    DataSource findByDatasourceCode(Integer dataSourceCode);
//    @Override
//    List<DataSource> findAllById(Iterable<Long> iterable);
}