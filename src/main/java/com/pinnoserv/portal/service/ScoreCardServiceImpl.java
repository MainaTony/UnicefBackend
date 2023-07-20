package com.pinnoserv.portal.service;

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
    @Autowired
    ScoreCardRepository scoreCardRepository;

    @Override
    public CreateUpdateDeleteResponseDto createScoreCard(ScoreCard scoreCard) {
        try {
            Long id = scoreCard.getId();
            if (!scoreCardRepository.existsById(id)){
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
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CARD_CREATED)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(scoreCardRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CARD_CREATED)
                        .build();
                return createUpdateDeleteResponseDto;
            }

        } catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(SCORE_CARD_NOT_CREATED)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public ScoreCardById getById(ScoreCard scoreCard) {
        ScoreCard idScoreCard = null;
        try {
            Long id = scoreCard.getId();
            if(scoreCardRepository.existsById(id)){
                idScoreCard = scoreCardRepository.findById(id).get();
                ScoreCardById scoreCardById = ScoreCardById.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .scoreCard(idScoreCard)
                        .build();
                return scoreCardById;
            }
            if(!scoreCardRepository.existsById(id)){
                ScoreCardById scoreCardById = ScoreCardById.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CARD_NOT_EXIST)
                        .scoreCard(null)
                        .build();
                return scoreCardById;
            }

        } catch (Exception e){
            throw new RuntimeException(e);
        }
        ScoreCardById scoreCardById = ScoreCardById.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(SCORE_CARD_NOT_EXIST)
                .scoreCard(null)
                .build();
        return scoreCardById;
    }

    @Override
    public ScoreCardGetAll getAll() {
        List<ScoreCard> scoreCards = null;
        try{
            scoreCards = scoreCardRepository.findAll();
            if(!scoreCards.isEmpty()){
                ScoreCardGetAll scoreCardGetAll = ScoreCardGetAll.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .scoreCards(scoreCards)
                        .build();
                return scoreCardGetAll;
            }
            ScoreCardGetAll scoreCardGetAll = ScoreCardGetAll.builder()
                    .ResponseCode(UNSUCCESS_RESPONSE)
                    .ResponseMessage(SCORE_CARD_NOT_EXIST)
                    .scoreCards(null)
                    .build();
            return scoreCardGetAll;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CreateUpdateDeleteResponseDto updateById(ScoreCard scoreCard) {
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
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CARD_UPDATED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!scoreCardRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CARD_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(SCORE_CARD_NOT_UPDATED)
                .build();
        return createUpdateDeleteResponseDto;

    }

    @Override
    public CreateUpdateDeleteResponseDto deleteById(ScoreCard scoreCard) {
        try {
            Long id = scoreCard.getId();
            if(scoreCardRepository.existsById(id)){
                scoreCardRepository.deleteById(id);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CARD_DELETED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!scoreCardRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CARD_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(SCORE_CARD_NOT_DELETED)
                .build();
        return createUpdateDeleteResponseDto;
    }
}
