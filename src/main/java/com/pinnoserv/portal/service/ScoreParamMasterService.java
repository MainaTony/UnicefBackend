package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamMasterById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreParamMasterGetAll;
import com.pinnoserv.portal.entity.ScoreParamMaster;

import java.util.List;

public interface ScoreParamMasterService {
    CreateUpdateDeleteResponseDto createScoreParamMaster(ScoreParamMaster scoreParamMaster);
    ScoreParamMasterById getScoreParamMasterById(ScoreParamMaster scoreParamMaster);
    ScoreParamMasterGetAll getAllScoreParamMaster();
    CreateUpdateDeleteResponseDto updateById(ScoreParamMaster scoreParamMaster);

    CreateUpdateDeleteResponseDto deleteById(ScoreParamMaster scoreParamMaster);
}
