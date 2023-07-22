package com.pinnoserv.portal.service;
import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.ConfigById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ConfigGetAll;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.entity.Config;

import java.util.List;

public interface ConfigService {
    ApiResponse createConfig(Config config);
    ApiResponse getConfigById(Config config);
    ApiResponse getAllConfigs();
    ApiResponse updateById(Config config);

    ApiResponse deleteById(Config config);
}
