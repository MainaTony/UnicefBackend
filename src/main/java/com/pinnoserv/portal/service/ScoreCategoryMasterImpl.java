package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryMasterById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryMasterGetAll;
import com.pinnoserv.portal.entity.ScoreCategoryMaster;
import com.pinnoserv.portal.repositories.ScoreCategoryMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Service
public class ScoreCategoryMasterImpl implements ScoreCategoryMasterService{
    @Autowired
    ScoreCategoryMasterRepository scoreCategoryMasterRepository;
    @Override
    public CreateUpdateDeleteResponseDto createScoreCategoryMaster(ScoreCategoryMaster scoreCategoryMaster) {
        try{
            Long id = scoreCategoryMaster.getId();
            if(!scoreCategoryMasterRepository.existsById(id)){
            ScoreCategoryMaster createScoreCategoryMaster = ScoreCategoryMaster.builder()
                    .name(scoreCategoryMaster.getName())
                    .productIdFk(scoreCategoryMaster.getProductIdFk())
                    .contribution(scoreCategoryMaster.getContribution())
                    .used(scoreCategoryMaster.getUsed())
                    .productName(scoreCategoryMaster.getProductName())
                    .build();
            scoreCategoryMasterRepository.save(createScoreCategoryMaster);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_MASTER_CREATED)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                    .ResponseCode(UNSUCCESS_RESPONSE)
                    .ResponseMessage(SCORE_CATEGORY_MASTER_EXISTS)
                    .build();
            return createUpdateDeleteResponseDto;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ScoreCategoryMasterById viewById(ScoreCategoryMaster scoreCategoryMaster) {
        ScoreCategoryMaster idScoreCategoryMaster = null;
        try{
            Long id = scoreCategoryMaster.getId();
            if(scoreCategoryMasterRepository.existsById(id)){
                idScoreCategoryMaster = scoreCategoryMasterRepository.findById(id).get();
                ScoreCategoryMasterById scoreCategoryMasterById = ScoreCategoryMasterById.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .scoreCategoryMaster(idScoreCategoryMaster)
                        .build();
                return scoreCategoryMasterById;
            }
            if(!scoreCategoryMasterRepository.existsById(id)){
                ScoreCategoryMasterById scoreCategoryMasterById = ScoreCategoryMasterById.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_MASTER_NOT_EXIST)
                        .scoreCategoryMaster(null)
                        .build();
                return scoreCategoryMasterById;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        ScoreCategoryMasterById scoreCategoryMasterById = ScoreCategoryMasterById.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .scoreCategoryMaster(null)
                .build();
        return scoreCategoryMasterById;
    }

    @Override
    public ScoreCategoryMasterGetAll getAll() {
        List<ScoreCategoryMaster> scoreCategoryMasters = null;
        try{
            scoreCategoryMasters = scoreCategoryMasterRepository.findAll();
            if(scoreCategoryMasters != null){
                ScoreCategoryMasterGetAll scoreCategoryMasterGetAll = ScoreCategoryMasterGetAll.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .scoreCategoryMasters(scoreCategoryMasters)
                        .build();
                return scoreCategoryMasterGetAll;
            }
            ScoreCategoryMasterGetAll scoreCategoryMasterGetAll = ScoreCategoryMasterGetAll.builder()
                    .ResponseCode(UNSUCCESS_RESPONSE)
                    .ResponseMessage(SCORE_CATEGORY_MASTER_NOT_EXIST)
                    .scoreCategoryMasters(null)
                    .build();
            return scoreCategoryMasterGetAll;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CreateUpdateDeleteResponseDto updateById(ScoreCategoryMaster scoreCategoryMaster) {
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
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_MASTER_UPDATED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!scoreCategoryMasterRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_MASTER_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(SUCCESS_RESPONSE)
                .ResponseMessage(SCORE_CATEGORY_MASTER_NOT_DELETED)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public CreateUpdateDeleteResponseDto deleteById(ScoreCategoryMaster scoreCategoryMaster) {
        try{
        Long id = scoreCategoryMaster.getId();
        if(scoreCategoryMasterRepository.existsById(id)){
            scoreCategoryMasterRepository.deleteById(id);
            CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                    .ResponseCode(SUCCESS_RESPONSE)
                    .ResponseMessage(SCORE_CATEGORY_MASTER_DELETED_SUCCESSFULLY)
                    .build();
            return createUpdateDeleteResponseDto;
        }
            if(!scoreCategoryMasterRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(SCORE_CATEGORY_MASTER_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(SCORE_CATEGORY_MASTER_NOT_DELETED)
                .build();
        return createUpdateDeleteResponseDto;
    }
}
