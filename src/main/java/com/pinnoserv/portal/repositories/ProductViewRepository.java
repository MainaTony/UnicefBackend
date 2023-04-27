package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.Product;
//import com.pinnoserv.portal.view.ProductView;
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
public interface ProductViewRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductId(Integer id);

//    List<Product> findAllByProgramIdFk(Integer programId);

    List<Product> findAllByOrganisationIdFk(Integer organisationId);
}