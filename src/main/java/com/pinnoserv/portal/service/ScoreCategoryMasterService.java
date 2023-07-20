package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryMasterById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryMasterGetAll;
import com.pinnoserv.portal.entity.ScoreCategoryMaster;

import java.util.List;

public interface ScoreCategoryMasterService {
    CreateUpdateDeleteResponseDto createScoreCategoryMaster(ScoreCategoryMaster scoreCategoryMaster);
    ScoreCategoryMasterById viewById(ScoreCategoryMaster scoreCategoryMaster);
    ScoreCategoryMasterGetAll getAll();
    CreateUpdateDeleteResponseDto updateById(ScoreCategoryMaster scoreCategoryMaster);
    CreateUpdateDeleteResponseDto deleteById(ScoreCategoryMaster scoreCategoryMaster);
}
