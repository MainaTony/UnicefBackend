package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.view.DeliquencyModelView;
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
public interface DelinquencyViewRepository extends JpaRepository<DeliquencyModelView, BigInteger> {
    Optional<DeliquencyModelView> findByDeliquencyModelId(BigInteger id);


    List<DeliquencyModelView> findAllByProductIdFk(BigInteger productId);
}