package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER_SUBSCRIPTION")
public class CustomerSubscription {
    private BigInteger customerSubscriptionId;
    private BigInteger customerIdFk;
    private BigInteger programIdFk;
    private String primaryIdentity;
    private Date dateCreated;
    private String confirmationCode;
    private Boolean confirmationStatus;
    private String intrash;
    private Boolean status;
    private Customer customerByCustomerIdFk;
    private Program programByProgramIdFk;

    @Id
    @Column(name = "CUSTOMER_SUBSCRIPTION_ID")
    public BigInteger getCustomerSubscriptionId() {
        return customerSubscriptionId;
    }

    public void setCustomerSubscriptionId(BigInteger customerSubscriptionId) {
        this.customerSubscriptionId = customerSubscriptionId;
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
    @Column(name = "PROGRAM_ID_FK")
    public BigInteger getProgramIdFk() {
        return programIdFk;
    }

    public void setProgramIdFk(BigInteger programIdFk) {
        this.programIdFk = programIdFk;
    }

    @Basic
    @Column(name = "PRIMARY_IDENTITY")
    public String getPrimaryIdentity() {
        return primaryIdentity;
    }

    public void setPrimaryIdentity(String primaryIdentity) {
        this.primaryIdentity = primaryIdentity;
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
    @Column(name = "CONFIRMATION_CODE")
    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    @Basic
    @Column(name = "CONFIRMATION_STATUS")
    public Boolean getConfirmationStatus() {
        return confirmationStatus;
    }

    public void setConfirmationStatus(Boolean confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
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
        CustomerSubscription that = (CustomerSubscription) o;
        return customerSubscriptionId == that.customerSubscriptionId && customerIdFk == that.customerIdFk && programIdFk == that.programIdFk && Objects.equals(primaryIdentity, that.primaryIdentity) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(confirmationCode, that.confirmationCode) && Objects.equals(confirmationStatus, that.confirmationStatus) && Objects.equals(intrash, that.intrash) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerSubscriptionId, customerIdFk, programIdFk, primaryIdentity, dateCreated, confirmationCode, confirmationStatus, intrash, status);
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID_FK", referencedColumnName = "CUSTOMER_ID", nullable = false, insertable=false, updatable=false)
    public Customer getCustomerByCustomerIdFk() {
        return customerByCustomerIdFk;
    }

    public void setCustomerByCustomerIdFk(Customer customerByCustomerIdFk) {
        this.customerByCustomerIdFk = customerByCustomerIdFk;
    }

    @ManyToOne
    @JoinColumn(name = "PROGRAM_ID_FK", referencedColumnName = "PROGRAM_ID", nullable = false, insertable=false, updatable=false)
    public Program getProgramByProgramIdFk() {
        return programByProgramIdFk;
    }

    public void setProgramByProgramIdFk(Program programByProgramIdFk) {
        this.programByProgramIdFk = programByProgramIdFk;
    }
}
