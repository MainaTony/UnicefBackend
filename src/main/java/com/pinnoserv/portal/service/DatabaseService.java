package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Users;

import java.util.Optional;

/**
 *
 * @author mwendwakelvin
 */
public interface DatabaseService {

    Users findByUsernameAndStatus(String username, Integer status);

    Optional<Users> findUserById(Integer id);

    Users updateUser(Users usrObj);
}
