package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCardGetAll;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryGetAll;
import com.pinnoserv.portal.entity.ScoreCategory;
import com.pinnoserv.portal.repositories.ScoreCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Service
public class ScoreCategoryImpl implements ScoreCategoryService{
    @Autowired
    ScoreCategoryRepository scoreCategoryRepository;
    @Override
    public CreateUpdateDeleteResponseDto createScoreCategory(ScoreCategory scoreCategory) {
        try{
            Long id = scoreCategory.getId();
            if(!scoreCategoryRepository.existsById(id)){
                ScoreCategory createScoreCategory = ScoreCategory.builder()
                        .name(scoreCategory.getName())
                        .productIdFk(scoreCategory.getProductIdFk())
                        .contribution(scoreCategory.getContribution())
                        .used(scoreCategory.getUsed())
                        .scMasterIdFk(scoreCategory.getScMasterIdFk())
                        .approvalStatus(scoreCategory.getApprovalStatus())
                        .approvalLevel(scoreCategory.getApprovalLevel())
                        .maxApprovals(scoreCategory.getMaxApprovals())
                        .updateCycle(scoreCategory.getUpdateCycle())
                        .inTrash("No")
                        .build();
                scoreCategoryRepository.save(createScoreCategory);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_CREATED)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(scoreCategoryRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_EXISTS)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(SUCCESS_RESPONSE)
                .ResponseMessage(SCORE_CATEGORY_NOT_CREATED)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public ScoreCategoryById getById(ScoreCategory scoreCategory) {
        ScoreCategory idScoreCategory = null;
        try{
            Long id = scoreCategory.getId();
            if(scoreCategoryRepository.existsById(id)){
                idScoreCategory = scoreCategoryRepository.findById(id).get();
                ScoreCategoryById scoreCategoryById = ScoreCategoryById.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .scoreCategorie(idScoreCategory)
                        .build();
                return scoreCategoryById;
            }
            if(!scoreCategoryRepository.existsById(id)){
                ScoreCategoryById scoreCategoryById = ScoreCategoryById.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_NOT_EXIST)
                        .scoreCategorie(null)
                        .build();
                return scoreCategoryById;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        ScoreCategoryById scoreCategoryById = ScoreCategoryById.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .scoreCategorie(null)
                .build();
        return scoreCategoryById;
    }

    @Override
    public ScoreCategoryGetAll getAll() {
        List<ScoreCategory> scoreCategories = null;
        try{
            scoreCategories = scoreCategoryRepository.findAll();
            if(scoreCategories != null){
                ScoreCategoryGetAll scoreCardGetAll = ScoreCategoryGetAll.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .scoreCategories(scoreCategories)
                        .build();
                return scoreCardGetAll;
            }
            ScoreCategoryGetAll scoreCardGetAll = ScoreCategoryGetAll.builder()
                    .ResponseCode(UNSUCCESS_RESPONSE)
                    .ResponseMessage(SCORE_CATEGORY_NOT_EXIST)
                    .scoreCategories(null)
                    .build();
            return scoreCardGetAll;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CreateUpdateDeleteResponseDto updateById(ScoreCategory scoreCategory) {
        try{
            Long id = scoreCategory.getId();
            if(scoreCategoryRepository.existsById(id)){
                String name = scoreCategory.getName();
                int productIdFk = scoreCategory.getProductIdFk();
                Double contribution = scoreCategory.getContribution();
                String used = scoreCategory.getUsed();
                int scMasterIdFk = scoreCategory.getScMasterIdFk();
                int approvalStatus = scoreCategory.getApprovalStatus();
                int approvalLevel = scoreCategory.getApprovalLevel();
                int maxApprovals = scoreCategory.getMaxApprovals();
                Integer updateCycle = scoreCategory.getUpdateCycle();
                ScoreCategory dbScoreCategory = scoreCategoryRepository.findById(id).get();

                if (!name.isEmpty() && !name.equalsIgnoreCase(dbScoreCategory.getName())){
                    dbScoreCategory.setName(name);
                }
                if (!used.isEmpty() && !used.equalsIgnoreCase(dbScoreCategory.getUsed())){
                    dbScoreCategory.setUsed(used);
                }
                if (productIdFk != 0 && productIdFk != dbScoreCategory.getProductIdFk()){
                    dbScoreCategory.setProductIdFk(productIdFk);
                }
                if (contribution != 0 && contribution != dbScoreCategory.getContribution()){
                    dbScoreCategory.setContribution(contribution);
                }
                if (scMasterIdFk != 0 && scMasterIdFk != dbScoreCategory.getScMasterIdFk()){
                    dbScoreCategory.setScMasterIdFk(scMasterIdFk);
                }
                if (approvalStatus != 0 && approvalStatus != dbScoreCategory.getApprovalStatus()){
                    dbScoreCategory.setApprovalStatus(approvalStatus);
                }
                if (approvalLevel != 0 && approvalLevel != dbScoreCategory.getApprovalLevel()){
                    dbScoreCategory.setApprovalLevel(approvalLevel);
                }
                if (maxApprovals != 0 && maxApprovals != dbScoreCategory.getMaxApprovals()){
                    dbScoreCategory.setMaxApprovals(maxApprovals);
                }
                if (updateCycle != 0 && updateCycle != dbScoreCategory.getUpdateCycle()){
                    dbScoreCategory.setUpdateCycle(updateCycle);
                }
                scoreCategoryRepository.save(dbScoreCategory);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_UPDATED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!scoreCategoryRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(SCORE_CATEGORY_NOT_UPDATED)
                .build();
        return createUpdateDeleteResponseDto;

    }

    @Override
    public CreateUpdateDeleteResponseDto deleteById(ScoreCategory scoreCategory) {
        try{
            Long id = scoreCategory.getId();
            if(scoreCategoryRepository.existsById(id)){
                scoreCategoryRepository.deleteById(id);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_DELETED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!scoreCategoryRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(SCORE_CATEGORY_NOT_DELETED)
                .build();
        return createUpdateDeleteResponseDto;
    }
}
