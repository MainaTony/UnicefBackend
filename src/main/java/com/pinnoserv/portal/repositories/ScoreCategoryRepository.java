package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.ScoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mwendwakelvin
 */
@Repository
public interface ScoreCategoryRepository extends JpaRepository<ScoreCategory, BigInteger> {
    Optional<ScoreCategory> findById(BigInteger id);

    List<ScoreCategory> findAllByProductIdFk(BigInteger productId);
}