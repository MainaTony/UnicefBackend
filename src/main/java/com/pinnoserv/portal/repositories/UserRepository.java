package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Optional;

/**
 *
 * @author mwendwakelvin
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findById(Integer id);

    Users findByUsernameAndStatus(String username, Integer status);

    Users findByUsername(String username);

    Boolean existsByUsername(String username);

    Optional<Users> findByUsernameAndIntrashAndStatus(String username, String intrash, BigInteger status);

    Optional<Users> findByValidationCodeAndIntrashAndStatus(String username, String intrash, BigInteger status);

    @Transactional()
    @Modifying(flushAutomatically = true)
    @Query("update Users user set user.validationCode = ?1 where user.id = ?2")
    void assignToken(String token, BigInteger id);
}