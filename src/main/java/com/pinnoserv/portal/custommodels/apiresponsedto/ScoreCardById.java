package com.pinnoserv.portal.custommodels.apiresponsedto;

import com.pinnoserv.portal.entity.ScoreCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ScoreCardById {
    public String ResponseCode;

    public String ResponseMessage;
    ScoreCard scoreCard;

}
