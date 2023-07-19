package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.ScoreCategory;
import com.pinnoserv.portal.repositories.ScoreCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreCategoryImpl implements ScoreCategoryService{
    @Autowired
    ScoreCategoryRepository scoreCategoryRepository;
    @Override
    public void createScoreCategory(ScoreCategory scoreCategory) {
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
    }

    @Override
    public ScoreCategory getById(ScoreCategory scoreCategory) {
        ScoreCategory idScoreCategory = null;
        try{
            Long id = scoreCategory.getId();
            if(scoreCategoryRepository.existsById(id)){
                idScoreCategory = scoreCategoryRepository.findById(id).get();
            }
        }
        catch (Exception e){

        }
        return idScoreCategory;
    }

    @Override
    public List<ScoreCategory> getAll() {
        List<ScoreCategory> scoreCategories = null;
        try{
            scoreCategories = scoreCategoryRepository.findAll();
        } catch (Exception e){

        }
        return scoreCategories;
    }

    @Override
    public void updateById(ScoreCategory scoreCategory) {
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
            }

        } catch (Exception e){

        }

    }

    @Override
    public void deleteById(ScoreCategory scoreCategory) {
        try{
            Long id = scoreCategory.getId();
            if(scoreCategoryRepository.existsById(id)){
                scoreCategoryRepository.deleteById(id);
            }
        } catch (Exception e){
        }

    }
}
