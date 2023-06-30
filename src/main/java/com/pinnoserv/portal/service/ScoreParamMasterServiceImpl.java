package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Config;
import com.pinnoserv.portal.entity.ScoreParamMaster;
import com.pinnoserv.portal.repositories.ScoreParamMasterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@Slf4j
public class ScoreParamMasterServiceImpl implements ScoreParamMasterService{
    ScoreParamMasterRepository scoreParamMasterRepository;
    public ScoreParamMasterServiceImpl(ScoreParamMasterRepository scoreParamMasterRepository){
        this.scoreParamMasterRepository = scoreParamMasterRepository;
    }
    @Override
    public ScoreParamMaster createScoreParamMaster(ScoreParamMaster scoreParamMaster) {
        ScoreParamMaster scoreParamMasterCreated = null;
        try {
            log.info("-------------Persisting Score Param Master to Database------------");
            scoreParamMasterCreated = ScoreParamMaster.builder()
                    .name(scoreParamMaster.getName())
                    .dataType(scoreParamMaster.getDataType())
                    .dataSource(scoreParamMaster.getDataSource())
                    .computation(scoreParamMaster.getComputation())
                    .scoreCategoryMasterIdFk(scoreParamMaster.getScoreCategoryMasterIdFk())
                    .defaultCriteria(scoreParamMaster.getDefaultCriteria())
                    .inTrash("No")
                    .build();
            scoreParamMasterRepository.save(scoreParamMasterCreated);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return scoreParamMasterCreated;
    }

    @Override
    public ScoreParamMaster getScoreParamMasterById(ScoreParamMaster scoreParamMaster) {
        Long id = scoreParamMaster.getId();
        ScoreParamMaster myScoreParamMaster = null;
        try {
            if (scoreParamMasterRepository.existsById(id)) {
                myScoreParamMaster = scoreParamMasterRepository.findById(id).get();
            }
        } catch (Exception e) {

        }
        return myScoreParamMaster;
    }

    @Override
    public List<ScoreParamMaster> getAllScoreParamMaster() {
        List<ScoreParamMaster> allScoreParamMasters = null;
        try{
            allScoreParamMasters = scoreParamMasterRepository.findAll();

        } catch (Exception e){}
        return allScoreParamMasters;
    }

    @Override
    public ScoreParamMaster updateById(ScoreParamMaster scoreParamMaster) {
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
                scoreParamMasterRepository.save(scoreParamMasterDb);
            }
        } catch (Exception e) {

        }
        return scoreParamMasterDb;
    }

    @Override
    public void deleteById(ScoreParamMaster scoreParamMaster) {
        Long id = scoreParamMaster.getId();
        try{
            if(scoreParamMasterRepository.existsById(id)){
                scoreParamMasterRepository.deleteById(id);
            }
        } catch (Exception e) {}
    }
}
