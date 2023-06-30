package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.ScoreParam;

import java.util.List;

public interface ScoreParamService {
    ScoreParam createScoreParam(ScoreParam scoreParam);
    ScoreParam getScoreParamById(ScoreParam scoreParam);
    List<ScoreParam> getAllScoreParams();
    ScoreParam updateById(ScoreParam scoreParam);
    void deleteById(ScoreParam scoreParam);
}
