package com.pinnoserv.portal.custommodels.apiresponsedto;

import com.pinnoserv.portal.entity.DelinquencyModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DelinquencyById {
    public String ResponseCode;

    public String ResponseMessage;
    DelinquencyModel delinquencyModel;
}
