package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER_ACCOUNT")
public class CustomerAccount {
    private BigInteger accountId;
    private BigInteger customerIdFk;
    private Date dateCreated;
    private String accountType;
    private BigInteger availBal;
    private BigInteger actualBal;
    private BigInteger loanId;
    private String intrash;
    private Boolean status;
    private Customer customerByCustomerIdFk;

    @Id
    @Column(name = "ACCOUNT_ID")
    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "CUSTOMER_ID_FK")
    public BigInteger getCustomerIdFk() {
        return customerIdFk;
    }

    public void setCustomerIdFk(BigInteger customerIdFk) {
        this.customerIdFk = customerIdFk;
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
    @Column(name = "ACCOUNT_TYPE")
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "AVAIL_BAL")
    public BigInteger getAvailBal() {
        return availBal;
    }

    public void setAvailBal(BigInteger availBal) {
        this.availBal = availBal;
    }

    @Basic
    @Column(name = "ACTUAL_BAL")
    public BigInteger getActualBal() {
        return actualBal;
    }

    public void setActualBal(BigInteger actualBal) {
        this.actualBal = actualBal;
    }

    @Basic
    @Column(name = "LOAN_ID")
    public BigInteger getLoanId() {
        return loanId;
    }

    public void setLoanId(BigInteger loanId) {
        this.loanId = loanId;
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
    @Column(name = "STATUS")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerAccount that = (CustomerAccount) o;
        return accountId == that.accountId && customerIdFk == that.customerIdFk && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(accountType, that.accountType) && Objects.equals(availBal, that.availBal) && Objects.equals(actualBal, that.actualBal) && Objects.equals(loanId, that.loanId) && Objects.equals(intrash, that.intrash) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, customerIdFk, dateCreated, accountType, availBal, actualBal, loanId, intrash, status);
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID_FK", referencedColumnName = "CUSTOMER_ID", nullable = false, insertable=false, updatable=false)
    public Customer getCustomerByCustomerIdFk() {
        return customerByCustomerIdFk;
    }

    public void setCustomerByCustomerIdFk(Customer customerByCustomerIdFk) {
        this.customerByCustomerIdFk = customerByCustomerIdFk;
    }
}
