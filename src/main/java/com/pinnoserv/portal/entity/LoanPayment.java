//package com.pinnoserv.portal.entity;
//
//import javax.persistence.*;
//import java.math.BigInteger;
//import java.sql.Timestamp;
//import java.util.Objects;
//
//@Entity
//@Table(name = "LOAN_PAYMENT")
//public class LoanPayment {
//    private BigInteger loanPaymentId;
//    private BigInteger loanIdFk;
//    private BigInteger amount;
//    private BigInteger channelIdFk;
//    private Timestamp timeInitiated;
//    private Timestamp timeCompleted;
//    private BigInteger processingStatus;
//    private String description;
//    private Boolean amountPaid;
//    private String reference;
//    private Loan loanByLoanIdFk;
//    private Channel channelByChannelIdFk;
//
//    @Id
//    @Column(name = "LOAN_PAYMENT_ID")
//    public BigInteger getLoanPaymentId() {
//        return loanPaymentId;
//    }
//
//    public void setLoanPaymentId(BigInteger loanPaymentId) {
//        this.loanPaymentId = loanPaymentId;
//    }
//
//    @Basic
//    @Column(name = "LOAN_ID_FK")
//    public BigInteger getLoanIdFk() {
//        return loanIdFk;
//    }
//
//    public void setLoanIdFk(BigInteger loanIdFk) {
//        this.loanIdFk = loanIdFk;
//    }
//
//    @Basic
//    @Column(name = "AMOUNT")
//    public BigInteger getAmount() {
//        return amount;
//    }
//
//    public void setAmount(BigInteger amount) {
//        this.amount = amount;
//    }
//
//    @Basic
//    @Column(name = "CHANNEL_ID_FK")
//    public BigInteger getChannelIdFk() {
//        return channelIdFk;
//    }
//
//    public void setChannelIdFk(BigInteger channelIdFk) {
//        this.channelIdFk = channelIdFk;
//    }
//
//    @Basic
//    @Column(name = "TIME_INITIATED")
//    public Timestamp getTimeInitiated() {
//        return timeInitiated;
//    }
//
//    public void setTimeInitiated(Timestamp timeInitiated) {
//        this.timeInitiated = timeInitiated;
//    }
//
//    @Basic
//    @Column(name = "TIME_COMPLETED")
//    public Timestamp getTimeCompleted() {
//        return timeCompleted;
//    }
//
//    public void setTimeCompleted(Timestamp timeCompleted) {
//        this.timeCompleted = timeCompleted;
//    }
//
//    @Basic
//    @Column(name = "PROCESSING_STATUS")
//    public BigInteger getProcessingStatus() {
//        return processingStatus;
//    }
//
//    public void setProcessingStatus(BigInteger processingStatus) {
//        this.processingStatus = processingStatus;
//    }
//
//    @Basic
//    @Column(name = "DESCRIPTION")
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Basic
//    @Column(name = "AMOUNT_PAID")
//    public Boolean getAmountPaid() {
//        return amountPaid;
//    }
//
//    public void setAmountPaid(Boolean amountPaid) {
//        this.amountPaid = amountPaid;
//    }
//
//    @Basic
//    @Column(name = "REFERENCE")
//    public String getReference() {
//        return reference;
//    }
//
//    public void setReference(String reference) {
//        this.reference = reference;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        LoanPayment that = (LoanPayment) o;
//        return loanPaymentId == that.loanPaymentId && loanIdFk == that.loanIdFk && amount == that.amount && channelIdFk == that.channelIdFk && processingStatus == that.processingStatus && Objects.equals(timeInitiated, that.timeInitiated) && Objects.equals(timeCompleted, that.timeCompleted) && Objects.equals(description, that.description) && Objects.equals(amountPaid, that.amountPaid) && Objects.equals(reference, that.reference);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(loanPaymentId, loanIdFk, amount, channelIdFk, timeInitiated, timeCompleted, processingStatus, description, amountPaid, reference);
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "LOAN_ID_FK", referencedColumnName = "LOAN_ID", nullable = false, insertable=false, updatable=false)
//    public Loan getLoanByLoanIdFk() {
//        return loanByLoanIdFk;
//    }
//
//    public void setLoanByLoanIdFk(Loan loanByLoanIdFk) {
//        this.loanByLoanIdFk = loanByLoanIdFk;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "CHANNEL_ID_FK", referencedColumnName = "CHANNEL_ID", nullable = false, insertable=false, updatable=false)
//    public Channel getChannelByChannelIdFk() {
//        return channelByChannelIdFk;
//    }
//
//    public void setChannelByChannelIdFk(Channel channelByChannelIdFk) {
//        this.channelByChannelIdFk = channelByChannelIdFk;
//    }
//}
