package com.pinnoserv.portal.service;

import java.util.*;
import javax.transaction.Transactional;

import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.repositories.CrudService;
import com.pinnoserv.portal.repositories.UserRepository;
import  org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mwendwakelvin
 */
@Service("databaseServiceImp")
@Transactional
public class DatabaseServiceImplementation implements DatabaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseServiceImplementation.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    CrudService crudService;

    @Override
    public Users findByUsernameAndStatus(String username, Integer status){
        return userRepository.findByUsernameAndStatus(username, status);
    }

    @Override
    public Optional<Users> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Users updateUser(Users userObj) {
        return userRepository.save(userObj);
    }
}
