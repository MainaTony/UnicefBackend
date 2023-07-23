package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCardById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCardGetAll;
import com.pinnoserv.portal.entity.ScoreCard;

import java.util.List;

public interface ScoreCardService {
    ApiResponse createScoreCard(ScoreCard scoreCard);
    ApiResponse getById(ScoreCard scoreCard);
    ApiResponse getAll();
    ApiResponse updateById(ScoreCard scoreCard);
    ApiResponse deleteById(ScoreCard scoreCard);
}
