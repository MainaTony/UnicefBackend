package com.pinnoserv.portal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity()
@Table(name = "statement_report")
public class StatementReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="agent_deposit")
    private float agentDeposit;
    @Column(name = "customers_received")
    private float customersReceived;
    @Column(name = "paybill_banks")
    private float paybillBanks;
    @Column(name = "fuliza_received")
    private float fulizaReceived;
    @Column(name = "paybill_betting")
    private float paybillBetting;
    @Column(name = "paybill_lenders")
    private float paybillLenders;
    @Column(name = "paybill_others")
    private float paybillOthers;
    @Column(name = "paid_out_paybill_others")
    private float paidOutPaybillOthers;
    @Column(name = "paid_out_customers_sent")
    public float paidOutCustomersSent;
    @Column(name = "paid_out_agent_withdraw")
    public float paidOutAgentWithdraw;
    @Column(name = "paid_out_others")
    public float paidOutOthers;
    @Column(name = "paid_out_buy_goods")
    public float paidOutBuyGoods;
    @Column(name = "paid_out_banks")
    public float paidOutBanks;
    @Column(name = "paid_out_Utilities")
    public float paidOutUtilities;
    @Column(name = "paid_out_fuliza_paid")
    public float paidOutFulizaPaid;
    @Column(name = "paid_out_online_purchases")
    public float paidOutOnlinePurchases;
    @Column(name = "paid_out_betting")
    public float paidOutBetting;
    @Column(name = "paid_out_mobile_lenders")
    public float paidOutMobileLenders;


}
