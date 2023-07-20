package com.pinnoserv.portal.custommodels.apiresponsedto;

import com.pinnoserv.portal.entity.ScoreParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ScoreParamGetAll {
    public String ResponseCode;

    public String ResponseMessage;
    List<ScoreParam> scoreParams;
}
