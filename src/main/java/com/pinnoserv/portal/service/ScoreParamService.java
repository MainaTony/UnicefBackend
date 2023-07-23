package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamGetAll;
import com.pinnoserv.portal.entity.ScoreParam;

import java.util.List;

public interface ScoreParamService {
    ApiResponse createScoreParam(ScoreParam scoreParam);
    ApiResponse getScoreParamById(ScoreParam scoreParam);
    ApiResponse getAllScoreParams();
    ApiResponse updateById(ScoreParam scoreParam);
    ApiResponse deleteById(ScoreParam scoreParam);
}
