package com.pinnoserv.portal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@Builder
@Entity()
@Table(name = "statement_report")
public class StatementReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="agent_deposit")
    private String agentDeposit;
    @Column(name = "customers_received")
    private String customersReceived;
    @Column(name = "paybill_banks")
    private String paybillBanks;
    @Column(name = "fuliza_received")
    private String fulizaReceived;
    @Column(name = "paybill_betting")
    private String paybillBetting;
    @Column(name = "paybill_lenders")
    private String paybillLenders;
    @Column(name = "paybill_others")
    private String paybillOthers;
    @Column(name = "paid_out_paybill_others")
    private String paidOutPaybillOthers;
    @Column(name = "paid_out_customers_sent")
    public String paidOutCustomersSent;
    @Column(name = "paid_out_agent_withdraw")
    private String paidOutAgentWithdraw;
    @Column(name = "paid_out_others")
    private String paidOutOthers;
    @Column(name = "paid_out_buy_goods")
    private String paidOutBuyGoods;
    @Column(name = "paid_out_banks")
    private String paidOutBanks;
    @Column(name = "paid_out_Utilities")
    private String paidOutUtilities;
    @Column(name = "paid_out_fuliza_paid")
    private String paidOutFulizaPaid;
    @Column(name = "paid_out_online_purchases")
    private String paidOutOnlinePurchases;
    @Column(name = "paid_out_betting")
    private String paidOutBetting;
    @Column(name = "paid_out_mobile_lenders")
    private String paidOutMobileLenders;
    @JsonIgnore
    @OneToOne(
            mappedBy = "statementReport"
    )
    private FileData fileData;
}
