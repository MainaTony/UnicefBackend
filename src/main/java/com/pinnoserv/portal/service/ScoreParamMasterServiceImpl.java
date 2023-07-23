package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamMasterById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamMasterGetAll;
import com.pinnoserv.portal.entity.Config;
import com.pinnoserv.portal.entity.ScoreParamMaster;
import com.pinnoserv.portal.repositories.ScoreParamMasterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Service
@Slf4j
public class ScoreParamMasterServiceImpl implements ScoreParamMasterService{
    ApiResponse apiResponse = new ApiResponse();
    ScoreParamMasterRepository scoreParamMasterRepository;
    public ScoreParamMasterServiceImpl(ScoreParamMasterRepository scoreParamMasterRepository){
        this.scoreParamMasterRepository = scoreParamMasterRepository;
    }
    @Override
    public ApiResponse createScoreParamMaster(ScoreParamMaster scoreParamMaster) {
        ScoreParamMaster scoreParamMasterCreated = null;
        try {
            Long id = scoreParamMaster.getId();
            if(!scoreParamMasterRepository.existsById(id)){
            log.info("-------------Persisting Score Param Master to Database------------");
            scoreParamMasterCreated = ScoreParamMaster.builder()
                    .name(scoreParamMaster.getName())
                    .dataType(scoreParamMaster.getDataType())
                    .dataSource(scoreParamMaster.getDataSource())
                    .computation(scoreParamMaster.getComputation())
                    .scoreCategoryMasterIdFk(scoreParamMaster.getScoreCategoryMasterIdFk())
                    .defaultCriteria(scoreParamMaster.getDefaultCriteria())
                    .description(scoreParamMaster.getDescription())
                    .inTrash("No")
                    .build();
                scoreParamMasterRepository.save(scoreParamMasterCreated);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_MASTER_CREATED);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(scoreParamMasterRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_MASTER_EXISTS);
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
    public ApiResponse getScoreParamMasterById(ScoreParamMaster scoreParamMaster) {
        Long id = scoreParamMaster.getId();
        ScoreParamMaster myScoreParamMaster = null;
        try {
            if (scoreParamMasterRepository.existsById(id)) {
                myScoreParamMaster = scoreParamMasterRepository.findById(id).get();
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_MASTER_FETCHED);
                apiResponse.setEntity(myScoreParamMaster);
                return apiResponse;
            }
            if(!scoreParamMasterRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_MASTER_NOT_EXIST);
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
    public ApiResponse getAllScoreParamMaster() {
        List<ScoreParamMaster> allScoreParamMasters = null;
        try{
            allScoreParamMasters = scoreParamMasterRepository.findAll();
            if(!allScoreParamMasters.isEmpty()){
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_MASTER_ALL_FETCHED);
                apiResponse.setEntity(null);
                return apiResponse;
            }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_MASTER_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse updateById(ScoreParamMaster scoreParamMaster) {
        Long id = scoreParamMaster.getId();
        log.info("Started the update Functionality");
        ScoreParamMaster scoreParamMasterDb = null;
        try {
            if (scoreParamMasterRepository.existsById(id)) {
                scoreParamMasterDb = scoreParamMasterRepository.findById(id).get();

                String dataType = scoreParamMaster.getDataType();
                String dataSource = scoreParamMaster.getDataSource();
                String name =  scoreParamMaster.getName();
                String computation =  scoreParamMaster.getComputation();
                String defaultCriteria =  scoreParamMaster.getDefaultCriteria();
                String description = scoreParamMaster.getDescription();

                if (!dataType.isEmpty() && !dataType.equalsIgnoreCase(scoreParamMasterDb.getDataType())) {
                    scoreParamMasterDb.setDataType(dataType);
                }
                if (!dataSource.isEmpty() && !dataSource.equalsIgnoreCase(scoreParamMasterDb.getDataSource())) {
                    scoreParamMasterDb.setDataSource(dataType);
                }
                if (!name.isEmpty() && !name.equalsIgnoreCase(scoreParamMasterDb.getName())) {
                    scoreParamMasterDb.setName(name);
                }
                if (!computation.isEmpty() && !computation.equalsIgnoreCase(scoreParamMasterDb.getComputation())) {
                    scoreParamMasterDb.setComputation(dataType);
                }
                if (!defaultCriteria.isEmpty() && !defaultCriteria.equalsIgnoreCase(scoreParamMasterDb.getDefaultCriteria())) {
                    scoreParamMasterDb.setDefaultCriteria(dataType);
                }
                if (!description.isEmpty() && !description.equalsIgnoreCase(scoreParamMasterDb.getDescription())) {
                    scoreParamMasterDb.setDescription(description);
                }
                scoreParamMasterRepository.save(scoreParamMasterDb);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_MASTER_UPDATED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!scoreParamMasterRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_MASTER_NOT_EXIST);
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
    public ApiResponse deleteById(ScoreParamMaster scoreParamMaster) {
        Long id = scoreParamMaster.getId();
        try{
            if(scoreParamMasterRepository.existsById(id)){
                scoreParamMasterRepository.deleteById(id);

                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_MASTER_DELETED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!scoreParamMasterRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_MASTER_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(UNCAUGHT_ERROR);
                apiResponse.setEntity(null);
                return apiResponse;
    }
}
