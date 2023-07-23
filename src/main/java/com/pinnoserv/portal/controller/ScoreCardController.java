package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.ScoreCard;
import com.pinnoserv.portal.service.ScoreCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scorecard")
public class ScoreCardController {
    @Autowired
    ScoreCardService scoreCardService;
    @PostMapping("/create")
    public ApiResponse createScoreCard(@RequestBody ScoreCard scoreCard){
        return scoreCardService.createScoreCard(scoreCard);
    }
    @PostMapping("/getById")
    public ApiResponse getScoreCardById(@RequestBody ScoreCard scoreCard){
        return scoreCardService.getById(scoreCard);
    }
    @PostMapping("/getAll")
    public ApiResponse getAllScoreCards(){
        return scoreCardService.getAll();
    }
    @PostMapping("/updateById")
    public ApiResponse updateScoreCardById(@RequestBody ScoreCard scoreCard){
        return scoreCardService.updateById(scoreCard);
    }
    @PostMapping("/deleteById")
    public ApiResponse deleteScoreCardById(@RequestBody ScoreCard scoreCard){
        return scoreCardService.deleteById(scoreCard);
    }
}
