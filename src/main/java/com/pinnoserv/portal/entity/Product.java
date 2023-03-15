package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
public class Product {
    private BigInteger productId;
    private BigInteger programIdFk;
    private String name;
    private BigInteger minAmount;
    private BigInteger maxAmount;
    private BigInteger maxRepayPeriod;
    private BigInteger minRepayPeriod;
    private String recipientType;
    private Date dateCreated;
    private BigInteger createdBy;
    private BigInteger status;
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
    //private Collection<DelinquencyModel> delinquencyModelsByProductId;
    //private Collection<Loan> loansByProductId;
    //private Program programByProgramIdFk;
    //private Collection<RepaymentChannel> repaymentChannelsByProductId;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
    @SequenceGenerator(name = "PRODUCT_SEQ", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
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
    public BigInteger getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(BigInteger createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "STATUS")
    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && programIdFk == product.programIdFk && reducingBalance == product.reducingBalance && installmentPeriod == product.installmentPeriod && takeChargesUpfront == product.takeChargesUpfront && Objects.equals(name, product.name) && Objects.equals(minAmount, product.minAmount) && Objects.equals(maxAmount, product.maxAmount) && Objects.equals(maxRepayPeriod, product.maxRepayPeriod) && Objects.equals(minRepayPeriod, product.minRepayPeriod) && Objects.equals(recipientType, product.recipientType) && Objects.equals(dateCreated, product.dateCreated) && Objects.equals(createdBy, product.createdBy) && Objects.equals(status, product.status) && Objects.equals(intrash, product.intrash) && Objects.equals(interestRate, product.interestRate) && Objects.equals(interestType, product.interestType) && Objects.equals(armotized, product.armotized) && Objects.equals(interestUpfront, product.interestUpfront) && Objects.equals(attachedSupplierId, product.attachedSupplierId) && Objects.equals(periodUnits, product.periodUnits) && Objects.equals(updateCycle, product.updateCycle) && Objects.equals(installmentOptions, product.installmentOptions) && Objects.equals(cbsProduct, product.cbsProduct) && Objects.equals(loanLimitLoanNumCap, product.loanLimitLoanNumCap) && Objects.equals(loanLimitLoanAmountCap, product.loanLimitLoanAmountCap) && Objects.equals(automatedScoring, product.automatedScoring);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, programIdFk, name, minAmount, maxAmount, maxRepayPeriod, minRepayPeriod, recipientType, dateCreated, createdBy, status, intrash, interestRate, interestType, armotized, reducingBalance, installmentPeriod, interestUpfront, attachedSupplierId, periodUnits, updateCycle, installmentOptions, cbsProduct, loanLimitLoanNumCap, loanLimitLoanAmountCap, takeChargesUpfront, automatedScoring);
    }

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
