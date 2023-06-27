package com.pinnoserv.portal.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Organisation")
public class Organisation {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "organisation_id")
    private Long organisationId;
    @Column(name = "Organisation_Name")
    private String organisationName;
    @Column(name = "Organisation_Code")
    private String organisationCode;
    @Column(name = "Business_Type")
    private int businessType;
    @Column(name = "Organisation_Address")
    private String organisationAddress;
    @Column(name = "Organisation_Phone")
    private String organisationPhone;
    @Column(name = "Organisation_Email")
    private String organisationEmail;
    @Column(name = "Date_Created")
    private LocalDateTime dateCreated;
    @Column(name = "Created_By")
    private int createdBy;
    @Column(name = "Status")
    private Boolean status;
    @Column(name = "In_trash")
    private String intrash;

//    private List<Product> product;
//    private Collection<Config> configsByOrganisationId;
//    private Collection<Customer> customersByOrganisationId;
//    private BusinessTypeModel businessTypeByBusinessTypeFkModel;
    //private Collection<Program> programsByOrganisationId;
    //private Collection<Users> usersByOrganisationId;

//    public Organisation() {
//    }
//
//    public Organisation(BigInteger organisationId) {
//        this.organisationId = organisationId;
//    }
//
//    @Id
//    @Column(name = "ORGANISATION_ID")
//    public BigInteger getOrganisationId() {
//        return organisationId;
//    }
//
//    public void setOrganisationId(BigInteger organisationId) {
//        this.organisationId = organisationId;
//    }
//
//    @Basic
//    @Column(name = "NAME")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Basic
//    @Column(name = "ORG_CODE")
//    public String getOrgCode() {
//        return orgCode;
//    }
//
//    public void setOrgCode(String orgCode) {
//        this.orgCode = orgCode;
//    }
//
//    @Basic
//    @Column(name = "BUSINESS_TYPE_FK")
//    public BigInteger getBusinessTypeFk() {
//        return businessTypeFk;
//    }
//
//    public void setBusinessTypeFk(BigInteger businessTypeFk) {
//        this.businessTypeFk = businessTypeFk;
//    }
//
//    @Basic
//    @Column(name = "PHYSICAL_ADDRESS")
//    public String getPhysicalAddress() {
//        return physicalAddress;
//    }
//
//    public void setPhysicalAddress(String physicalAddress) {
//        this.physicalAddress = physicalAddress;
//    }
//
//    @Basic
//    @Column(name = "MSISDN")
//    public String getMsisdn() {
//        return msisdn;
//    }
//
//    public void setMsisdn(String msisdn) {
//        this.msisdn = msisdn;
//    }
//
//    @Basic
//    @Column(name = "EMAIL_ADDRESS")
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }
//
//    @Basic
//    @Column(name = "DATE_CREATED")
//    public Timestamp getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Timestamp dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    @Basic
//    @Column(name = "CREATED_BY")
//    public BigInteger getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(BigInteger createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    @Basic
//    @Column(name = "STATUS")
//    public Boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }
//
//    @Basic
//    @Column(name = "INTRASH")
//    public String getIntrash() {
//        return intrash;
//    }
//
//    public void setIntrash(String intrash) {
//        this.intrash = intrash;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Organisation that = (Organisation) o;
//        return organisationId == that.organisationId && businessTypeFk == that.businessTypeFk && Objects.equals(name, that.name) && Objects.equals(orgCode, that.orgCode) && Objects.equals(physicalAddress, that.physicalAddress) && Objects.equals(msisdn, that.msisdn) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(createdBy, that.createdBy) && Objects.equals(status, that.status) && Objects.equals(intrash, that.intrash);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(organisationId, name, orgCode, businessTypeFk, physicalAddress, msisdn, emailAddress, dateCreated, createdBy, status, intrash);
//    }
//
//    @OneToMany(mappedBy = "organisationByOrgIdFk")
//    public Collection<Config> getConfigsByOrganisationId() {
//        return configsByOrganisationId;
//    }
//
//    public void setConfigsByOrganisationId(Collection<Config> configsByOrganisationId) {
//        this.configsByOrganisationId = configsByOrganisationId;
//    }
//
//    @OneToMany(mappedBy = "organisationByOrganisationIdFk")
//    public Collection<Customer> getCustomersByOrganisationId() {
//        return customersByOrganisationId;
//    }
//
//    public void setCustomersByOrganisationId(Collection<Customer> customersByOrganisationId) {
//        this.customersByOrganisationId = customersByOrganisationId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "BUSINESS_TYPE_FK", referencedColumnName = "ID", nullable = false, insertable=false, updatable=false)
//    public BusinessTypeModel getBusinessTypeByBusinessTypeFk() {
//        return businessTypeByBusinessTypeFkModel;
//    }
//
//    public void setBusinessTypeByBusinessTypeFk(BusinessTypeModel businessTypeByBusinessTypeFkModel) {
//        this.businessTypeByBusinessTypeFkModel = businessTypeByBusinessTypeFkModel;
//    }

    /*@OneToMany(mappedBy = "organisationByOrganisationIdFk")
    public Collection<Program> getProgramsByOrganisationId() {
        return programsByOrganisationId;
    }

    public void setProgramsByOrganisationId(Collection<Program> programsByOrganisationId) {
        this.programsByOrganisationId = programsByOrganisationId;
    }

    @OneToMany(mappedBy = "organisationByOrganisationIdFk")
    public Collection<Users> getUsersByOrganisationId() {
        return usersByOrganisationId;
    }

    public void setUsersByOrganisationId(Collection<Users> usersByOrganisationId) {
        this.usersByOrganisationId = usersByOrganisationId;
    }*/
}
