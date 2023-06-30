package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.ScoreParamMaster;

import java.util.List;

public interface ScoreParamMasterService {
    ScoreParamMaster createScoreParamMaster(ScoreParamMaster scoreParamMaster);
    ScoreParamMaster getScoreParamMasterById(ScoreParamMaster scoreParamMaster);
    List<ScoreParamMaster> getAllScoreParamMaster();
    ScoreParamMaster updateById(ScoreParamMaster scoreParamMaster);

    void deleteById(ScoreParamMaster scoreParamMaster);
}
