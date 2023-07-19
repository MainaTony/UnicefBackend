package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.DelinquencyModel;
import com.pinnoserv.portal.repositories.DelinquencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelinquencyServiceImpl implements DelinquencyService{
    @Autowired
    DelinquencyRepository delinquencyRepository;

    @Override
    public void createDelinquency(DelinquencyModel delinquencyModel) {
        try{
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
        }
        catch (Exception e){

        }

    }

    @Override
    public DelinquencyModel findById(DelinquencyModel delinquencyModel) {
        DelinquencyModel idDelinquency = null;
        try{
            Long id = delinquencyModel.getId();
            if(delinquencyRepository.existsById(id)){
                idDelinquency = delinquencyRepository.findById(id).get();
            }
        }
        catch (Exception e){

        }
        return idDelinquency;
    }

    @Override
    public List<DelinquencyModel> findAll() {
        List<DelinquencyModel> delinquencyModels = null;
        try{
            delinquencyModels = delinquencyRepository.findAll();
        }
        catch (Exception e){

        }
        return delinquencyModels;
    }

    @Override
    public void updateById(DelinquencyModel delinquencyModel) {
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
            }
        } catch (Exception e){

        }
    }

    @Override
    public void deleteById(DelinquencyModel delinquencyModel) {
        try{
            Long id = delinquencyModel.getId();
            if(delinquencyRepository.existsById(id)){
                delinquencyRepository.deleteById(id);
            }
        }
        catch (Exception e){
        }
    }
}
