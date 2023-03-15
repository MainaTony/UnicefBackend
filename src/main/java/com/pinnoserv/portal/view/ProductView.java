package com.pinnoserv.portal.view;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_VIEW")
public class ProductView {
    private BigInteger productId;
    private BigInteger programIdFk;
    private String programName;
    private String name;
    private BigInteger minAmount;
    private BigInteger maxAmount;
    private BigInteger maxRepayPeriod;
    private BigInteger minRepayPeriod;
    private String recipientType;
    private Date dateCreated;
    private String createdBy;
    private String status;
    private String intrash;
    private BigInteger interestRate;
    private String interestType;
    private BigInteger armotized;
    private BigInteger reducingBalance;
    private BigInteger installmentPeriod;
    private BigInteger interestUpfront;
    private String attachedSupplierId;
    private String periodUnits;
    private BigInteger updateCycle;
    private String installmentOptions;
    private String cbsProduct;
    private BigInteger loanLimitLoanNumCap;
    private BigInteger loanLimitLoanAmountCap;
    private BigInteger takeChargesUpfront;
    private BigInteger automatedScoring;
    private BigInteger organisationIdFk;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCT_ID")
    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "PROGRAM_ID_FK")
    public BigInteger getProgramIdFk() {
        return programIdFk;
    }

    public void setProgramIdFk(BigInteger programIdFk) {
        this.programIdFk = programIdFk;
    }

    @Basic
    @Column(name = "PROGRAM_NAME")
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "MIN_AMOUNT")
    public BigInteger getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigInteger minAmount) {
        this.minAmount = minAmount;
    }

    @Basic
    @Column(name = "MAX_AMOUNT")
    public BigInteger getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigInteger maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Basic
    @Column(name = "MAX_REPAY_PERIOD")
    public BigInteger getMaxRepayPeriod() {
        return maxRepayPeriod;
    }

    public void setMaxRepayPeriod(BigInteger maxRepayPeriod) {
        this.maxRepayPeriod = maxRepayPeriod;
    }

    @Basic
    @Column(name = "MIN_REPAY_PERIOD")
    public BigInteger getMinRepayPeriod() {
        return minRepayPeriod;
    }

    public void setMinRepayPeriod(BigInteger minRepayPeriod) {
        this.minRepayPeriod = minRepayPeriod;
    }

    @Basic
    @Column(name = "RECIPIENT_TYPE")
    public String getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(String recipientType) {
        this.recipientType = recipientType;
    }

    @Basic
    @Column(name = "DATE_CREATED")
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "INTRASH")
    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }

    @Basic
    @Column(name = "INTEREST_RATE")
    public BigInteger getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigInteger interestRate) {
        this.interestRate = interestRate;
    }

    @Basic
    @Column(name = "INTEREST_TYPE")
    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    @Basic
    @Column(name = "ARMOTIZED")
    public BigInteger getArmotized() {
        return armotized;
    }

    public void setArmotized(BigInteger armotized) {
        this.armotized = armotized;
    }

    @Basic
    @Column(name = "REDUCING_BALANCE")
    public BigInteger getReducingBalance() {
        return reducingBalance;
    }

    public void setReducingBalance(BigInteger reducingBalance) {
        this.reducingBalance = reducingBalance;
    }

    @Basic
    @Column(name = "INSTALLMENT_PERIOD")
    public BigInteger getInstallmentPeriod() {
        return installmentPeriod;
    }

    public void setInstallmentPeriod(BigInteger installmentPeriod) {
        this.installmentPeriod = installmentPeriod;
    }

    @Basic
    @Column(name = "INTEREST_UPFRONT")
    public BigInteger getInterestUpfront() {
        return interestUpfront;
    }

    public void setInterestUpfront(BigInteger interestUpfront) {
        this.interestUpfront = interestUpfront;
    }

    @Basic
    @Column(name = "ATTACHED_SUPPLIER_ID")
    public String getAttachedSupplierId() {
        return attachedSupplierId;
    }

    public void setAttachedSupplierId(String attachedSupplierId) {
        this.attachedSupplierId = attachedSupplierId;
    }

    @Basic
    @Column(name = "PERIOD_UNITS")
    public String getPeriodUnits() {
        return periodUnits;
    }

    public void setPeriodUnits(String periodUnits) {
        this.periodUnits = periodUnits;
    }

    @Basic
    @Column(name = "UPDATE_CYCLE")
    public BigInteger getUpdateCycle() {
        return updateCycle;
    }

    public void setUpdateCycle(BigInteger updateCycle) {
        this.updateCycle = updateCycle;
    }

    @Basic
    @Column(name = "INSTALLMENT_OPTIONS")
    public String getInstallmentOptions() {
        return installmentOptions;
    }

    public void setInstallmentOptions(String installmentOptions) {
        this.installmentOptions = installmentOptions;
    }

    @Basic
    @Column(name = "CBS_PRODUCT")
    public String getCbsProduct() {
        return cbsProduct;
    }

    public void setCbsProduct(String cbsProduct) {
        this.cbsProduct = cbsProduct;
    }

    @Basic
    @Column(name = "LOAN_LIMIT_LOAN_NUM_CAP")
    public BigInteger getLoanLimitLoanNumCap() {
        return loanLimitLoanNumCap;
    }

    public void setLoanLimitLoanNumCap(BigInteger loanLimitLoanNumCap) {
        this.loanLimitLoanNumCap = loanLimitLoanNumCap;
    }

    @Basic
    @Column(name = "LOAN_LIMIT_LOAN_AMOUNT_CAP")
    public BigInteger getLoanLimitLoanAmountCap() {
        return loanLimitLoanAmountCap;
    }

    public void setLoanLimitLoanAmountCap(BigInteger loanLimitLoanAmountCap) {
        this.loanLimitLoanAmountCap = loanLimitLoanAmountCap;
    }

    @Basic
    @Column(name = "TAKE_CHARGES_UPFRONT")
    public BigInteger getTakeChargesUpfront() {
        return takeChargesUpfront;
    }

    public void setTakeChargesUpfront(BigInteger takeChargesUpfront) {
        this.takeChargesUpfront = takeChargesUpfront;
    }

    @Basic
    @Column(name = "AUTOMATED_SCORING")
    public BigInteger getAutomatedScoring() {
        return automatedScoring;
    }

    public void setAutomatedScoring(BigInteger automatedScoring) {
        this.automatedScoring = automatedScoring;
    }

    @Basic
    @Column(name = "ORGANISATION_ID_FK")
    public BigInteger getOrganisationIdFk() {
        return organisationIdFk;
    }

    public void setOrganisationIdFk(BigInteger organisationIdFk) {
        this.organisationIdFk = organisationIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductView that = (ProductView) o;
        return productId == that.productId && programIdFk == that.programIdFk && reducingBalance == that.reducingBalance && installmentPeriod == that.installmentPeriod && takeChargesUpfront == that.takeChargesUpfront && Objects.equals(programName, that.programName) && Objects.equals(name, that.name) && Objects.equals(minAmount, that.minAmount) && Objects.equals(maxAmount, that.maxAmount) && Objects.equals(maxRepayPeriod, that.maxRepayPeriod) && Objects.equals(minRepayPeriod, that.minRepayPeriod) && Objects.equals(recipientType, that.recipientType) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(createdBy, that.createdBy) && Objects.equals(status, that.status) && Objects.equals(intrash, that.intrash) && Objects.equals(interestRate, that.interestRate) && Objects.equals(interestType, that.interestType) && Objects.equals(armotized, that.armotized) && Objects.equals(interestUpfront, that.interestUpfront) && Objects.equals(attachedSupplierId, that.attachedSupplierId) && Objects.equals(periodUnits, that.periodUnits) && Objects.equals(updateCycle, that.updateCycle) && Objects.equals(installmentOptions, that.installmentOptions) && Objects.equals(cbsProduct, that.cbsProduct) && Objects.equals(loanLimitLoanNumCap, that.loanLimitLoanNumCap) && Objects.equals(loanLimitLoanAmountCap, that.loanLimitLoanAmountCap) && Objects.equals(automatedScoring, that.automatedScoring);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, programIdFk, programName, name, minAmount, maxAmount, maxRepayPeriod, minRepayPeriod, recipientType, dateCreated, createdBy, status, intrash, interestRate, interestType, armotized, reducingBalance, installmentPeriod, interestUpfront, attachedSupplierId, periodUnits, updateCycle, installmentOptions, cbsProduct, loanLimitLoanNumCap, loanLimitLoanAmountCap, takeChargesUpfront, automatedScoring);
    }
}
