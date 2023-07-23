package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryMasterById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryMasterGetAll;
import com.pinnoserv.portal.entity.ScoreCategoryMaster;

import java.util.List;

public interface ScoreCategoryMasterService {
    ApiResponse createScoreCategoryMaster(ScoreCategoryMaster scoreCategoryMaster);
    ApiResponse viewById(ScoreCategoryMaster scoreCategoryMaster);
    ApiResponse getAll();
    ApiResponse updateById(ScoreCategoryMaster scoreCategoryMaster);
    ApiResponse deleteById(ScoreCategoryMaster scoreCategoryMaster);
}
