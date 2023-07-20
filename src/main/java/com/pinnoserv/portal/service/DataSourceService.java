package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.DataSourceById;
import com.pinnoserv.portal.custommodels.apiresponsedto.DataSourceGetAll;
import com.pinnoserv.portal.entity.DataSource;

import java.util.List;

public interface DataSourceService {
//    We need 4 services
//    create delete update read
    DataSourceById findById(DataSource dataSource);
    DataSourceGetAll findAll();
    CreateUpdateDeleteResponseDto createDataSource(DataSource dataSource);
    CreateUpdateDeleteResponseDto updataDataSource(DataSource dataSource);
    CreateUpdateDeleteResponseDto deleteDataSource(DataSource dataSource);

}
