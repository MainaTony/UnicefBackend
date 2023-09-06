package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.Banks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Banks, Long> {
    Optional<Banks> findByBankCode(Integer integer);
}
