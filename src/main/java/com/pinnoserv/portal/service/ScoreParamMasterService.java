package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamMasterById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamMasterGetAll;
import com.pinnoserv.portal.entity.ScoreParamMaster;

import java.util.List;

public interface ScoreParamMasterService {
    ApiResponse createScoreParamMaster(ScoreParamMaster scoreParamMaster);
    ApiResponse getScoreParamMasterById(ScoreParamMaster scoreParamMaster);
    ApiResponse getAllScoreParamMaster();
    ApiResponse updateById(ScoreParamMaster scoreParamMaster);
    ApiResponse deleteById(ScoreParamMaster scoreParamMaster);
}
