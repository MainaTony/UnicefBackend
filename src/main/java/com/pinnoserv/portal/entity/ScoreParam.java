package com.pinnoserv.portal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "score_param")
public class ScoreParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "data_type")
    private String dataType;
    @Column(name = "data_source")
    private String dataSource;
    @Column(name = "computation")
    private String computation;
    @Column(name = "score_category_id")
    private Long scoreCategoryIdFk;
    @Column(name = "master_param_id")
    private Long masterParamIdFk;
    @Column(name = "percentage_value")
    private BigInteger percentageValue;
    @Column(name = "approval_status")
    private BigInteger approvalStatus;
    @Column(name = "approval_level")
    private BigInteger approvalLevel;
    @Column(name = "max_approvals")
    private BigInteger maxApprovals;
    @Column(name = "update_cycle")
    private BigInteger updateCycle;
    @Column(name = "in_trash")
    private String inTrash;
    /*private ScoreCategory scoreCategoryByScoreCategoryIdFk;
    private ScoreParamMaster scoreParamMasterByMasterParamIdFk;
    private Collection<ScoreCard> scoreCardsById;*/

//    @Id
//    @Basic(optional = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCORE_PARAM_SEQ")
//    @SequenceGenerator(name = "SCORE_PARAM_SEQ", sequenceName = "SCORE_PARAM_SEQ", allocationSize = 1)
//    @Column(name = "ID")
//    public BigInteger getId() {
//        return id;
//    }
//
//    public void setId(BigInteger id) {
//        this.id = id;
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
//    @Column(name = "DATA_TYPE")
//    public String getDataType() {
//        return dataType;
//    }
//
//    public void setDataType(String dataType) {
//        this.dataType = dataType;
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
//    @Column(name = "COMPUTATION")
//    public String getComputation() {
//        return computation;
//    }
//
//    public void setComputation(String computation) {
//        this.computation = computation;
//    }
//
//    @Basic
//    @Column(name = "SCORE_CATEGORY_ID_FK")
//    public BigInteger getScoreCategoryIdFk() {
//        return scoreCategoryIdFk;
//    }
//
//    public void setScoreCategoryIdFk(BigInteger scoreCategoryIdFk) {
//        this.scoreCategoryIdFk = scoreCategoryIdFk;
//    }
//
//    @Basic
//    @Column(name = "MASTER_PARAM_ID_FK")
//    public BigInteger getMasterParamIdFk() {
//        return masterParamIdFk;
//    }
//
//    public void setMasterParamIdFk(BigInteger masterParamIdFk) {
//        this.masterParamIdFk = masterParamIdFk;
//    }
//
//    @Basic
//    @Column(name = "PERCENTAGE_VALUE")
//    public BigInteger getPercentageValue() {
//        return percentageValue;
//    }
//
//    public void setPercentageValue(BigInteger percentageValue) {
//        this.percentageValue = percentageValue;
//    }
//
//    @Basic
//    @Column(name = "APPROVAL_STATUS")
//    public BigInteger getApprovalStatus() {
//        return approvalStatus;
//    }
//
//    public void setApprovalStatus(BigInteger approvalStatus) {
//        this.approvalStatus = approvalStatus;
//    }
//
//    @Basic
//    @Column(name = "APPROVAL_LEVEL")
//    public BigInteger getApprovalLevel() {
//        return approvalLevel;
//    }
//
//    public void setApprovalLevel(BigInteger approvalLevel) {
//        this.approvalLevel = approvalLevel;
//    }
//
//    @Basic
//    @Column(name = "MAX_APPROVALS")
//    public BigInteger getMaxApprovals() {
//        return maxApprovals;
//    }
//
//    public void setMaxApprovals(BigInteger maxApprovals) {
//        this.maxApprovals = maxApprovals;
//    }
//
//    @Basic
//    @Column(name = "UPDATE_CYCLE")
//    public BigInteger getUpdateCycle() {
//        return updateCycle;
//    }
//
//    public void setUpdateCycle(BigInteger updateCycle) {
//        this.updateCycle = updateCycle;
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
//        ScoreParam that = (ScoreParam) o;
//        return id == that.id && scoreCategoryIdFk == that.scoreCategoryIdFk && masterParamIdFk == that.masterParamIdFk && Objects.equals(name, that.name) && Objects.equals(dataType, that.dataType) && Objects.equals(dataSource, that.dataSource) && Objects.equals(computation, that.computation) && Objects.equals(percentageValue, that.percentageValue) && Objects.equals(approvalStatus, that.approvalStatus) && Objects.equals(approvalLevel, that.approvalLevel) && Objects.equals(maxApprovals, that.maxApprovals) && Objects.equals(updateCycle, that.updateCycle) && Objects.equals(intrash, that.intrash);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, dataType, dataSource, computation, scoreCategoryIdFk, masterParamIdFk, percentageValue, approvalStatus, approvalLevel, maxApprovals, updateCycle, intrash);
//    }

    /*@ManyToOne
    @JoinColumn(name = "SCORE_CATEGORY_ID_FK", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    public ScoreCategory getScoreCategoryByScoreCategoryIdFk() {
        return scoreCategoryByScoreCategoryIdFk;
    }

    public void setScoreCategoryByScoreCategoryIdFk(ScoreCategory scoreCategoryByScoreCategoryIdFk) {
        this.scoreCategoryByScoreCategoryIdFk = scoreCategoryByScoreCategoryIdFk;
    }

    @ManyToOne
    @JoinColumn(name = "MASTER_PARAM_ID_FK", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    public ScoreParamMaster getScoreParamMasterByMasterParamIdFk() {
        return scoreParamMasterByMasterParamIdFk;
    }

    public void setScoreParamMasterByMasterParamIdFk(ScoreParamMaster scoreParamMasterByMasterParamIdFk) {
        this.scoreParamMasterByMasterParamIdFk = scoreParamMasterByMasterParamIdFk;
    }

    @OneToMany(mappedBy = "scoreParamByScoreParamIdFk")
    public Collection<ScoreCard> getScoreCardsById() {
        return scoreCardsById;
    }

    public void setScoreCardsById(Collection<ScoreCard> scoreCardsById) {
        this.scoreCardsById = scoreCardsById;
    }*/
}
