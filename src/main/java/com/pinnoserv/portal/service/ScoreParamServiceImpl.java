package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Config;
import com.pinnoserv.portal.entity.ScoreParam;
import com.pinnoserv.portal.repositories.ScoreParamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
@Service
@Slf4j
public class ScoreParamServiceImpl implements ScoreParamService{
    public ScoreParamServiceImpl(ScoreParamRepository scoreParamRepository){
        this.scoreParamRepository = scoreParamRepository;
    }
    ScoreParamRepository scoreParamRepository;
    @Override
    public ScoreParam createScoreParam(ScoreParam scoreParam) {

        ScoreParam createScoreParam = null;
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return createScoreParam;
    }

    @Override
    public ScoreParam getScoreParamById(ScoreParam scoreParam) {
        Long id = scoreParam.getId();
        ScoreParam myScoreParam = null;
        try {
            if (scoreParamRepository.existsById(id)) {
                myScoreParam = scoreParamRepository.findById(id).get();
            }
        } catch (Exception e) {

        }
        return myScoreParam;
    }

    @Override
    public List<ScoreParam> getAllScoreParams() {
        List<ScoreParam> allScoreParams= null;
        try{
            allScoreParams = scoreParamRepository.findAll();

        } catch (Exception e){}
        return allScoreParams;
    }

    @Override
    public ScoreParam updateById(ScoreParam scoreParam) {
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
            }
        } catch (Exception e) {

        }
        return scoreParamDb;
    }

    @Override
    public void deleteById(ScoreParam scoreParam) {
        Long id = scoreParam.getId();
        try{
            if(scoreParamRepository.existsById(id)){
                scoreParamRepository.deleteById(id);
            }
        } catch (Exception e) {}
    }
}
