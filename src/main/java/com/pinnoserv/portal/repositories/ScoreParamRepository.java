package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.ScoreParam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoreParamRepository extends JpaRepository<ScoreParam, Long> {
    @Override
    boolean existsById(Long aLong);
    Optional<ScoreParam> findById(Long aLong);
}
