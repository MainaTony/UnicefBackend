package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.ScoreCategoryMaster;

import java.util.List;

public interface ScoreCategoryMasterService {
    void createScoreCategoryMaster(ScoreCategoryMaster scoreCategoryMaster);
    ScoreCategoryMaster viewById(ScoreCategoryMaster scoreCategoryMaster);
    List<ScoreCategoryMaster> getAll();
    void updateById(ScoreCategoryMaster scoreCategoryMaster);
    void deleteById(ScoreCategoryMaster scoreCategoryMaster);
}
