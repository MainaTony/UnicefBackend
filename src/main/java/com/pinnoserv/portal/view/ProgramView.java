package com.pinnoserv.portal.view;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "PROGRAM_VIEW")
public class ProgramView {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROGRAM_ID")
    private Integer programId;
    @Basic
    @Column(name = "ORGANISATION")
    private String organisation;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "PRIMARY_IDENTITY_TYPE")
    private String primaryIdentityType;
    @Basic
    @Column(name = "DATE_CREATED")
    private Date dateCreated;
    @Basic
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Basic
    @Column(name = "INTRASH")
    private String intrash;
    @Basic
    @Column(name = "STATUS")
    private String status;
    @Basic
    @Column(name = "DATA_SOURCE")
    private String dataSource;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic
    @Column(name = "ORGANISATION_ID")
    private Integer organisationId;
    @Basic
    @Column(name = "DATA_SOURCE_ID_FK")
    private Integer dataSourceIdFk;


    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }


    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPrimaryIdentityType() {
        return primaryIdentityType;
    }

    public void setPrimaryIdentityType(String primaryIdentityType) {
        this.primaryIdentityType = primaryIdentityType;
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Integer organisationId) {
        this.organisationId = organisationId;
    }


    public Integer getDataSourceIdFk() {
        return dataSourceIdFk;
    }

    public void setDataSourceIdFk(Integer dataSourceIdFk) {
        this.dataSourceIdFk = dataSourceIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramView that = (ProgramView) o;
        return programId == that.programId && Objects.equals(organisation, that.organisation) && Objects.equals(name, that.name) && Objects.equals(primaryIdentityType, that.primaryIdentityType) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(createdBy, that.createdBy) && Objects.equals(intrash, that.intrash) && Objects.equals(status, that.status) && Objects.equals(dataSource, that.dataSource) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programId, organisation, name, primaryIdentityType, dateCreated, createdBy, intrash, status, dataSource, description);
    }
}
