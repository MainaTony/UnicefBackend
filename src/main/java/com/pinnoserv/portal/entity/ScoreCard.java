package com.pinnoserv.portal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "score_card")
public class ScoreCard {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "score_param_id_fk")
    private int scoreParamIdFk;
    @Column(name = "data_column")
    private String dataColumn;
    @Column(name = "criteria")
    private String criteria;
    @Column(name = "data_source_id_fk")
    private int dataSourceIdFk;
    @Column(name = "approval_status")
    private int approvalStatus;
    @Column(name = "approval_level")
    private int approvalLevel;
    @Column(name = "max_approvals")
    private int maxApprovals;
    @Column(name = "update_cycle")
    private int updateCycle;
    @Column(name = "in_trash")
    private String inTrash;
    /*private ScoreParam scoreParamByScoreParamIdFk;
    private DataSource dataSourceByDataSourceIdFk;*/

//    @Id
//    @Basic(optional = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCORE_CARD_SEQ")
//    @SequenceGenerator(name = "SCORE_CARD_SEQ", sequenceName = "SCORE_CARD_SEQ", allocationSize = 1)
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
//    @Column(name = "SCORE_PARAM_ID_FK")
//    public BigInteger getScoreParamIdFk() {
//        return scoreParamIdFk;
//    }
//
//    public void setScoreParamIdFk(BigInteger scoreParamIdFk) {
//        this.scoreParamIdFk = scoreParamIdFk;
//    }
//
//    @Basic
//    @Column(name = "DATA_COLUMN")
//    public String getDataColumn() {
//        return dataColumn;
//    }
//
//    public void setDataColumn(String dataColumn) {
//        this.dataColumn = dataColumn;
//    }
//
//    @Basic
//    @Column(name = "CRITERIA")
//    public String getCriteria() {
//        return criteria;
//    }
//
//    public void setCriteria(String criteria) {
//        this.criteria = criteria;
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
//        ScoreCard scoreCard = (ScoreCard) o;
//        return id == scoreCard.id && scoreParamIdFk == scoreCard.scoreParamIdFk && dataSourceIdFk == scoreCard.dataSourceIdFk && Objects.equals(dataColumn, scoreCard.dataColumn) && Objects.equals(criteria, scoreCard.criteria) && Objects.equals(approvalStatus, scoreCard.approvalStatus) && Objects.equals(approvalLevel, scoreCard.approvalLevel) && Objects.equals(maxApprovals, scoreCard.maxApprovals) && Objects.equals(updateCycle, scoreCard.updateCycle) && Objects.equals(intrash, scoreCard.intrash);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, scoreParamIdFk, dataColumn, criteria, dataSourceIdFk, approvalStatus, approvalLevel, maxApprovals, updateCycle, intrash);
//    }

    /*@ManyToOne
    @JoinColumn(name = "SCORE_PARAM_ID_FK", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    public ScoreParam getScoreParamByScoreParamIdFk() {
        return scoreParamByScoreParamIdFk;
    }

    public void setScoreParamByScoreParamIdFk(ScoreParam scoreParamByScoreParamIdFk) {
        this.scoreParamByScoreParamIdFk = scoreParamByScoreParamIdFk;
    }

    @ManyToOne
    @JoinColumn(name = "DATA_SOURCE_ID_FK", referencedColumnName = "DATA_SOURCE_ID", nullable = false, insertable = false, updatable = false)
    public DataSource getDataSourceByDataSourceIdFk() {
        return dataSourceByDataSourceIdFk;
    }

    public void setDataSourceByDataSourceIdFk(DataSource dataSourceByDataSourceIdFk) {
        this.dataSourceByDataSourceIdFk = dataSourceByDataSourceIdFk;
    }*/
}
