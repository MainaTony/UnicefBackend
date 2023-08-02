package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
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
    ApiResponse apiResponse = new ApiResponse();
    @Autowired
    ScoreCategoryRepository scoreCategoryRepository;
    @Override
    public ApiResponse createScoreCategory(ScoreCategory scoreCategory) {
        try{

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
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_CREATED);
                apiResponse.setEntity(null);
                return apiResponse;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse getById(ScoreCategory scoreCategory) {
        ScoreCategory idScoreCategory = null;
        try{
            Long id = scoreCategory.getId();
            if(scoreCategoryRepository.existsById(id)){
                idScoreCategory = scoreCategoryRepository.findById(id).get();
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_FETCHED);
                apiResponse.setEntity(idScoreCategory);
                return apiResponse;
            }
            if(!scoreCategoryRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(UNCAUGHT_ERROR);
                apiResponse.setEntity(null);
                return apiResponse;
        }

    @Override
    public ApiResponse getAll() {
        List<ScoreCategory> scoreCategories = null;
        try{
            scoreCategories = scoreCategoryRepository.findAll();
            if(scoreCategories != null){
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_ALL_FETCHED);
                apiResponse.setEntity(scoreCategories);
                return apiResponse;
            }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_NOT_EXIST);
                apiResponse.setEntity(scoreCategories);
                return apiResponse;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse updateById(ScoreCategory scoreCategory) {
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
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_UPDATED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!scoreCategoryRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_NOT_UPDATED);
                apiResponse.setEntity(null);
                return apiResponse;
        }

    @Override
    public ApiResponse deleteById(ScoreCategory scoreCategory) {
        try{
            Long id = scoreCategory.getId();
            if(scoreCategoryRepository.existsById(id)){
                scoreCategoryRepository.deleteById(id);

                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_DELETED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!scoreCategoryRepository.existsById(id)){
                    apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                    apiResponse.setResponseDescription(SCORE_CATEGORY_NOT_EXIST);
                    apiResponse.setEntity(null);
                    return apiResponse;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_NOT_DELETED);
                apiResponse.setEntity(null);
                return apiResponse;
    }
}
