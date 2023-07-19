package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.DelinquencyModel;

import java.util.List;

public interface DelinquencyService {
    void createDelinquency(DelinquencyModel delinquencyModel);
    DelinquencyModel findById(DelinquencyModel delinquencyModel);
    List<DelinquencyModel> findAll();
    void updateById(DelinquencyModel delinquencyModel);
    void deleteById(DelinquencyModel delinquencyModel);

}
