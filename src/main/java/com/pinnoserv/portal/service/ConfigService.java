package com.pinnoserv.portal.service;
import com.pinnoserv.portal.entity.Config;

import java.util.List;

public interface ConfigService {
    String createConfig(Config config);
    Config getConfigById(Config config);
    List<Config> getAllConfigs();
    Config updateById(Config config);

    void deleteById(Config config);
}
