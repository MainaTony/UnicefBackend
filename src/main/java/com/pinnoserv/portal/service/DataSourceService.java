package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.DataSourceById;
import com.pinnoserv.portal.custommodels.apiresponsedto.DataSourceGetAll;
import com.pinnoserv.portal.entity.DataSource;

import java.util.List;

public interface DataSourceService {
//    We need 4 services
//    create delete update read
    ApiResponse findById(DataSource dataSource);
    ApiResponse findAll();
    ApiResponse createDataSource(DataSource dataSource);
    ApiResponse updataDataSource(DataSource dataSource);
    ApiResponse deleteDataSource(DataSource dataSource);

}
