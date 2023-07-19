package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.ScoreCategoryMaster;
import com.pinnoserv.portal.repositories.ScoreCategoryMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreCategoryMasterImpl implements ScoreCategoryMasterService{
    @Autowired
    ScoreCategoryMasterRepository scoreCategoryMasterRepository;
    @Override
    public void createScoreCategoryMaster(ScoreCategoryMaster scoreCategoryMaster) {
        try{
            ScoreCategoryMaster createScoreCategoryMaster = ScoreCategoryMaster.builder()
                    .name(scoreCategoryMaster.getName())
                    .productIdFk(scoreCategoryMaster.getProductIdFk())
                    .contribution(scoreCategoryMaster.getContribution())
                    .used(scoreCategoryMaster.getUsed())
                    .productName(scoreCategoryMaster.getProductName())
                    .build();
            scoreCategoryMasterRepository.save(createScoreCategoryMaster);
        } catch (Exception e){

        }
    }

    @Override
    public ScoreCategoryMaster viewById(ScoreCategoryMaster scoreCategoryMaster) {
        ScoreCategoryMaster idScoreCategoryMaster = null;
        try{
            Long id = scoreCategoryMaster.getId();
            if(scoreCategoryMasterRepository.existsById(id)){
                idScoreCategoryMaster = scoreCategoryMasterRepository.findById(id).get();
            }
        }
        catch (Exception e){

        }
        return idScoreCategoryMaster;
    }

    @Override
    public List<ScoreCategoryMaster> getAll() {
        List<ScoreCategoryMaster> scoreCategoryMasters = null;
        try{
            scoreCategoryMasters = scoreCategoryMasterRepository.findAll();
        } catch (Exception e){
        }
        return scoreCategoryMasters;

    }

    @Override
    public void updateById(ScoreCategoryMaster scoreCategoryMaster) {
        try {
            Long id = scoreCategoryMaster.getId();
            if(scoreCategoryMasterRepository.existsById(id)){
                String name = scoreCategoryMaster.getName();
                int productIdFk = scoreCategoryMaster.getProductIdFk();
                Double contribution = scoreCategoryMaster.getContribution();
                String used = scoreCategoryMaster.getUsed();
                String productName = scoreCategoryMaster.getProductName();
                ScoreCategoryMaster dbScoreCategoryMaster = scoreCategoryMasterRepository.findById(id).get();

                if (!name.isEmpty() && !name.equalsIgnoreCase(dbScoreCategoryMaster.getName())){
                    dbScoreCategoryMaster.setName(name);
                }
                if (!used.isEmpty() && !used.equalsIgnoreCase(dbScoreCategoryMaster.getUsed())){
                    dbScoreCategoryMaster.setUsed(used);
                }
                if (!productName.isEmpty() && !productName.equalsIgnoreCase(dbScoreCategoryMaster.getProductName())){
                    dbScoreCategoryMaster.setProductName(productName);
                }
                if (productIdFk != 0 && productIdFk != dbScoreCategoryMaster.getProductIdFk()){
                    dbScoreCategoryMaster.setProductIdFk(productIdFk);
                }
                if (contribution != 0 && contribution != dbScoreCategoryMaster.getContribution()){
                    dbScoreCategoryMaster.setContribution(contribution);
                }
                scoreCategoryMasterRepository.save(dbScoreCategoryMaster);
            }
        } catch (Exception e){

        }
    }

    @Override
    public void deleteById(ScoreCategoryMaster scoreCategoryMaster) {
        try{
        Long id = scoreCategoryMaster.getId();
        if(scoreCategoryMasterRepository.existsById(id)){
            scoreCategoryMasterRepository.deleteById(id);
        }
        } catch (Exception e){
        }

    }
}
