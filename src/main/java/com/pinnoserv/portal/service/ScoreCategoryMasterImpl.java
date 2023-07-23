package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
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
    ApiResponse apiResponse = new ApiResponse();
    @Autowired
    ScoreCategoryMasterRepository scoreCategoryMasterRepository;
    @Override
    public ApiResponse createScoreCategoryMaster(ScoreCategoryMaster scoreCategoryMaster) {
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
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_MASTER_CREATED);
                apiResponse.setEntity(null);
                return apiResponse;
            }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_MASTER_EXISTS);
                apiResponse.setEntity(null);
                return apiResponse;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse viewById(ScoreCategoryMaster scoreCategoryMaster) {
        ScoreCategoryMaster idScoreCategoryMaster = null;
        try{
            Long id = scoreCategoryMaster.getId();
            if(scoreCategoryMasterRepository.existsById(id)){
                idScoreCategoryMaster = scoreCategoryMasterRepository.findById(id).get();
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_MASTER_FETCHED);
                apiResponse.setEntity(idScoreCategoryMaster);
                return apiResponse;
            }
            if(!scoreCategoryMasterRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_MASTER_NOT_EXIST);
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
        List<ScoreCategoryMaster> scoreCategoryMasters = null;
        try{
            scoreCategoryMasters = scoreCategoryMasterRepository.findAll();
            if(scoreCategoryMasters != null){
                    apiResponse.setResponseCode(SUCCESS_RESPONSE);
                    apiResponse.setResponseDescription(SCORE_CATEGORY_MASTER_ALL_FETCHED);
                    apiResponse.setEntity(scoreCategoryMasters);
                    return apiResponse;
            }
                    apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                    apiResponse.setResponseDescription(SCORE_CATEGORY_MASTER_NOT_EXIST);
                    apiResponse.setEntity(null);
                    return apiResponse;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse updateById(ScoreCategoryMaster scoreCategoryMaster) {
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
                    apiResponse.setResponseCode(SUCCESS_RESPONSE);
                    apiResponse.setResponseDescription(SCORE_CATEGORY_MASTER_UPDATED_SUCCESSFULLY);
                    apiResponse.setEntity(null);
                    return apiResponse;
            }
            if(!scoreCategoryMasterRepository.existsById(id)){
                    apiResponse.setResponseCode(SUCCESS_RESPONSE);
                    apiResponse.setResponseDescription(SCORE_CATEGORY_MASTER_NOT_EXIST);
                    apiResponse.setEntity(null);
                    return apiResponse;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
                    apiResponse.setResponseCode(SUCCESS_RESPONSE);
                    apiResponse.setResponseDescription(UNCAUGHT_ERROR);
                    apiResponse.setEntity(null);
                    return apiResponse;
        }

    @Override
    public ApiResponse deleteById(ScoreCategoryMaster scoreCategoryMaster) {
        try{
        Long id = scoreCategoryMaster.getId();
        if(scoreCategoryMasterRepository.existsById(id)){
            scoreCategoryMasterRepository.deleteById(id);
            apiResponse.setResponseCode(SUCCESS_RESPONSE);
            apiResponse.setResponseDescription(SCORE_CATEGORY_MASTER_DELETED_SUCCESSFULLY);
            apiResponse.setEntity(null);
            return apiResponse;
        }
            if(!scoreCategoryMasterRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_MASTER_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(SCORE_CATEGORY_MASTER_NOT_DELETED);
                apiResponse.setEntity(null);
                return apiResponse;
    }
}
