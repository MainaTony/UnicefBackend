package com.pinnoserv.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementReport extends JpaRepository<StatementReport, Long> {
}
