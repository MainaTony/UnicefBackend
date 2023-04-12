package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "SCORE_CATEGORY")
public class ScoreCategory {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCORE_CATEGORY_SEQ")
//    @SequenceGenerator(name = "SCORE_CATEGORY_SEQ", sequenceName = "SCORE_CATEGORY_SEQ", allocationSize = 1)
    @Column(name = "SCORE_CATEGORY_ID")
    private BigInteger id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "PRODUCT_ID_FK")
    private BigInteger productIdFk;
    @Basic
    @Column(name = "CONTRIBUTION")
    private BigInteger contribution;
    @Basic
    @Column(name = "USED")
    private String used;
    @Basic
    @Column(name = "SC_MASTER_ID_FK")
    private BigInteger scMasterIdFk;
    @Basic
    @Column(name = "APPROVAL_STATUS")
    private BigInteger approvalStatus;
    @Basic
    @Column(name = "APPROVAL_LEVEL")
    private BigInteger approvalLevel;
    @Basic
    @Column(name = "MAX_APPROVALS")
    private BigInteger maxApprovals;
    @Basic
    @Column(name = "UPDATE_CYCLE")
    private BigInteger updateCycle;
    @Basic
    @Column(name = "INTRASH")
    private String intrash;
    /*private Collection<ScoreParam> scoreParamsById;
    private ScoreCategoryMaster scoreCategoryMasterByScMasterIdFk;*/


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public BigInteger getProductIdFk() {
        return productIdFk;
    }

    public void setProductIdFk(BigInteger productIdFk) {
        this.productIdFk = productIdFk;
    }


    public BigInteger getContribution() {
        return contribution;
    }

    public void setContribution(BigInteger contribution) {
        this.contribution = contribution;
    }


    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }


    public BigInteger getScMasterIdFk() {
        return scMasterIdFk;
    }

    public void setScMasterIdFk(BigInteger scMasterIdFk) {
        this.scMasterIdFk = scMasterIdFk;
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


    public BigInteger getMaxApprovals() {
        return maxApprovals;
    }

    public void setMaxApprovals(BigInteger maxApprovals) {
        this.maxApprovals = maxApprovals;
    }


    public BigInteger getUpdateCycle() {
        return updateCycle;
    }

    public void setUpdateCycle(BigInteger updateCycle) {
        this.updateCycle = updateCycle;
    }


    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreCategory that = (ScoreCategory) o;
        return id == that.id && productIdFk == that.productIdFk && scMasterIdFk == that.scMasterIdFk && Objects.equals(name, that.name) && Objects.equals(contribution, that.contribution) && Objects.equals(used, that.used) && Objects.equals(approvalStatus, that.approvalStatus) && Objects.equals(approvalLevel, that.approvalLevel) && Objects.equals(maxApprovals, that.maxApprovals) && Objects.equals(updateCycle, that.updateCycle) && Objects.equals(intrash, that.intrash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productIdFk, contribution, used, scMasterIdFk, approvalStatus, approvalLevel, maxApprovals, updateCycle, intrash);
    }

    /*@OneToMany(mappedBy = "scoreCategoryByScoreCategoryIdFk")
    public Collection<ScoreParam> getScoreParamsById() {
        return scoreParamsById;
    }

    public void setScoreParamsById(Collection<ScoreParam> scoreParamsById) {
        this.scoreParamsById = scoreParamsById;
    }

    @ManyToOne
    @JoinColumn(name = "SC_MASTER_ID_FK", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    public ScoreCategoryMaster getScoreCategoryMasterByScMasterIdFk() {
        return scoreCategoryMasterByScMasterIdFk;
    }

    public void setScoreCategoryMasterByScMasterIdFk(ScoreCategoryMaster scoreCategoryMasterByScMasterIdFk) {
        this.scoreCategoryMasterByScMasterIdFk = scoreCategoryMasterByScMasterIdFk;
    }*/
}
