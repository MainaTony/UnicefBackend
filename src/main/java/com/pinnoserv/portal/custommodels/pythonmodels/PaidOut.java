package com.pinnoserv.portal.custommodels.pythonmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

public class PaidOut {
    @JsonProperty("PaybillOthers")
    public String paybillOthers;
    @JsonProperty("CustomersSent")
    public String customersSent;
    @JsonProperty("AgentWithdraw")
    public String agentWithdraw;
    @JsonProperty("Others")
    public String others;
    @JsonProperty("BuyGoods")
    public String buyGoods;
    @JsonProperty("Banks")
    public String banks;
    @JsonProperty("Utilities")
    public String utilities;
    @JsonProperty("FulizaPaid")
    public String fulizaPaid;
    @JsonProperty("OnlinePurchases")
    public String onlinePurchases;
    @JsonProperty("Betting")
    public String betting;
    @JsonProperty("MobileLenders")
    public String mobileLenders;
}
