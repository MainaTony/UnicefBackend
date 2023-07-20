package com.pinnoserv.portal.service;
import com.pinnoserv.portal.custommodels.apiresponsedto.ConfigById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ConfigGetAll;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.entity.Config;

import java.util.List;

public interface ConfigService {
    CreateUpdateDeleteResponseDto createConfig(Config config);
    ConfigById getConfigById(Config config);
    ConfigGetAll getAllConfigs();
    CreateUpdateDeleteResponseDto updateById(Config config);

    CreateUpdateDeleteResponseDto deleteById(Config config);
}
