package com.pinnoserv.portal.custommodels.pythonmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


public class PaidIn {
    @JsonProperty("AgentDeposit")
    public String agentDeposit;
    @JsonProperty("CustomesRecieved")
    public String customesRecieved;
    @JsonProperty("PaybillBanks")
    public String paybillBanks;
    @JsonProperty("FulizaRecieved")
    public String fulizaRecieved;
    @JsonProperty("PaybillBeting")
    public String paybillBeting;
    @JsonProperty("PaybillLenders")
    public String paybillLenders;
    @JsonProperty("PaybillOthers")
    public String paybillOthers;
}
