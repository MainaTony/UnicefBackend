package com.pinnoserv.portal.custommodels.apiresponsedto;

import com.pinnoserv.portal.entity.ScoreCategoryMaster;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ScoreCategoryMasterById {
    public String ResponseCode;

    public String ResponseMessage;
    ScoreCategoryMaster scoreCategoryMaster;
}
