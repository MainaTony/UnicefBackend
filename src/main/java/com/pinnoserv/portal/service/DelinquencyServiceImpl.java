package com.pinnoserv.portal.service;

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
    @Autowired
    DelinquencyRepository delinquencyRepository;

    @Override
    public CreateUpdateDeleteResponseDto createDelinquency(DelinquencyModel delinquencyModel) {
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
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(DELINQUENCY_CREATED)
                        .build();
                return createUpdateDeleteResponseDto;

            }
            if(delinquencyRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(DELINQUENCY_EXISTS)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        }

        catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(DELINQUENCY_NOT_CREATED)
                .build();
        return createUpdateDeleteResponseDto;

    }

    @Override
    public DelinquencyById findById(DelinquencyModel delinquencyModel) {
        DelinquencyModel idDelinquency = null;
        try{
            Long id = delinquencyModel.getId();
            if(delinquencyRepository.existsById(id)){
                idDelinquency = delinquencyRepository.findById(id).get();
                DelinquencyById delinquencyById = DelinquencyById.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .delinquencyModel(idDelinquency)
                        .build();
                return delinquencyById;
            }
            if(!delinquencyRepository.existsById(id)){
                DelinquencyById delinquencyById = DelinquencyById.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(DELINQUENCY_NOT_EXIST)
                        .delinquencyModel(null)
                        .build();
                return delinquencyById;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        DelinquencyById delinquencyById = DelinquencyById.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .delinquencyModel(null)
                .build();
        return delinquencyById;
    }

    @Override
    public DelinquencyGetAll findAll() {
        List<DelinquencyModel> delinquencyModels = null;
        try{
            delinquencyModels = delinquencyRepository.findAll();
            if(delinquencyModels != null){
            DelinquencyGetAll delinquencyGetAll = DelinquencyGetAll.builder()
                    .ResponseCode(SUCCESS_RESPONSE)
                    .delinquencyModels(delinquencyModels)
                    .build();
            return delinquencyGetAll;
            }

            DelinquencyGetAll delinquencyGetAll = DelinquencyGetAll.builder()
                    .ResponseCode(UNSUCCESS_RESPONSE)
                    .ResponseMessage(DELINQUENCY_NOT_EXIST)
                    .delinquencyModels(null)
                    .build();
            return delinquencyGetAll;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CreateUpdateDeleteResponseDto updateById(DelinquencyModel delinquencyModel) {
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
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(DELINQUENCY_UPDATED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!delinquencyRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(DELINQUENCY_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(DELINQUENCY_NOT_UPDATED)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public CreateUpdateDeleteResponseDto deleteById(DelinquencyModel delinquencyModel) {
        try{
            Long id = delinquencyModel.getId();
            if(delinquencyRepository.existsById(id)){
                delinquencyRepository.deleteById(id);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(DELINQUENCY_DELETED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!delinquencyRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(DELINQUENCY_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(DELINQUENCY_NOT_DELETED)
                .build();
        return createUpdateDeleteResponseDto;
    }
}
