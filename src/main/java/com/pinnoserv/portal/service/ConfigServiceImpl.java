package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.BusinessType;
import com.pinnoserv.portal.entity.Config;
import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.repositories.ConfigRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class ConfigServiceImpl implements ConfigService{
    ConfigRepository configRepository;
    public ConfigServiceImpl(ConfigRepository configRepository){
        this.configRepository = configRepository;
    }

    @Override
    public String createConfig(Config config) {
        log.info("");
        Config configCreated = Config.builder()
                .createdBy(Long.valueOf(2))
                .createdDate(LocalDateTime.now())
                .category(config.getCategory())
                .name(config.getName())
                .value(config.getValue())
                .largeValue(config.getLargeValue())
                .organisationIdFk(config.getOrganisationIdFk())
                .updatedBy(config.getUpdatedBy())
                .updatedDate(LocalDateTime.now())
                .build();
        configRepository.save(configCreated);

        try {
            log.info("-------------Persisting Organisation to Database------------");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return null;
    }
    @Override
    public Config getConfigById(Config config) {
        Long id = config.getId();
        Config myConfig = null;
        try {
            if (configRepository.existsById(id)) {
                myConfig = configRepository.findById(id).get();
            }
        } catch (Exception e) {

        }

        return myConfig;
    }

    @Override
    public List<Config> getAllConfigs() {
        List<Config> allConfigs= null;
        try{
            allConfigs = configRepository.findAll();

        } catch (Exception e){}
        return allConfigs;
    }

    @Override
    public Config updateById(Config config) {
        Long id = config.getId();
        Config configDb = null;
        try {
            if (configRepository.existsById(id)) {
                configDb = configRepository.findById(id).get();
                String category = config.getCategory();
                String largeValue = config.getLargeValue();
                String name =  config.getName();
                String value =  config.getValue();

                if (!category.isEmpty() && !category.equalsIgnoreCase(configDb.getCategory())) {
                    configDb.setCategory(category);
                }
                if (!largeValue.isEmpty() && !largeValue.equalsIgnoreCase(configDb.getLargeValue())) {
                    configDb.setLargeValue(largeValue);
                }
                if (!name.isEmpty() && !name.equalsIgnoreCase(configDb.getName())) {
                    configDb.setName(name);
                }
                if (!value.isEmpty() && !value.equalsIgnoreCase(configDb.getValue())) {
                    configDb.setValue(value);
                }
                configRepository.save(configDb);
            }
        } catch (Exception e) {

        }
        return configDb;
    }

    @Override
    public void deleteById(Config config) {
        Long id = config.getId();

        try{
            if(configRepository.existsById(id)){
                configRepository.deleteById(id);
            }
        } catch (Exception e) {}
    }
}
