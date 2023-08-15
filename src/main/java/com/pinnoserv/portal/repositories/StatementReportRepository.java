package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.StatementReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementReportRepository extends JpaRepository<StatementReport, Long> {
}
