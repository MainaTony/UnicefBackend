package com.pinnoserv.portal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "data_source")
public class DataSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "datasource_code")
    private Integer datasourceCode;
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "data_source_url")
    private String dataSourceUrl;
    @CreatedDate
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "inTrash")
    private String inTrash;

    @Column(name = "excel_url")
    private String excelUrl;

    @Column(name = "data_source_type")
    private String dataSourceType;

    @Column(name = "data_usage")
    private String dataUsage;

    @Column(name = "status")
    private Integer status;

    @Column(name = "action")
    private String action;

    @Column(name = "excel_path")
    private String excelPath;

    @Column(name = "expiry")
    private String expiry;

    @Column(name = "kyc_id")
    private int kycId;

    @Column(name = "max_approvals")
    private int maxApprovals;

    @Column(name = "approval_status")
    private int approvalStatus;

    @Column(name = "approval_level")
    private int approvalLevel;

    @Column(name = "update_cycle")
    private int updateCycle;

    @Column(name = "scoring_data_size")
    private int scoringDataSize;

    @Column(name = "organisation_id_fk")
    private int organisationIdFk;
    //private Collection<DataSourceMapping> dataSourceMappingsByDataSourceId;
    //private Collection<Program> programsByDataSourceId;


//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DATA_SOURCE_SEQ")
//    @SequenceGenerator(name = "DATA_SOURCE_SEQ", sequenceName = "DATA_SOURCE_SEQ", allocationSize = 1)

//    public Integer getDataSourceId() {
//        return dataSourceId;
//    }
//
//    public void setDataSourceId(Integer dataSourceId) {
//        this.dataSourceId = dataSourceId;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public String getDataSourceUrl() {
//        return dataSourceUrl;
//    }
//
//    public void setDataSourceUrl(String dataSourceUrl) {
//        this.dataSourceUrl = dataSourceUrl;
//    }
//
//
//    public Date getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//
//    public Integer getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(Integer createdBy) {
//        this.createdBy = createdBy;
//    }
//
//
//    public String getIntrash() {
//        return intrash;
//    }
//
//    public void setIntrash(String intrash) {
//        this.intrash = intrash;
//    }
//
//
//    public String getExcelUrl() {
//        return excelUrl;
//    }
//
//    public void setExcelUrl(String excelUrl) {
//        this.excelUrl = excelUrl;
//    }
//
//
//    public String getDataSourceType() {
//        return dataSourceType;
//    }
//
//    public void setDataSourceType(String dataSourceType) {
//        this.dataSourceType = dataSourceType;
//    }
//
//
//    public String getDataUsage() {
//        return dataUsage;
//    }
//
//    public void setDataUsage(String dataUsage) {
//        this.dataUsage = dataUsage;
//    }
//
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//
//    public String getAction() {
//        return action;
//    }
//
//    public void setAction(String action) {
//        this.action = action;
//    }
//
//
//    public String getExcelPath() {
//        return excelPath;
//    }
//
//    public void setExcelPath(String excelPath) {
//        this.excelPath = excelPath;
//    }
//
//
//    public Date getExpiry() {
//        return expiry;
//    }
//
//    public void setExpiry(Date expiry) {
//        this.expiry = expiry;
//    }
//
//
//    public Integer getKycId() {
//        return kycId;
//    }
//
//    public void setKycId(Integer kycId) {
//        this.kycId = kycId;
//    }
//
//
//    public int getMaxApprovals() {
//        return maxApprovals;
//    }
//
//    public void setMaxApprovals(Integer maxApprovals) {
//        this.maxApprovals = maxApprovals;
//    }
//
//
//    public Integer getApprovalStatus() {
//        return approvalStatus;
//    }
//
//    public void setApprovalStatus(Integer approvalStatus) {
//        this.approvalStatus = approvalStatus;
//    }
//
//
//    public Integer getApprovalLevel() {
//        return approvalLevel;
//    }
//
//    public void setApprovalLevel(Integer approvalLevel) {
//        this.approvalLevel = approvalLevel;
//    }
//
//
//    public Integer getUpdateCycle() {
//        return updateCycle;
//    }
//
//    public void setUpdateCycle(Integer updateCycle) {
//        this.updateCycle = updateCycle;
//    }
//
//
//    public Integer getScoringDataSize() {
//        return scoringDataSize;
//    }
//
//    public void setScoringDataSize(Integer scoringDataSize) {
//        this.scoringDataSize = scoringDataSize;
//    }
//
//
//    public Integer getOrganisationIdFk() {
//        return organisationIdFk;
//    }
//
//    public void setOrganisationIdFk(Integer organisationIdFk) {
//        this.organisationIdFk = organisationIdFk;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        DataSource that = (DataSource) o;
//        return dataSourceId == that.dataSourceId && scoringDataSize == that.scoringDataSize && Objects.equals(name, that.name) && Objects.equals(dataSourceUrl, that.dataSourceUrl) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(createdBy, that.createdBy) && Objects.equals(intrash, that.intrash) && Objects.equals(excelUrl, that.excelUrl) && Objects.equals(dataSourceType, that.dataSourceType) && Objects.equals(dataUsage, that.dataUsage) && Objects.equals(status, that.status) && Objects.equals(action, that.action) && Objects.equals(excelPath, that.excelPath) && Objects.equals(expiry, that.expiry) && Objects.equals(kycId, that.kycId) && Objects.equals(maxApprovals, that.maxApprovals) && Objects.equals(approvalStatus, that.approvalStatus) && Objects.equals(approvalLevel, that.approvalLevel) && Objects.equals(updateCycle, that.updateCycle);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(dataSourceId, name, dataSourceUrl, dateCreated, createdBy, intrash, excelUrl, dataSourceType, dataUsage, status, action, excelPath, expiry, kycId, maxApprovals, approvalStatus, approvalLevel, updateCycle, scoringDataSize);
//    }

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
