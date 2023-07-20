package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.ScoreCard;
import com.pinnoserv.portal.repositories.ScoreCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreCardServiceImpl implements ScoreCardService{
    @Autowired
    ScoreCardRepository scoreCardRepository;

    @Override
    public void createScoreCard(ScoreCard scoreCard) {
        try {
            ScoreCard createScoreCard = ScoreCard.builder()
                    .scoreParamIdFk(scoreCard.getScoreParamIdFk())
                    .dataColumn(scoreCard.getDataColumn())
                    .criteria(scoreCard.getCriteria())
                    .dataSourceIdFk(scoreCard.getDataSourceIdFk())
                    .approvalStatus(scoreCard.getApprovalStatus())
                    .approvalLevel(scoreCard.getApprovalLevel())
                    .maxApprovals(scoreCard.getMaxApprovals())
                    .updateCycle(scoreCard.getUpdateCycle())
                    .inTrash("No")
                    .build();
            scoreCardRepository.save(createScoreCard);
        } catch (Exception e){

        }

    }

    @Override
    public ScoreCard getById(ScoreCard scoreCard) {
        ScoreCard idScoreCard = null;
        try {
            Long id = scoreCard.getId();
            if(scoreCardRepository.existsById(id)){
                idScoreCard = scoreCardRepository.findById(id).get();
            }

        } catch (Exception e){

        }
        return idScoreCard;
    }

    @Override
    public List<ScoreCard> getAll() {
        List<ScoreCard> scoreCards = null;
        try{
            scoreCards = scoreCardRepository.findAll();
        } catch (Exception e){
        }
        return scoreCards;
    }

    @Override
    public void updateById(ScoreCard scoreCard) {
        try {
            Long id = scoreCard.getId();
            if(scoreCardRepository.existsById(id)){
                int scoreParamIdFk = scoreCard.getScoreParamIdFk();
                String dataColumn = scoreCard.getDataColumn();
                String criteria = scoreCard.getCriteria();
                int dataSourceIdFk = scoreCard.getDataSourceIdFk();
                int approvalStatus = scoreCard.getApprovalStatus();
                int approvalLevel = scoreCard.getApprovalLevel();
                int maxApprovals = scoreCard.getMaxApprovals();
                int updateCycle = scoreCard.getUpdateCycle();
                ScoreCard dbScoreCard = scoreCardRepository.findById(id).get();


                if (!dataColumn.isEmpty() && !dataColumn.equalsIgnoreCase(dbScoreCard.getDataColumn())){
                    dbScoreCard.setDataColumn(dataColumn);
                }
                if (!criteria.isEmpty() && !criteria.equalsIgnoreCase(dbScoreCard.getCriteria())){
                    dbScoreCard.setCriteria(criteria);
                }
                if (dataSourceIdFk != 0 && dataSourceIdFk != dbScoreCard.getDataSourceIdFk()){
                    dbScoreCard.setDataSourceIdFk(dataSourceIdFk);
                }
                if (updateCycle != 0 && updateCycle != dbScoreCard.getUpdateCycle()){
                    dbScoreCard.setUpdateCycle(updateCycle);
                }
                if (scoreParamIdFk != 0 && scoreParamIdFk != dbScoreCard.getScoreParamIdFk()){
                    dbScoreCard.setScoreParamIdFk(scoreParamIdFk);
                }
                if (approvalStatus != 0 && approvalStatus != dbScoreCard.getApprovalStatus()){
                    dbScoreCard.setApprovalStatus(approvalStatus);
                }
                if (approvalLevel != 0 && approvalLevel != dbScoreCard.getApprovalLevel()){
                    dbScoreCard.setApprovalLevel(approvalLevel);
                }
                if (maxApprovals != 0 && maxApprovals != dbScoreCard.getMaxApprovals()){
                    dbScoreCard.setMaxApprovals(maxApprovals);
                }
            }
        } catch (Exception e){

        }

    }

    @Override
    public void deleteById(ScoreCard scoreCard) {
        try {
            Long id = scoreCard.getId();
            if(scoreCardRepository.existsById(id)){
                scoreCardRepository.deleteById(id);
            }
        } catch (Exception e){

        }
    }
}
