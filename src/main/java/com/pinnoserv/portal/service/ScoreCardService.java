package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.ScoreCard;

import java.util.List;

public interface ScoreCardService {
    void createScoreCard(ScoreCard scoreCard);
    ScoreCard getById(ScoreCard scoreCard);
    List<ScoreCard> getAll();
    void updateById(ScoreCard scoreCard);
    void deleteById(ScoreCard scoreCard);
}
