package com.pinnoserv.portal.custommodels.apiresponsedto;

import com.pinnoserv.portal.entity.BusinessType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BusinessTypeByIdDto {
    public String ResponseCode;
    public String ResponseMessage;
    BusinessType businessType;
}
