package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "LOAN_SCHEDULE")
public class LoanSchedule {
    private BigInteger loanScheduleId;
    private BigInteger loanIdFk;
    private BigInteger installmentNumber;
    private BigInteger installmentAmount;
    private BigInteger interest;
    private Timestamp dueDate;
    private BigInteger paymentStatus;
    private BigInteger penalty;
    private BigInteger balance;
    private Timestamp dateCreated;
    private String status;
    private String intrash;
    private Loan loanByLoanIdFk;

    @Id
    @Column(name = "LOAN_SCHEDULE_ID")
    public BigInteger getLoanScheduleId() {
        return loanScheduleId;
    }

    public void setLoanScheduleId(BigInteger loanScheduleId) {
        this.loanScheduleId = loanScheduleId;
    }

    @Basic
    @Column(name = "LOAN_ID_FK")
    public BigInteger getLoanIdFk() {
        return loanIdFk;
    }

    public void setLoanIdFk(BigInteger loanIdFk) {
        this.loanIdFk = loanIdFk;
    }

    @Basic
    @Column(name = "INSTALLMENT_NUMBER")
    public BigInteger getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(BigInteger installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    @Basic
    @Column(name = "INSTALLMENT_AMOUNT")
    public BigInteger getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(BigInteger installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    @Basic
    @Column(name = "INTEREST")
    public BigInteger getInterest() {
        return interest;
    }

    public void setInterest(BigInteger interest) {
        this.interest = interest;
    }

    @Basic
    @Column(name = "DUE_DATE")
    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "PAYMENT_STATUS")
    public BigInteger getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(BigInteger paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Basic
    @Column(name = "PENALTY")
    public BigInteger getPenalty() {
        return penalty;
    }

    public void setPenalty(BigInteger penalty) {
        this.penalty = penalty;
    }

    @Basic
    @Column(name = "BALANCE")
    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "DATE_CREATED")
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanSchedule that = (LoanSchedule) o;
        return loanScheduleId == that.loanScheduleId && loanIdFk == that.loanIdFk && paymentStatus == that.paymentStatus && Objects.equals(installmentNumber, that.installmentNumber) && Objects.equals(installmentAmount, that.installmentAmount) && Objects.equals(interest, that.interest) && Objects.equals(dueDate, that.dueDate) && Objects.equals(penalty, that.penalty) && Objects.equals(balance, that.balance) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(status, that.status) && Objects.equals(intrash, that.intrash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanScheduleId, loanIdFk, installmentNumber, installmentAmount, interest, dueDate, paymentStatus, penalty, balance, dateCreated, status, intrash);
    }

    @ManyToOne
    @JoinColumn(name = "LOAN_ID_FK", referencedColumnName = "LOAN_ID", nullable = false, insertable=false, updatable=false)
    public Loan getLoanByLoanIdFk() {
        return loanByLoanIdFk;
    }

    public void setLoanByLoanIdFk(Loan loanByLoanIdFk) {
        this.loanByLoanIdFk = loanByLoanIdFk;
    }
}
