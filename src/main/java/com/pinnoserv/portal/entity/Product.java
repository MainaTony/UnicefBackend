package com.pinnoserv.portal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "min_amount")
    private Double minAmount;
    @Column(name = "max_amount")
    private Double maxAmount;
    @Column(name = "max_repayment_period")
    private Integer maxRepayPeriod;
    @Column(name = "min_repayment_period")
    private Integer minRepayPeriod;
    @Column(name = "recipient_type")
    private String recipientType;
    @Column(name = "date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "status")
    private Integer status;
    @Column(name = "in_trash")
    private String inTrash;
    @Column(name = "interest_rate")
    private Double interestRate;
    @Column(name = "interest_type")
    private String interestType;
    @Column(name = "armotized")
    private Integer armotized;
    @Column(name = "reducing_balance")
    private Double reducingBalance;
    @Column(name = "installment_period")
    private Integer installmentPeriod;
    @Column(name = "interest_upfront")
    private Double interestUpfront;
    @Column(name = "attached_supplier_id")
    private String attachedSupplierId;
    @Column(name = "period_units")
    private String periodUnits;
    @Column(name = "update_cycle")
    private Integer updateCycle;
    @Column(name = "installment_options")
    private String installmentOptions;
    @Column(name = "cbs_product")
    private String cbsProduct;
    @Column(name = "loan_limit_loan_num_cap")
    private Double loanLimitLoanNumCap;
    @Column(name = "loan_limit_loan_amount_cap")
    private Double loanLimitLoanAmountCap;
    @Column(name = "take_charges_upfront")
    private Double takeChargesUpfront;
    @Column(name = "automated_scoring")
    private Integer automatedScoring;
    @ManyToOne
    @JoinColumn(
            name = "organisation_id",
            referencedColumnName = "organisation_id"
    )
    private Organisation organisation;



    //private Collection<DelinquencyModel> delinquencyModelsByProductId;
    //private Collection<Loan> loansByProductId;
    //private Program programByProgramIdFk;
    //private Collection<RepaymentChannel> repaymentChannelsByProductId;


//    public String getProgramName() {
//        return programName;
//    }
//
//    public void setProgramName(String programName) {
//        this.programName = programName;
//    }
//
//    public Integer getOrganisationIdFk() {
//        return organisationIdFk;
//    }
//
//    public void setOrganisationIdFk(Integer organisationIdFk) {
//        this.organisationIdFk = organisationIdFk;
//    }
//
//    public Integer getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Integer productId) {
//        this.productId = productId;
//    }
//
//
//    public Integer getProgramIdFk() {
//        return programIdFk;
//    }
//
//    public void setProgramIdFk(Integer programIdFk) {
//        this.programIdFk = programIdFk;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public Double getMinAmount() {
//        return minAmount;
//    }
//
//    public void setMinAmount(Double minAmount) {
//        this.minAmount = minAmount;
//    }
//
//
//    public Double getMaxAmount() {
//        return maxAmount;
//    }
//
//    public void setMaxAmount(Double maxAmount) {
//        this.maxAmount = maxAmount;
//    }
//
//
//    public Integer getMaxRepayPeriod() {
//        return maxRepayPeriod;
//    }
//
//    public void setMaxRepayPeriod(Integer maxRepayPeriod) {
//        this.maxRepayPeriod = maxRepayPeriod;
//    }
//
//
//    public Integer getMinRepayPeriod() {
//        return minRepayPeriod;
//    }
//
//    public void setMinRepayPeriod(Integer minRepayPeriod) {
//        this.minRepayPeriod = minRepayPeriod;
//    }
//
//
//    public String getRecipientType() {
//        return recipientType;
//    }
//
//    public void setRecipientType(String recipientType) {
//        this.recipientType = recipientType;
//    }
//
//
//    public Date getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//
//    public Integer getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(Integer createdBy) {
//        this.createdBy = createdBy;
//    }
//
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//
//    public String getIntrash() {
//        return intrash;
//    }
//
//    public void setIntrash(String intrash) {
//        this.intrash = intrash;
//    }
//
//
//    public Double getInterestRate() {
//        return interestRate;
//    }
//
//    public void setInterestRate(Double interestRate) {
//        this.interestRate = interestRate;
//    }
//
//
//    public String getInterestType() {
//        return interestType;
//    }
//
//    public void setInterestType(String interestType) {
//        this.interestType = interestType;
//    }
//
//
//    public Integer getArmotized() {
//        return armotized;
//    }
//
//    public void setArmotized(Integer armotized) {
//        this.armotized = armotized;
//    }
//
//
//    public Double getReducingBalance() {
//        return reducingBalance;
//    }
//
//    public void setReducingBalance(Double reducingBalance) {
//        this.reducingBalance = reducingBalance;
//    }
//
//
//    public Integer getInstallmentPeriod() {
//        return installmentPeriod;
//    }
//
//    public void setInstallmentPeriod(Integer installmentPeriod) {
//        this.installmentPeriod = installmentPeriod;
//    }
//
//
//    public Double getInterestUpfront() {
//        return interestUpfront;
//    }
//
//    public void setInterestUpfront(Double interestUpfront) {
//        this.interestUpfront = interestUpfront;
//    }
//
//
//    public String getAttachedSupplierId() {
//        return attachedSupplierId;
//    }
//
//    public void setAttachedSupplierId(String attachedSupplierId) {
//        this.attachedSupplierId = attachedSupplierId;
//    }
//
//
//    public String getPeriodUnits() {
//        return periodUnits;
//    }
//
//    public void setPeriodUnits(String periodUnits) {
//        this.periodUnits = periodUnits;
//    }
//
//
//    public Integer getUpdateCycle() {
//        return updateCycle;
//    }
//
//    public void setUpdateCycle(Integer updateCycle) {
//        this.updateCycle = updateCycle;
//    }
//
//
//    public String getInstallmentOptions() {
//        return installmentOptions;
//    }
//
//    public void setInstallmentOptions(String installmentOptions) {
//        this.installmentOptions = installmentOptions;
//    }
//
//
//    public String getCbsProduct() {
//        return cbsProduct;
//    }
//
//    public void setCbsProduct(String cbsProduct) {
//        this.cbsProduct = cbsProduct;
//    }
//
//
//    public Double getLoanLimitLoanNumCap() {
//        return loanLimitLoanNumCap;
//    }
//
//    public void setLoanLimitLoanNumCap(Double loanLimitLoanNumCap) {
//        this.loanLimitLoanNumCap = loanLimitLoanNumCap;
//    }
//
//
//    public Double getLoanLimitLoanAmountCap() {
//        return loanLimitLoanAmountCap;
//    }
//
//    public void setLoanLimitLoanAmountCap(Double loanLimitLoanAmountCap) {
//        this.loanLimitLoanAmountCap = loanLimitLoanAmountCap;
//    }
//
//
//    public Double getTakeChargesUpfront() {
//        return takeChargesUpfront;
//    }
//
//    public void setTakeChargesUpfront(Double takeChargesUpfront) {
//        this.takeChargesUpfront = takeChargesUpfront;
//    }
//
//
//    public Integer getAutomatedScoring() {
//        return automatedScoring;
//    }
//
//    public void setAutomatedScoring(Integer automatedScoring) {
//        this.automatedScoring = automatedScoring;
//    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Product product = (Product) o;
//        return productId == product.productId && programIdFk == product.programIdFk && reducingBalance == product.reducingBalance && installmentPeriod == product.installmentPeriod && takeChargesUpfront == product.takeChargesUpfront && organisationIdFk == product.organisationIdFk && Objects.equals(name, product.name) && Objects.equals(minAmount, product.minAmount) && Objects.equals(maxAmount, product.maxAmount) && Objects.equals(maxRepayPeriod, product.maxRepayPeriod) && Objects.equals(minRepayPeriod, product.minRepayPeriod) && Objects.equals(recipientType, product.recipientType) && Objects.equals(dateCreated, product.dateCreated) && Objects.equals(createdBy, product.createdBy) && Objects.equals(status, product.status) && Objects.equals(intrash, product.intrash) && Objects.equals(interestRate, product.interestRate) && Objects.equals(interestType, product.interestType) && Objects.equals(armotized, product.armotized) && Objects.equals(interestUpfront, product.interestUpfront) && Objects.equals(attachedSupplierId, product.attachedSupplierId) && Objects.equals(periodUnits, product.periodUnits) && Objects.equals(updateCycle, product.updateCycle) && Objects.equals(installmentOptions, product.installmentOptions) && Objects.equals(cbsProduct, product.cbsProduct) && Objects.equals(loanLimitLoanNumCap, product.loanLimitLoanNumCap) && Objects.equals(loanLimitLoanAmountCap, product.loanLimitLoanAmountCap) && Objects.equals(automatedScoring, product.automatedScoring) && Objects.equals(programName, product.programName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(productId, programIdFk, name, minAmount, maxAmount, maxRepayPeriod, minRepayPeriod, recipientType, dateCreated, createdBy, status, intrash, interestRate, interestType, armotized, reducingBalance, installmentPeriod, interestUpfront, attachedSupplierId, periodUnits, updateCycle, installmentOptions, cbsProduct, loanLimitLoanNumCap, loanLimitLoanAmountCap, takeChargesUpfront, automatedScoring, organisationIdFk, programName);
//    }

    /*@OneToMany(mappedBy = "productByProductIdFk")
    public Collection<DelinquencyModel> getDelinquencyModelsByProductId() {
        return delinquencyModelsByProductId;
    }

    public void setDelinquencyModelsByProductId(Collection<DelinquencyModel> delinquencyModelsByProductId) {
        this.delinquencyModelsByProductId = delinquencyModelsByProductId;
    }

    @OneToMany(mappedBy = "productByProductIdFk")
    public Collection<Loan> getLoansByProductId() {
        return loansByProductId;
    }

    public void setLoansByProductId(Collection<Loan> loansByProductId) {
        this.loansByProductId = loansByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "PROGRAM_ID_FK", referencedColumnName = "PROGRAM_ID", nullable = false, insertable=false, updatable=false)
    public Program getProgramByProgramIdFk() {
        return programByProgramIdFk;
    }

    public void setProgramByProgramIdFk(Program programByProgramIdFk) {
        this.programByProgramIdFk = programByProgramIdFk;
    }

    @OneToMany(mappedBy = "productByProductIdFk")
    public Collection<RepaymentChannel> getRepaymentChannelsByProductId() {
        return repaymentChannelsByProductId;
    }

    public void setRepaymentChannelsByProductId(Collection<RepaymentChannel> repaymentChannelsByProductId) {
        this.repaymentChannelsByProductId = repaymentChannelsByProductId;
    }*/
}
