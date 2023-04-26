//package com.pinnoserv.portal.repositories;
//
//import com.pinnoserv.portal.view.ProductView;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import java.math.BigInteger;
//import java.util.List;
//import java.util.Optional;
//
///**
// *
// * @author mwendwakelvin
// */
//@Repository
//public interface ProductViewRepository extends JpaRepository<ProductView, BigInteger> {
//    Optional<ProductView> findByProductId(BigInteger id);
//
//    List<ProductView> findAllByProgramIdFk(BigInteger programId);
//
//    List<ProductView> findAllByOrganisationIdFk(BigInteger organisationId);
//}