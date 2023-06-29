package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessTypeRepository extends JpaRepository<BusinessType, Long> {
    @Override
    boolean existsById(Long aLong);
    Optional<BusinessType> findById(Long aLong);
}
