package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCardById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCardGetAll;
import com.pinnoserv.portal.entity.ScoreCard;
import com.pinnoserv.portal.repositories.ScoreCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Service
public class ScoreCardServiceImpl implements ScoreCardService{
    ApiResponse apiResponse = new ApiResponse();
    @Autowired
    ScoreCardRepository scoreCardRepository;

    @Override
    public ApiResponse createScoreCard(ScoreCard scoreCard) {
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
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CARD_CREATED);
                apiResponse.setEntity(null);
                return apiResponse;

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse getById(ScoreCard scoreCard) {
        ScoreCard idScoreCard = null;
        try {
            Long id = scoreCard.getId();
            if(scoreCardRepository.existsById(id)){
                idScoreCard = scoreCardRepository.findById(id).get();
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CARD_FETCHED);
                apiResponse.setEntity(idScoreCard);
                return apiResponse;
            }
            if(!scoreCardRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CARD_NOT_EXIST);
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
    public ApiResponse getAll() {
        List<ScoreCard> scoreCards = null;
        try{
            scoreCards = scoreCardRepository.findAll();
            if(!scoreCards.isEmpty()){
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CARD_FETCHED);
                apiResponse.setEntity(scoreCards);
                return apiResponse;
            }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CARD_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse updateById(ScoreCard scoreCard) {
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
                scoreCardRepository.save(dbScoreCard);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CARD_UPDATED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!scoreCardRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CARD_NOT_EXIST);
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
    public ApiResponse deleteById(ScoreCard scoreCard) {
        try {
            Long id = scoreCard.getId();
            if(scoreCardRepository.existsById(id)){
                scoreCardRepository.deleteById(id);

                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CARD_DELETED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!scoreCardRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CARD_NOT_EXIST);
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
}
