package com.pinnoserv.portal.custommodels.apiresponsedto;

import com.pinnoserv.portal.entity.Config;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ConfigById {
    public String ResponseCode;
    public String ResponseMessage;
    Config config;
}
