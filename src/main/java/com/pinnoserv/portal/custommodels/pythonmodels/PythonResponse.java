package com.pinnoserv.portal.custommodels.pythonmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class PythonResponse {
    @JsonProperty("PaidIn")
    public PaidIn paidIn;
    @JsonProperty("PaidOut")
    public PaidOut paidOut;
}
