package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCardById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ScoreCardGetAll;
import com.pinnoserv.portal.entity.ScoreCard;

import java.util.List;

public interface ScoreCardService {
    CreateUpdateDeleteResponseDto createScoreCard(ScoreCard scoreCard);
    ScoreCardById getById(ScoreCard scoreCard);
    ScoreCardGetAll getAll();
    CreateUpdateDeleteResponseDto updateById(ScoreCard scoreCard);
    CreateUpdateDeleteResponseDto deleteById(ScoreCard scoreCard);
}
