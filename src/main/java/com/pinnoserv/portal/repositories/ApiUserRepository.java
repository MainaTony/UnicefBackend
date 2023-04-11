package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.ApiUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApiUserRepository extends JpaRepository<ApiUsers, Integer> {

    List<ApiUsers> findAll();

    Optional<ApiUsers> findById(Integer id);

//    ApiUsers findByUsername(String username);

    ApiUsers findByUsername(String username);

    Boolean existsByUsername(String username);

    ApiUsers findByUsernameAndAccessChannelIdIn(String username, List<Integer> channelList);
}