package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
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
    ApiResponse apiResponse = new ApiResponse();
    @Override
    public ApiResponse createConfig(Config config) {
        try {
            Long id = config.getId();
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
            apiResponse.setResponseCode(SUCCESS_RESPONSE);
            apiResponse.setResponseDescription(CONFIG_CREATED);
            apiResponse.setEntity(null);
            return apiResponse;

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public ApiResponse getConfigById(Config config) {
        Long id = config.getId();
        Config myConfig = null;
        try {
            if (configRepository.existsById(id)) {
                myConfig = configRepository.findById(id).get();
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(CONFIG_FETCHED);
                apiResponse.setEntity(myConfig);
                return apiResponse;
            }
            if (!configRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(CONFIG_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(UNCAUGHT_ERROR);
        apiResponse.setEntity(null);
        return apiResponse;
    }

    @Override
    public ApiResponse getAllConfigs() {
        List<Config> allConfigs= null;
        try{
            allConfigs = configRepository.findAll();
            if(!allConfigs.isEmpty()) {
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(CONFIG_ALL_FETCHED);
                apiResponse.setEntity(allConfigs);
                return apiResponse;
            }
            if (allConfigs.isEmpty()){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(UNCAUGHT_ERROR);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(UNCAUGHT_ERROR);
        apiResponse.setEntity(null);
        return apiResponse;
    }

    @Override
    public ApiResponse updateById(Config config) {
        log.info("Started the update Functionality");
        try {
            Config configDb = null;
            Long id = config.getId();
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
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(CONFIG_UPDATED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!configRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(CONFIG_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(UNCAUGHT_ERROR);
        apiResponse.setEntity(null);
        return apiResponse;
    }

    @Override
    public ApiResponse deleteById(Config config) {
        Long id = config.getId();
        try{
            if(configRepository.existsById(id)){
                configRepository.deleteById(id);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(CONFIG_DELETED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!configRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(CONFIG_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(CONFIG_NOT_DELETED);
        apiResponse.setEntity(null);
        return apiResponse;
    }
}
