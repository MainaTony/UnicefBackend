package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamGetAll;
import com.pinnoserv.portal.entity.Config;
import com.pinnoserv.portal.entity.ScoreParam;
import com.pinnoserv.portal.repositories.ScoreParamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Service
@Slf4j
public class ScoreParamServiceImpl implements ScoreParamService{
    ApiResponse apiResponse = new ApiResponse();
    public ScoreParamServiceImpl(ScoreParamRepository scoreParamRepository){
        this.scoreParamRepository = scoreParamRepository;
    }
    ScoreParamRepository scoreParamRepository;
    @Override
    public ApiResponse createScoreParam(ScoreParam scoreParam) {

        ScoreParam createScoreParam = null;
        try {
            Long id = scoreParam.getId();
            if(!scoreParamRepository.existsById(id)){
            log.info("-------------Persisting Score Param to Database------------");
                createScoreParam = ScoreParam.builder()
                        .name(scoreParam.getName())
                        .dataType(scoreParam.getDataType())
                        .dataSource(scoreParam.getDataSource())
                        .computation(scoreParam.getComputation())
                        .scoreCategoryIdFk(scoreParam.getScoreCategoryIdFk())
                        .masterParamIdFk(scoreParam.getMasterParamIdFk())
                        .percentageValue(scoreParam.getPercentageValue())
                        .approvalLevel(scoreParam.getApprovalLevel())
                        .approvalStatus(scoreParam.getApprovalStatus())
                        .maxApprovals(scoreParam.getMaxApprovals())
                        .updateCycle(scoreParam.getUpdateCycle())
                        .inTrash("No")
                        .build();
                scoreParamRepository.save(createScoreParam);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_CREATED);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(scoreParamRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_EXISTS);
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
    public ApiResponse getScoreParamById(ScoreParam scoreParam) {
        Long id = scoreParam.getId();
        ScoreParam myScoreParam = null;
        try {
            if (scoreParamRepository.existsById(id)) {
                myScoreParam = scoreParamRepository.findById(id).get();
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_FETCHED);
                apiResponse.setEntity(myScoreParam);
                return apiResponse;
            }
            if(!scoreParamRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_NOT_EXIST);
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
    public ApiResponse getAllScoreParams() {
        List<ScoreParam> allScoreParams= null;
        try{
            allScoreParams = scoreParamRepository.findAll();
            if(allScoreParams != null){
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_FETCHED);
                apiResponse.setEntity(allScoreParams);
                return apiResponse;
            }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public ApiResponse updateById(ScoreParam scoreParam) {
        Long id = scoreParam.getId();
        log.info("Started the update Functionality");
        ScoreParam scoreParamDb = null;
        try {
            if (scoreParamRepository.existsById(id)) {
                scoreParamDb = scoreParamRepository.findById(id).get();

                String name = scoreParam.getName();
                String dataType = scoreParam.getDataType();
                String dataSource = scoreParam.getDataSource();
                String computation = scoreParam.getComputation();
                Long scoreCategoryIdFk = scoreParam.getScoreCategoryIdFk();
                Long masterParamIdFk = scoreParam.getMasterParamIdFk();
                BigInteger percentageValue = scoreParam.getPercentageValue();
                BigInteger approvalStatus = scoreParam.getApprovalStatus();
                BigInteger approvalLevel = scoreParam.getApprovalLevel();
                BigInteger maxApprovals = scoreParam.getMaxApprovals();
                BigInteger updateCycle = scoreParam.getUpdateCycle();
                String inTrash = scoreParam.getInTrash();


                if (!dataType.isEmpty() && !dataType.equalsIgnoreCase(scoreParamDb.getDataType())) {
                    scoreParamDb.setDataType(dataType);
                }
                if (!dataSource.isEmpty() && !dataSource.equalsIgnoreCase(scoreParamDb.getDataSource())) {
                    scoreParamDb.setDataSource(dataSource);
                }
                if (!name.isEmpty() && !name.equalsIgnoreCase(scoreParamDb.getName())) {
                    scoreParamDb.setName(name);
                }
                if (!computation.isEmpty() && !computation.equalsIgnoreCase(scoreParamDb.getComputation())) {
                    scoreParamDb.setComputation(computation);
                }
                if (!inTrash.isEmpty() && !inTrash.equalsIgnoreCase(scoreParamDb.getInTrash())) {
                    scoreParamDb.setInTrash(inTrash);
                }
                if (percentageValue != scoreParamDb.getPercentageValue()) {
                    scoreParamDb.setPercentageValue(percentageValue);
                }
                if (approvalStatus != scoreParamDb.getApprovalStatus()) {
                    scoreParamDb.setApprovalStatus(approvalStatus);
                }
                if (approvalLevel != scoreParamDb.getApprovalLevel()) {
                    scoreParamDb.setApprovalLevel(approvalLevel);
                }
                if (maxApprovals != scoreParamDb.getMaxApprovals()) {
                    scoreParamDb.setMaxApprovals(maxApprovals);
                }
                if (updateCycle != scoreParamDb.getUpdateCycle()) {
                    scoreParamDb.setUpdateCycle(updateCycle);
                }
                scoreParamRepository.save(scoreParamDb);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_UPDATED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!scoreParamRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_NOT_EXIST);
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

    @Override
    public ApiResponse deleteById(ScoreParam scoreParam) {
        Long id = scoreParam.getId();
        try{
            if(scoreParamRepository.existsById(id)){
                scoreParamRepository.deleteById(id);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_DELETED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!scoreParamRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_PARAM_NOT_DELETED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
    }
}
