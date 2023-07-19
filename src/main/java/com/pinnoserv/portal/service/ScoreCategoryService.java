package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.ScoreCategory;

import java.util.List;

public interface ScoreCategoryService {
    void createScoreCategory(ScoreCategory scoreCategory);
    ScoreCategory getById(ScoreCategory scoreCategory);
    List<ScoreCategory> getAll ();
    void updateById(ScoreCategory scoreCategory);
    void deleteById(ScoreCategory scoreCategory);

}
