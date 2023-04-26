//package com.pinnoserv.portal.view;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.math.BigInteger;
//import java.sql.Date;
//import java.util.Objects;
//
//@Entity
//@Table(name = "PROGRAM_VIEW")
//public class ProgramView {
//    private BigInteger programId;
//    private String organisation;
//    private String name;
//    private String primaryIdentityType;
//    private Date dateCreated;
//    private String createdBy;
//    private String intrash;
//    private String status;
//    private String dataSource;
//    private String description;
//    private BigInteger organisationId;
//    private BigInteger dataSourceIdFk;
//
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "PROGRAM_ID")
//    public BigInteger getProgramId() {
//        return programId;
//    }
//
//    public void setProgramId(BigInteger programId) {
//        this.programId = programId;
//    }
//
//    @Basic
//    @Column(name = "ORGANISATION")
//    public String getOrganisation() {
//        return organisation;
//    }
//
//    public void setOrganisation(String organisation) {
//        this.organisation = organisation;
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
//    @Column(name = "PRIMARY_IDENTITY_TYPE")
//    public String getPrimaryIdentityType() {
//        return primaryIdentityType;
//    }
//
//    public void setPrimaryIdentityType(String primaryIdentityType) {
//        this.primaryIdentityType = primaryIdentityType;
//    }
//
//    @Basic
//    @Column(name = "DATE_CREATED")
//    public Date getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    @Basic
//    @Column(name = "CREATED_BY")
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
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
//    @Basic
//    @Column(name = "STATUS")
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    @Basic
//    @Column(name = "DATA_SOURCE")
//    public String getDataSource() {
//        return dataSource;
//    }
//
//    public void setDataSource(String dataSource) {
//        this.dataSource = dataSource;
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
//    @Column(name = "DATA_SOURCE_ID_FK")
//    public BigInteger getDataSourceIdFk() {
//        return dataSourceIdFk;
//    }
//
//    public void setDataSourceIdFk(BigInteger dataSourceIdFk) {
//        this.dataSourceIdFk = dataSourceIdFk;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ProgramView that = (ProgramView) o;
//        return programId == that.programId && Objects.equals(organisation, that.organisation) && Objects.equals(name, that.name) && Objects.equals(primaryIdentityType, that.primaryIdentityType) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(createdBy, that.createdBy) && Objects.equals(intrash, that.intrash) && Objects.equals(status, that.status) && Objects.equals(dataSource, that.dataSource) && Objects.equals(description, that.description);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(programId, organisation, name, primaryIdentityType, dateCreated, createdBy, intrash, status, dataSource, description);
//    }
//}
