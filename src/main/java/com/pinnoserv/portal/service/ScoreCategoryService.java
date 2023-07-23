package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCardGetAll;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryGetAll;
import com.pinnoserv.portal.entity.ScoreCategory;

import java.util.List;

public interface ScoreCategoryService {
    ApiResponse createScoreCategory(ScoreCategory scoreCategory);
    ApiResponse getById(ScoreCategory scoreCategory);
    ApiResponse getAll ();
    ApiResponse updateById(ScoreCategory scoreCategory);
    ApiResponse deleteById(ScoreCategory scoreCategory);

}
