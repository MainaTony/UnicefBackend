package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @Basic(optional = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "PRODUCT_SEQ", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
    @Column(name = "PRODUCT_ID")
    private BigInteger productId;
    @Basic
    @Column(name = "PROGRAM_ID_FK")
    private BigInteger programIdFk;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "MIN_AMOUNT")
    private BigInteger minAmount;
    @Basic
    @Column(name = "MAX_AMOUNT")
    private BigInteger maxAmount;
    @Basic
    @Column(name = "MAX_REPAY_PERIOD")
    private BigInteger maxRepayPeriod;
    @Basic
    @Column(name = "MIN_REPAY_PERIOD")
    private BigInteger minRepayPeriod;
    @Basic
    @Column(name = "RECIPIENT_TYPE")
    private String recipientType;
    @Basic
    @Column(name = "DATE_CREATED")
    private Date dateCreated;
    @Basic
    @Column(name = "CREATED_BY")
    private BigInteger createdBy;
    @Basic
    @Column(name = "STATUS")
    private BigInteger status;
    @Basic
    @Column(name = "INTRASH")
    private String intrash;
    @Basic
    @Column(name = "INTEREST_RATE")
    private BigInteger interestRate;
    @Basic
    @Column(name = "INTEREST_TYPE")
    private String interestType;
    @Basic
    @Column(name = "ARMOTIZED")
    private BigInteger armotized;
    @Basic
    @Column(name = "REDUCING_BALANCE")
    private BigInteger reducingBalance;
    @Basic
    @Column(name = "INSTALLMENT_PERIOD")
    private BigInteger installmentPeriod;
    @Basic
    @Column(name = "INTEREST_UPFRONT")
    private BigInteger interestUpfront;
    @Basic
    @Column(name = "ATTACHED_SUPPLIER_ID")
    private String attachedSupplierId;
    @Basic
    @Column(name = "PERIOD_UNITS")
    private String periodUnits;
    @Basic
    @Column(name = "UPDATE_CYCLE")
    private BigInteger updateCycle;
    @Basic
    @Column(name = "INSTALLMENT_OPTIONS")
    private String installmentOptions;
    @Basic
    @Column(name = "CBS_PRODUCT")
    private String cbsProduct;
    @Basic
    @Column(name = "LOAN_LIMIT_LOAN_NUM_CAP")
    private BigInteger loanLimitLoanNumCap;
    @Basic
    @Column(name = "LOAN_LIMIT_LOAN_AMOUNT_CAP")
    private BigInteger loanLimitLoanAmountCap;
    @Basic
    @Column(name = "TAKE_CHARGES_UPFRONT")
    private BigInteger takeChargesUpfront;
    @Basic
    @Column(name = "AUTOMATED_SCORING")
    private BigInteger automatedScoring;
    //private Collection<DelinquencyModel> delinquencyModelsByProductId;
    //private Collection<Loan> loansByProductId;
    //private Program programByProgramIdFk;
    //private Collection<RepaymentChannel> repaymentChannelsByProductId;


    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }


    public BigInteger getProgramIdFk() {
        return programIdFk;
    }

    public void setProgramIdFk(BigInteger programIdFk) {
        this.programIdFk = programIdFk;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public BigInteger getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigInteger minAmount) {
        this.minAmount = minAmount;
    }


    public BigInteger getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigInteger maxAmount) {
        this.maxAmount = maxAmount;
    }


    public BigInteger getMaxRepayPeriod() {
        return maxRepayPeriod;
    }

    public void setMaxRepayPeriod(BigInteger maxRepayPeriod) {
        this.maxRepayPeriod = maxRepayPeriod;
    }


    public BigInteger getMinRepayPeriod() {
        return minRepayPeriod;
    }

    public void setMinRepayPeriod(BigInteger minRepayPeriod) {
        this.minRepayPeriod = minRepayPeriod;
    }


    public String getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(String recipientType) {
        this.recipientType = recipientType;
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    public BigInteger getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(BigInteger createdBy) {
        this.createdBy = createdBy;
    }


    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }


    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }


    public BigInteger getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigInteger interestRate) {
        this.interestRate = interestRate;
    }


    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }


    public BigInteger getArmotized() {
        return armotized;
    }

    public void setArmotized(BigInteger armotized) {
        this.armotized = armotized;
    }


    public BigInteger getReducingBalance() {
        return reducingBalance;
    }

    public void setReducingBalance(BigInteger reducingBalance) {
        this.reducingBalance = reducingBalance;
    }


    public BigInteger getInstallmentPeriod() {
        return installmentPeriod;
    }

    public void setInstallmentPeriod(BigInteger installmentPeriod) {
        this.installmentPeriod = installmentPeriod;
    }


    public BigInteger getInterestUpfront() {
        return interestUpfront;
    }

    public void setInterestUpfront(BigInteger interestUpfront) {
        this.interestUpfront = interestUpfront;
    }


    public String getAttachedSupplierId() {
        return attachedSupplierId;
    }

    public void setAttachedSupplierId(String attachedSupplierId) {
        this.attachedSupplierId = attachedSupplierId;
    }


    public String getPeriodUnits() {
        return periodUnits;
    }

    public void setPeriodUnits(String periodUnits) {
        this.periodUnits = periodUnits;
    }


    public BigInteger getUpdateCycle() {
        return updateCycle;
    }

    public void setUpdateCycle(BigInteger updateCycle) {
        this.updateCycle = updateCycle;
    }


    public String getInstallmentOptions() {
        return installmentOptions;
    }

    public void setInstallmentOptions(String installmentOptions) {
        this.installmentOptions = installmentOptions;
    }


    public String getCbsProduct() {
        return cbsProduct;
    }

    public void setCbsProduct(String cbsProduct) {
        this.cbsProduct = cbsProduct;
    }


    public BigInteger getLoanLimitLoanNumCap() {
        return loanLimitLoanNumCap;
    }

    public void setLoanLimitLoanNumCap(BigInteger loanLimitLoanNumCap) {
        this.loanLimitLoanNumCap = loanLimitLoanNumCap;
    }


    public BigInteger getLoanLimitLoanAmountCap() {
        return loanLimitLoanAmountCap;
    }

    public void setLoanLimitLoanAmountCap(BigInteger loanLimitLoanAmountCap) {
        this.loanLimitLoanAmountCap = loanLimitLoanAmountCap;
    }


    public BigInteger getTakeChargesUpfront() {
        return takeChargesUpfront;
    }

    public void setTakeChargesUpfront(BigInteger takeChargesUpfront) {
        this.takeChargesUpfront = takeChargesUpfront;
    }


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
