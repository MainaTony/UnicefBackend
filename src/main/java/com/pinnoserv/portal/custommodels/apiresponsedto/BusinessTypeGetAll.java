package com.pinnoserv.portal.custommodels.apiresponsedto;

import com.pinnoserv.portal.entity.BusinessType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BusinessTypeGetAll {

    public String ResponseCode;
    public String ResponseMessage;
    List<BusinessType> businessType;
}
