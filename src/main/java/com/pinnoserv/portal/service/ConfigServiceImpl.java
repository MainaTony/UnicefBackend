package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.ConfigById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ConfigGetAll;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.entity.BusinessType;
import com.pinnoserv.portal.entity.Config;
import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.repositories.ConfigRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Slf4j
@Service
public class ConfigServiceImpl implements ConfigService{
    ConfigRepository configRepository;
    public ConfigServiceImpl(ConfigRepository configRepository){
        this.configRepository = configRepository;
    }

    @Override
    public CreateUpdateDeleteResponseDto createConfig(Config config) {
        try {
            log.info("-------------Persisting Config to Database------------");
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
            CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                    .ResponseCode(SUCCESS_RESPONSE)
                    .ResponseMessage(CONFIG_CREATED)
                    .build();
            return createUpdateDeleteResponseDto;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public ConfigById getConfigById(Config config) {
        Long id = config.getId();
        Config myConfig = null;
        try {
            if (configRepository.existsById(id)) {
                myConfig = configRepository.findById(id).get();
                ConfigById configById = ConfigById.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .config(myConfig)
                        .build();
                return configById;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ConfigById configById = ConfigById.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(CONFIG_NOT_EXIST)
                .config(null)
                .build();
        return configById;
    }

    @Override
    public ConfigGetAll getAllConfigs() {
        List<Config> allConfigs= null;
        try{
            allConfigs = configRepository.findAll();
            ConfigGetAll configGetAll = ConfigGetAll.builder()
                    .ResponseCode(SUCCESS_RESPONSE)
                    .configs(allConfigs)
                    .build();
            return configGetAll;

        } catch (Exception e){}
        ConfigGetAll configGetAll = ConfigGetAll.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .configs(null)
                .build();
        return configGetAll;
    }

    @Override
    public CreateUpdateDeleteResponseDto updateById(Config config) {
        Long id = config.getId();
        log.info("Started the update Functionality");
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
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(CONFIG_UPDATED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(CONFIG_NOT_UPDATED)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public CreateUpdateDeleteResponseDto deleteById(Config config) {
        Long id = config.getId();
        try{
            if(configRepository.existsById(id)){
                configRepository.deleteById(id);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(CONFIG_DELETED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(CONFIG_NOT_DELETED)
                .build();
        return createUpdateDeleteResponseDto;
    }
}
