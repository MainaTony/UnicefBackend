package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.DataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author tonymaina
 */
@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Integer> {

}