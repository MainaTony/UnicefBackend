package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class Users {
    private BigInteger id;
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private BigInteger organisationIdFk;
    private Date dateCreated;
    private Timestamp lastLoginChange;
    private Timestamp lastPasswordChange;
    private BigInteger status;
    private String idNumber;
    private BigInteger msisdn;
    private String intrash;
    private String email;
    private BigInteger createdBy;
    private String validationCode;
    private BigInteger locked;
    //private Organisation organisationByOrganisationIdFk;

    @Id
    @Column(name = "ID")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "DATE_CREATED")
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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
    @Column(name = "STATUS")
    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
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
    @Column(name = "MSISDN")
    public BigInteger getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(BigInteger msisdn) {
        this.msisdn = msisdn;
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
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "VALIDATION_CODE")
    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    @Basic
    @Column(name = "LOCKED")
    public BigInteger getLocked() {
        return locked;
    }

    public void setLocked(BigInteger locked) {
        this.locked = locked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users user = (Users) o;
        return id == user.id && organisationIdFk == user.organisationIdFk && Objects.equals(username, user.username) && Objects.equals(firstName, user.firstName) && Objects.equals(middleName, user.middleName) && Objects.equals(lastName, user.lastName) && Objects.equals(password, user.password) && Objects.equals(dateCreated, user.dateCreated) && Objects.equals(lastLoginChange, user.lastLoginChange) && Objects.equals(lastPasswordChange, user.lastPasswordChange) && Objects.equals(status, user.status) && Objects.equals(idNumber, user.idNumber) && Objects.equals(msisdn, user.msisdn) && Objects.equals(intrash, user.intrash) && Objects.equals(email, user.email) && Objects.equals(createdBy, user.createdBy) && Objects.equals(validationCode, user.validationCode) && Objects.equals(locked, user.locked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, middleName, lastName, password, organisationIdFk, dateCreated, lastLoginChange, lastPasswordChange, status, idNumber, msisdn, intrash, email, createdBy, validationCode, locked);
    }

    /*@ManyToOne
    @JoinColumn(name = "ORGANISATION_ID_FK", referencedColumnName = "ORGANISATION_ID", nullable = false, insertable=false, updatable=false)
    public Organisation getOrganisationByOrganisationIdFk() {
        return organisationByOrganisationIdFk;
    }

    public void setOrganisationByOrganisationIdFk(Organisation organisationByOrganisationIdFk) {
        this.organisationByOrganisationIdFk = organisationByOrganisationIdFk;
    }*/
}
