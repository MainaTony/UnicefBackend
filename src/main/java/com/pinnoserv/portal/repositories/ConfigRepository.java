package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.BusinessType;
import com.pinnoserv.portal.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, Long> {
    @Override
    boolean existsById(Long aLong);
    Optional<Config> findById(Long aLong);
}
