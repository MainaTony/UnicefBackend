package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "DATA_SOURCE")
public class DataSource {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DATA_SOURCE_ID")
    private Integer dataSourceId;
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
    private Integer createdBy;
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
    private Integer status;
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
    private Integer kycId;
    @Basic
    @Column(name = "MAX_APPROVALS")
    private Integer maxApprovals;
    @Basic
    @Column(name = "APPROVAL_STATUS")
    private Integer approvalStatus;
    @Basic
    @Column(name = "APPROVAL_LEVEL")
    private Integer approvalLevel;
    @Basic
    @Column(name = "UPDATE_CYCLE")
    private Integer updateCycle;
    @Basic
    @Column(name = "SCORING_DATA_SIZE")
    private Integer scoringDataSize;
    @Basic
    @Column(name = "ORGANISATION_ID_FK")
    private Integer organisationIdFk;
    //private Collection<DataSourceMapping> dataSourceMappingsByDataSourceId;
    //private Collection<Program> programsByDataSourceId;


//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DATA_SOURCE_SEQ")
//    @SequenceGenerator(name = "DATA_SOURCE_SEQ", sequenceName = "DATA_SOURCE_SEQ", allocationSize = 1)

    public Integer getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(Integer dataSourceId) {
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


    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
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


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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


    public Integer getKycId() {
        return kycId;
    }

    public void setKycId(Integer kycId) {
        this.kycId = kycId;
    }


    public int getMaxApprovals() {
        return maxApprovals;
    }

    public void setMaxApprovals(Integer maxApprovals) {
        this.maxApprovals = maxApprovals;
    }


    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }


    public Integer getApprovalLevel() {
        return approvalLevel;
    }

    public void setApprovalLevel(Integer approvalLevel) {
        this.approvalLevel = approvalLevel;
    }


    public Integer getUpdateCycle() {
        return updateCycle;
    }

    public void setUpdateCycle(Integer updateCycle) {
        this.updateCycle = updateCycle;
    }


    public Integer getScoringDataSize() {
        return scoringDataSize;
    }

    public void setScoringDataSize(Integer scoringDataSize) {
        this.scoringDataSize = scoringDataSize;
    }


    public Integer getOrganisationIdFk() {
        return organisationIdFk;
    }

    public void setOrganisationIdFk(Integer organisationIdFk) {
        this.organisationIdFk = organisationIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSource that = (DataSource) o;
        return dataSourceId == that.dataSourceId && scoringDataSize == that.scoringDataSize && Objects.equals(name, that.name) && Objects.equals(dataSourceUrl, that.dataSourceUrl) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(createdBy, that.createdBy) && Objects.equals(intrash, that.intrash) && Objects.equals(excelUrl, that.excelUrl) && Objects.equals(dataSourceType, that.dataSourceType) && Objects.equals(dataUsage, that.dataUsage) && Objects.equals(status, that.status) && Objects.equals(action, that.action) && Objects.equals(excelPath, that.excelPath) && Objects.equals(expiry, that.expiry) && Objects.equals(kycId, that.kycId) && Objects.equals(maxApprovals, that.maxApprovals) && Objects.equals(approvalStatus, that.approvalStatus) && Objects.equals(approvalLevel, that.approvalLevel) && Objects.equals(updateCycle, that.updateCycle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataSourceId, name, dataSourceUrl, dateCreated, createdBy, intrash, excelUrl, dataSourceType, dataUsage, status, action, excelPath, expiry, kycId, maxApprovals, approvalStatus, approvalLevel, updateCycle, scoringDataSize);
    }

    /*@OneToMany(mappedBy = "dataSourceByDataSourceIdFk")
    public Collection<DataSourceMapping> getDataSourceMappingsByDataSourceId() {
        return dataSourceMappingsByDataSourceId;
    }

    public void setDataSourceMappingsByDataSourceId(Collection<DataSourceMapping> dataSourceMappingsByDataSourceId) {
        this.dataSourceMappingsByDataSourceId = dataSourceMappingsByDataSourceId;
    }

    @OneToMany(mappedBy = "dataSourceByDataSourceIdFk")
    public Collection<Program> getProgramsByDataSourceId() {
        return programsByDataSourceId;
    }

    public void setProgramsByDataSourceId(Collection<Program> programsByDataSourceId) {
        this.programsByDataSourceId = programsByDataSourceId;
    }*/
}
