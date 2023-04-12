package com.pinnoserv.portal.view;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "DATA_SOURCE_VIEW")
public class DataSourceView {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_SOURCE_ID")
    private BigInteger dataSourceId;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "DATA_SOURCE_URL")
    private String dataSourceUrl;
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
    @Column(name = "EXCEL_URL")
    private String excelUrl;
    @Basic
    @Column(name = "DATA_SOURCE_TYPE")
    private String dataSourceType;
    @Basic
    @Column(name = "DATA_USAGE")
    private String dataUsage;
    @Basic
    @Column(name = "STATUS")
    private String status;
    @Basic
    @Column(name = "ACTION")
    private String action;
    @Basic
    @Column(name = "EXCEL_PATH")
    private String excelPath;
    @Basic
    @Column(name = "EXPIRY")
    private Date expiry;
    @Basic
    @Column(name = "KYC_ID")
    private BigInteger kycId;
    @Basic
    @Column(name = "MAX_APPROVALS")
    private BigInteger maxApprovals;
    @Basic
    @Column(name = "APPROVAL_STATUS")
    private BigInteger approvalStatus;
    @Basic
    @Column(name = "APPROVAL_LEVEL")
    private BigInteger approvalLevel;
    @Basic
    @Column(name = "UPDATE_CYCLE")
    private BigInteger updateCycle;
    @Basic
    @Column(name = "SCORING_DATA_SIZE")
    private BigInteger scoringDataSize;
    @Basic
    @Column(name = "ORGANISATION")
    private String organisation;
    @Basic
    @Column(name = "ORGANISATION_ID_FK")
    private BigInteger organisationIdFk;


    public BigInteger getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(BigInteger dataSourceId) {
        this.dataSourceId = dataSourceId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public void setDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl;
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


    public String getExcelUrl() {
        return excelUrl;
    }

    public void setExcelUrl(String excelUrl) {
        this.excelUrl = excelUrl;
    }


    public String getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }


    public String getDataUsage() {
        return dataUsage;
    }

    public void setDataUsage(String dataUsage) {
        this.dataUsage = dataUsage;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public String getExcelPath() {
        return excelPath;
    }

    public void setExcelPath(String excelPath) {
        this.excelPath = excelPath;
    }


    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }


    public BigInteger getKycId() {
        return kycId;
    }

    public void setKycId(BigInteger kycId) {
        this.kycId = kycId;
    }


    public BigInteger getMaxApprovals() {
        return maxApprovals;
    }

    public void setMaxApprovals(BigInteger maxApprovals) {
        this.maxApprovals = maxApprovals;
    }


    public BigInteger getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(BigInteger approvalStatus) {
        this.approvalStatus = approvalStatus;
    }


    public BigInteger getApprovalLevel() {
        return approvalLevel;
    }

    public void setApprovalLevel(BigInteger approvalLevel) {
        this.approvalLevel = approvalLevel;
    }


    public BigInteger getUpdateCycle() {
        return updateCycle;
    }

    public void setUpdateCycle(BigInteger updateCycle) {
        this.updateCycle = updateCycle;
    }


    public BigInteger getScoringDataSize() {
        return scoringDataSize;
    }

    public void setScoringDataSize(BigInteger scoringDataSize) {
        this.scoringDataSize = scoringDataSize;
    }


    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }


    public BigInteger getOrganisationIdFk() {
        return organisationIdFk;
    }

    public void setOrganisationIdFk(BigInteger organisationIdFk) {
        this.organisationIdFk = organisationIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSourceView that = (DataSourceView) o;
        return dataSourceId == that.dataSourceId && scoringDataSize == that.scoringDataSize && organisationIdFk == that.organisationIdFk && Objects.equals(name, that.name) && Objects.equals(dataSourceUrl, that.dataSourceUrl) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(createdBy, that.createdBy) && Objects.equals(intrash, that.intrash) && Objects.equals(excelUrl, that.excelUrl) && Objects.equals(dataSourceType, that.dataSourceType) && Objects.equals(dataUsage, that.dataUsage) && Objects.equals(status, that.status) && Objects.equals(action, that.action) && Objects.equals(excelPath, that.excelPath) && Objects.equals(expiry, that.expiry) && Objects.equals(kycId, that.kycId) && Objects.equals(maxApprovals, that.maxApprovals) && Objects.equals(approvalStatus, that.approvalStatus) && Objects.equals(approvalLevel, that.approvalLevel) && Objects.equals(updateCycle, that.updateCycle) && Objects.equals(organisation, that.organisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataSourceId, name, dataSourceUrl, dateCreated, createdBy, intrash, excelUrl, dataSourceType, dataUsage, status, action, excelPath, expiry, kycId, maxApprovals, approvalStatus, approvalLevel, updateCycle, scoringDataSize, organisation, organisationIdFk);
    }
}
