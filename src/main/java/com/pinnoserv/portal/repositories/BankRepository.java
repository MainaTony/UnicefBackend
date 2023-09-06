package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.Banks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Banks, Integer> {
}
