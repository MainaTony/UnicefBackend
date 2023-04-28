package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.ScoreCategoryMaster;
//import com.pinnoserv.portal.view.ScoreCategoryMasterView;
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
public interface ScoreCategoryMasterViewRepository extends JpaRepository<ScoreCategoryMaster, Integer> {
    Optional<ScoreCategoryMaster> findById(Integer id);

    List<ScoreCategoryMaster> findAllByProductIdFk(Integer productId);
}