package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamGetAll;
import com.pinnoserv.portal.entity.ScoreParam;

import java.util.List;

public interface ScoreParamService {
    CreateUpdateDeleteResponseDto createScoreParam(ScoreParam scoreParam);
    ScoreParamById getScoreParamById(ScoreParam scoreParam);
    ScoreParamGetAll getAllScoreParams();
    CreateUpdateDeleteResponseDto updateById(ScoreParam scoreParam);
    CreateUpdateDeleteResponseDto deleteById(ScoreParam scoreParam);
}
