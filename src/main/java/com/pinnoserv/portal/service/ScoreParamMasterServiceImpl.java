package com.pinnoserv.portal.service;

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
    ScoreParamMasterRepository scoreParamMasterRepository;
    public ScoreParamMasterServiceImpl(ScoreParamMasterRepository scoreParamMasterRepository){
        this.scoreParamMasterRepository = scoreParamMasterRepository;
    }
    @Override
    public CreateUpdateDeleteResponseDto createScoreParamMaster(ScoreParamMaster scoreParamMaster) {
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
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_PARAM_MASTER_CREATED)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(scoreParamMasterRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_PARAM_MASTER_EXISTS)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(SCORE_PARAM_MASTER_NOT_CREATED)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public ScoreParamMasterById getScoreParamMasterById(ScoreParamMaster scoreParamMaster) {
        Long id = scoreParamMaster.getId();
        ScoreParamMaster myScoreParamMaster = null;
        try {
            if (scoreParamMasterRepository.existsById(id)) {
                myScoreParamMaster = scoreParamMasterRepository.findById(id).get();
                ScoreParamMasterById scoreParamMasterById = ScoreParamMasterById.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .scoreParamMaster(myScoreParamMaster)
                        .build();
                return scoreParamMasterById;
            }
            if(!scoreParamMasterRepository.existsById(id)){
                ScoreParamMasterById scoreParamMasterById = ScoreParamMasterById.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_PARAM_MASTER_NOT_EXIST)
                        .scoreParamMaster(null)
                        .build();
                return scoreParamMasterById;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ScoreParamMasterById scoreParamMasterById = ScoreParamMasterById.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .scoreParamMaster(null)
                .build();
        return scoreParamMasterById;
    }

    @Override
    public ScoreParamMasterGetAll getAllScoreParamMaster() {
        List<ScoreParamMaster> allScoreParamMasters = null;
        try{
            allScoreParamMasters = scoreParamMasterRepository.findAll();
            if(!allScoreParamMasters.isEmpty()){
                ScoreParamMasterGetAll scoreParamMasterGetAll = ScoreParamMasterGetAll.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .scoreParamMasters(allScoreParamMasters)
                        .build();
                return scoreParamMasterGetAll;
            }
            ScoreParamMasterGetAll scoreParamMasterGetAll = ScoreParamMasterGetAll.builder()
                    .ResponseCode(UNSUCCESS_RESPONSE)
                    .ResponseMessage(SCORE_PARAM_MASTER_NOT_EXIST)
                    .scoreParamMasters(null)
                    .build();
            return scoreParamMasterGetAll;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CreateUpdateDeleteResponseDto updateById(ScoreParamMaster scoreParamMaster) {
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
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_PARAM_MASTER_UPDATED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!scoreParamMasterRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_PARAM_MASTER_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e) {

        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(SCORE_PARAM_MASTER_NOT_UPDATED)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public CreateUpdateDeleteResponseDto deleteById(ScoreParamMaster scoreParamMaster) {
        Long id = scoreParamMaster.getId();
        try{
            if(scoreParamMasterRepository.existsById(id)){
                scoreParamMasterRepository.deleteById(id);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_PARAM_MASTER_DELETED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!scoreParamMasterRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_PARAM_MASTER_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(SUCCESS_RESPONSE)
                .ResponseMessage(SCORE_PARAM_MASTER_NOT_DELETED)
                .build();
        return createUpdateDeleteResponseDto;
    }
}
