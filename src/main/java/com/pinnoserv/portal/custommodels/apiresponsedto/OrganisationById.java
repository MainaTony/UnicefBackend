package com.pinnoserv.portal.custommodels.apiresponsedto;

import com.pinnoserv.portal.entity.Organisation;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrganisationById {
    public String ResponseCode;

    public String ResponseMessage;
    Organisation organisation;
}
