package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.DelinquencyById;
import com.pinnoserv.portal.custommodels.apiresponsedto.DelinquencyGetAll;
import com.pinnoserv.portal.entity.DelinquencyModel;
import com.pinnoserv.portal.repositories.DelinquencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Service
public class DelinquencyServiceImpl implements DelinquencyService{
    ApiResponse apiResponse = new ApiResponse();
    @Autowired
    DelinquencyRepository delinquencyRepository;

    @Override
    public ApiResponse createDelinquency(DelinquencyModel delinquencyModel) {
        try{
            Long id = delinquencyModel.getId();
            if(!delinquencyRepository.existsById(id)){
            DelinquencyModel createDelinquencyModel = DelinquencyModel.builder()
                    .productIdFk(delinquencyModel.getProductIdFk())
                    .action(delinquencyModel.getAction())
                    .period(delinquencyModel.getPeriod())
                    .penaltyType(delinquencyModel.getPenaltyType())
                    .inTrash("No")
                    .canDefault(delinquencyModel.getCanDefault())
                    .canBlacklist(delinquencyModel.getCanBlacklist())
                    .daysAfterDefault(delinquencyModel.getDaysAfterDefault())
                    .daysToSuspension(delinquencyModel.getDaysToSuspension())
                    .canSuspend(delinquencyModel.getCanSuspend())
                    .build();
            delinquencyRepository.save(createDelinquencyModel);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DELINQUENCY_CREATED);
                apiResponse.setEntity(null);
                return apiResponse;

            }
            if(delinquencyRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DELINQUENCY_EXISTS);
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
    public ApiResponse findById(DelinquencyModel delinquencyModel) {
        DelinquencyModel idDelinquency = null;
        try{
            Long id = delinquencyModel.getId();
            if(delinquencyRepository.existsById(id)){
                idDelinquency = delinquencyRepository.findById(id).get();
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DELINQUENCY_FETCHED);
                apiResponse.setEntity(idDelinquency);
                return apiResponse;
            }
            if(!delinquencyRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DELINQUENCY_NOT_EXIST);
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
    public ApiResponse findAll() {
        List<DelinquencyModel> delinquencyModels = null;
        try{
            delinquencyModels = delinquencyRepository.findAll();
            if(delinquencyModels != null){
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DELINQUENCY_ALL_FETCHED);
                apiResponse.setEntity(delinquencyModels);
                return apiResponse;
            }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DELINQUENCY_NOT_EXIST);
                apiResponse.setEntity(delinquencyModels);
                return apiResponse;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse updateById(DelinquencyModel delinquencyModel) {
        try{
            Long id = delinquencyModel.getId();
            if(delinquencyRepository.existsById(id)){
                DelinquencyModel dbDelinquencyModel = delinquencyRepository.findById(id).get();
                int productIdFk = delinquencyModel.getProductIdFk();
                String action = delinquencyModel.getAction();
                Integer period = delinquencyModel.getPeriod();
                Integer penalty = delinquencyModel.getPenalty();
                String penaltyType = delinquencyModel.getPenaltyType();
                Integer canDefault = delinquencyModel.getCanDefault();
                Integer canBlacklist = delinquencyModel.getCanBlacklist();
                Integer daysAfterDefault = delinquencyModel.getDaysAfterDefault();
                Integer daysToSuspension = delinquencyModel.getDaysToSuspension();
                Integer canSuspend = delinquencyModel.getCanSuspend();

                if (!action.isEmpty() && !action.equalsIgnoreCase(dbDelinquencyModel.getAction())){
                    dbDelinquencyModel.setAction(action);
                }
                if (!penaltyType.isEmpty() && !penaltyType.equalsIgnoreCase(dbDelinquencyModel.getPenaltyType())){
                    dbDelinquencyModel.setPenaltyType(penaltyType);
                }
                if (period != 0 && period != dbDelinquencyModel.getPeriod()){
                    dbDelinquencyModel.setPeriod(period);
                }
                if (productIdFk != 0 && productIdFk != dbDelinquencyModel.getProductIdFk()){
                    dbDelinquencyModel.setProductIdFk(productIdFk);
                }
                if (penalty != 0 && penalty != dbDelinquencyModel.getPenalty()){
                    dbDelinquencyModel.setPenalty(penalty);
                }
                if (canDefault != 0 && canDefault != dbDelinquencyModel.getCanDefault()){
                    dbDelinquencyModel.setCanDefault(canDefault);
                }
                if (canBlacklist != 0 && canBlacklist != dbDelinquencyModel.getCanBlacklist()){
                    dbDelinquencyModel.setCanBlacklist(canBlacklist);
                }
                if (daysAfterDefault != 0 && daysAfterDefault != dbDelinquencyModel.getDaysAfterDefault()){
                    dbDelinquencyModel.setDaysAfterDefault(daysAfterDefault);
                }
                if (daysToSuspension != 0 && daysToSuspension != dbDelinquencyModel.getDaysToSuspension()){
                    dbDelinquencyModel.setDaysToSuspension(daysToSuspension);
                }
                if (canSuspend != 0 && canSuspend != dbDelinquencyModel.getCanSuspend()){
                    dbDelinquencyModel.setCanSuspend(canSuspend);
                }
                delinquencyRepository.save(dbDelinquencyModel);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DELINQUENCY_UPDATED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!delinquencyRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DELINQUENCY_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DELINQUENCY_NOT_UPDATED);
                apiResponse.setEntity(null);
                return apiResponse;
    }

    @Override
    public ApiResponse deleteById(DelinquencyModel delinquencyModel) {
        try{
            Long id = delinquencyModel.getId();
            if(delinquencyRepository.existsById(id)){
                delinquencyRepository.deleteById(id);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(DELINQUENCY_DELETED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!delinquencyRepository.existsById(id)){
                    apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                    apiResponse.setResponseDescription(DELINQUENCY_NOT_EXIST);
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
}
