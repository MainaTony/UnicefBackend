package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.ScoreCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreCardRepository extends JpaRepository<ScoreCard, Long> {
}
