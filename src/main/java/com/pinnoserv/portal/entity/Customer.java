package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customer {
    private BigInteger customerId;
    private BigInteger organisationIdFk;
    private String firstName;
    private String middleName;
    private String lastName;
    private String idNumber;
    private String email;
    private String msisdn;
    private String accountNumber;
    private String pin;
    private String pinStatus;
    private String activeStatus;
    private Timestamp dateCreated;
    private String intrash;
    private String password;
    private Boolean changePassword;
    private String trxChannel;
    private String userIdFk;
    private Timestamp lastLoginChange;
    private Timestamp lastPasswordChange;
    private Boolean locked;
    private boolean approvalStatus;
    private BigInteger approvalLevel;
    private BigInteger maxApprovals;
    private BigInteger createdBy;
    private String customerType;
    private Boolean badCustomer;
    private String regOnCbs;
    private String country;
    private String city;
    private String street;
    private String gender;
    private String yob;
    private BigInteger updateCycle;
    private Boolean creditScoreStatus;
    private String isNew;
    private Organisation organisationByOrganisationIdFk;
    private Collection<CustomerAccount> customerAccountsByCustomerId;
    private Collection<CustomerSubscription> customerSubscriptionsByCustomerId;
    private Collection<Loan> loansByCustomerId;
    private Collection<Transaction> transactionsByCustomerId;

    @Id
    @Column(name = "CUSTOMER_ID")
    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "ORGANISATION_ID_FK")
    public BigInteger getOrganisationIdFk() {
        return organisationIdFk;
    }

    public void setOrganisationIdFk(BigInteger organisationIdFk) {
        this.organisationIdFk = organisationIdFk;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "MIDDLE_NAME")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "ID_NUMBER")
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "MSISDN")
    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Basic
    @Column(name = "ACCOUNT_NUMBER")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "PIN")
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Basic
    @Column(name = "PIN_STATUS")
    public String getPinStatus() {
        return pinStatus;
    }

    public void setPinStatus(String pinStatus) {
        this.pinStatus = pinStatus;
    }

    @Basic
    @Column(name = "ACTIVE_STATUS")
    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
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
    @Column(name = "INTRASH")
    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "CHANGE_PASSWORD")
    public Boolean getChangePassword() {
        return changePassword;
    }

    public void setChangePassword(Boolean changePassword) {
        this.changePassword = changePassword;
    }

    @Basic
    @Column(name = "TRX_CHANNEL")
    public String getTrxChannel() {
        return trxChannel;
    }

    public void setTrxChannel(String trxChannel) {
        this.trxChannel = trxChannel;
    }

    @Basic
    @Column(name = "USER_ID_FK")
    public String getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(String userIdFk) {
        this.userIdFk = userIdFk;
    }

    @Basic
    @Column(name = "LAST_LOGIN_CHANGE")
    public Timestamp getLastLoginChange() {
        return lastLoginChange;
    }

    public void setLastLoginChange(Timestamp lastLoginChange) {
        this.lastLoginChange = lastLoginChange;
    }

    @Basic
    @Column(name = "LAST_PASSWORD_CHANGE")
    public Timestamp getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(Timestamp lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    @Basic
    @Column(name = "LOCKED")
    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Basic
    @Column(name = "APPROVAL_STATUS")
    public boolean isApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Basic
    @Column(name = "APPROVAL_LEVEL")
    public BigInteger getApprovalLevel() {
        return approvalLevel;
    }

    public void setApprovalLevel(BigInteger approvalLevel) {
        this.approvalLevel = approvalLevel;
    }

    @Basic
    @Column(name = "MAX_APPROVALS")
    public BigInteger getMaxApprovals() {
        return maxApprovals;
    }

    public void setMaxApprovals(BigInteger maxApprovals) {
        this.maxApprovals = maxApprovals;
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
    @Column(name = "CUSTOMER_TYPE")
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Basic
    @Column(name = "BAD_CUSTOMER")
    public Boolean getBadCustomer() {
        return badCustomer;
    }

    public void setBadCustomer(Boolean badCustomer) {
        this.badCustomer = badCustomer;
    }

    @Basic
    @Column(name = "REG_ON_CBS")
    public String getRegOnCbs() {
        return regOnCbs;
    }

    public void setRegOnCbs(String regOnCbs) {
        this.regOnCbs = regOnCbs;
    }

    @Basic
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "GENDER")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "YOB")
    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
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
    @Column(name = "CREDIT_SCORE_STATUS")
    public Boolean getCreditScoreStatus() {
        return creditScoreStatus;
    }

    public void setCreditScoreStatus(Boolean creditScoreStatus) {
        this.creditScoreStatus = creditScoreStatus;
    }

    @Basic
    @Column(name = "IS_NEW")
    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && organisationIdFk == customer.organisationIdFk && approvalStatus == customer.approvalStatus && Objects.equals(firstName, customer.firstName) && Objects.equals(middleName, customer.middleName) && Objects.equals(lastName, customer.lastName) && Objects.equals(idNumber, customer.idNumber) && Objects.equals(email, customer.email) && Objects.equals(msisdn, customer.msisdn) && Objects.equals(accountNumber, customer.accountNumber) && Objects.equals(pin, customer.pin) && Objects.equals(pinStatus, customer.pinStatus) && Objects.equals(activeStatus, customer.activeStatus) && Objects.equals(dateCreated, customer.dateCreated) && Objects.equals(intrash, customer.intrash) && Objects.equals(password, customer.password) && Objects.equals(changePassword, customer.changePassword) && Objects.equals(trxChannel, customer.trxChannel) && Objects.equals(userIdFk, customer.userIdFk) && Objects.equals(lastLoginChange, customer.lastLoginChange) && Objects.equals(lastPasswordChange, customer.lastPasswordChange) && Objects.equals(locked, customer.locked) && Objects.equals(approvalLevel, customer.approvalLevel) && Objects.equals(maxApprovals, customer.maxApprovals) && Objects.equals(createdBy, customer.createdBy) && Objects.equals(customerType, customer.customerType) && Objects.equals(badCustomer, customer.badCustomer) && Objects.equals(regOnCbs, customer.regOnCbs) && Objects.equals(country, customer.country) && Objects.equals(city, customer.city) && Objects.equals(street, customer.street) && Objects.equals(gender, customer.gender) && Objects.equals(yob, customer.yob) && Objects.equals(updateCycle, customer.updateCycle) && Objects.equals(creditScoreStatus, customer.creditScoreStatus) && Objects.equals(isNew, customer.isNew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, organisationIdFk, firstName, middleName, lastName, idNumber, email, msisdn, accountNumber, pin, pinStatus, activeStatus, dateCreated, intrash, password, changePassword, trxChannel, userIdFk, lastLoginChange, lastPasswordChange, locked, approvalStatus, approvalLevel, maxApprovals, createdBy, customerType, badCustomer, regOnCbs, country, city, street, gender, yob, updateCycle, creditScoreStatus, isNew);
    }

    @ManyToOne
    @JoinColumn(name = "ORGANISATION_ID_FK", referencedColumnName = "ORGANISATION_ID", nullable = false, insertable=false, updatable=false)
    public Organisation getOrganisationByOrganisationIdFk() {
        return organisationByOrganisationIdFk;
    }

    public void setOrganisationByOrganisationIdFk(Organisation organisationByOrganisationIdFk) {
        this.organisationByOrganisationIdFk = organisationByOrganisationIdFk;
    }

    @OneToMany(mappedBy = "customerByCustomerIdFk")
    public Collection<CustomerAccount> getCustomerAccountsByCustomerId() {
        return customerAccountsByCustomerId;
    }

    public void setCustomerAccountsByCustomerId(Collection<CustomerAccount> customerAccountsByCustomerId) {
        this.customerAccountsByCustomerId = customerAccountsByCustomerId;
    }

    @OneToMany(mappedBy = "customerByCustomerIdFk")
    public Collection<CustomerSubscription> getCustomerSubscriptionsByCustomerId() {
        return customerSubscriptionsByCustomerId;
    }

    public void setCustomerSubscriptionsByCustomerId(Collection<CustomerSubscription> customerSubscriptionsByCustomerId) {
        this.customerSubscriptionsByCustomerId = customerSubscriptionsByCustomerId;
    }

    @OneToMany(mappedBy = "customerByCustomerIdFk")
    public Collection<Loan> getLoansByCustomerId() {
        return loansByCustomerId;
    }

    public void setLoansByCustomerId(Collection<Loan> loansByCustomerId) {
        this.loansByCustomerId = loansByCustomerId;
    }

    @OneToMany(mappedBy = "customerByCustomerIdFk")
    public Collection<Transaction> getTransactionsByCustomerId() {
        return transactionsByCustomerId;
    }

    public void setTransactionsByCustomerId(Collection<Transaction> transactionsByCustomerId) {
        this.transactionsByCustomerId = transactionsByCustomerId;
    }
}
