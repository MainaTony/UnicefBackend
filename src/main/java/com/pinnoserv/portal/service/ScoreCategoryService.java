package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCardGetAll;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCategoryGetAll;
import com.pinnoserv.portal.entity.ScoreCategory;

import java.util.List;

public interface ScoreCategoryService {
    CreateUpdateDeleteResponseDto createScoreCategory(ScoreCategory scoreCategory);
    ScoreCategoryById getById(ScoreCategory scoreCategory);
    ScoreCategoryGetAll getAll ();
    CreateUpdateDeleteResponseDto updateById(ScoreCategory scoreCategory);
    CreateUpdateDeleteResponseDto deleteById(ScoreCategory scoreCategory);

}
