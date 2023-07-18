package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.DataSource;

import java.util.List;

public interface DataSourceService {
//    We need 4 services
//    create delete update read
    DataSource findById(DataSource dataSource);
    List<DataSource> findAll();
    void createDataSource(DataSource dataSource);
    DataSource updataDataSource(DataSource dataSource);
    void deleteDataSource(int id);

}
