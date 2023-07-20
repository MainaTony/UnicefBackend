package com.pinnoserv.portal.custommodels.apiresponsedto;

import com.pinnoserv.portal.entity.Organisation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrganisationGetAll {
    public String ResponseCode;

    public String ResponseMessage;
    List<Organisation> organisations;

}
