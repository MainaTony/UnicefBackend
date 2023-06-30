package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.Config;
import com.pinnoserv.portal.entity.ScoreParamMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoreParamMasterRepository extends JpaRepository<ScoreParamMaster, Long> {
    @Override
    boolean existsById(Long aLong);
    Optional<ScoreParamMaster> findById(Long aLong);
}
