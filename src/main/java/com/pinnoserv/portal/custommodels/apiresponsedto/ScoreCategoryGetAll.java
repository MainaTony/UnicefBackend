package com.pinnoserv.portal.custommodels.apiresponsedto;

import com.pinnoserv.portal.entity.ScoreCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ScoreCategoryGetAll {
    public String ResponseCode;

    public String ResponseMessage;
    ScoreCategory scoreCategory;
}
