package com.pinnoserv.portal.custommodels.apiresponsedto;

import com.pinnoserv.portal.entity.DataSource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DataSourceById {
    public String ResponseCode;
    public String ResponseMessage;
    DataSource dataSource;
}
