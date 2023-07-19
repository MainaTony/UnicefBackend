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
@Table(name = "score_category")
public class ScoreCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCORE_CATEGORY_SEQ")
//    @SequenceGenerator(name = "SCORE_CATEGORY_SEQ", sequenceName = "SCORE_CATEGORY_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "product_id")
    private int productIdFk;
    @Column(name = "contribution")
    private Double contribution;
    @Column(name = "used")
    private String used;
    @Column(name = "sc_master_id_fk")
    private int scMasterIdFk;
    @Column(name = "approval_status")
    private int approvalStatus;
    @Column(name = "approval_level")
    private int approvalLevel;
    @Column(name = "max_approvals")
    private int maxApprovals;
    @Column(name = "update_cycle")
    private Integer updateCycle;
    @Column(name = "in_trash")
    private String inTrash;
    /*private Collection<ScoreParam> scoreParamsById;
    private ScoreCategoryMaster scoreCategoryMasterByScMasterIdFk;*/

//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
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
//    public Integer getProductIdFk() {
//        return productIdFk;
//    }
//
//    public void setProductIdFk(Integer productIdFk) {
//        this.productIdFk = productIdFk;
//    }
//
//
//    public Double getContribution() {
//        return contribution;
//    }
//
//    public void setContribution(Double contribution) {
//        this.contribution = contribution;
//    }
//
//
//    public String getUsed() {
//        return used;
//    }
//
//    public void setUsed(String used) {
//        this.used = used;
//    }
//
//
//    public Integer getScMasterIdFk() {
//        return scMasterIdFk;
//    }
//
//    public void setScMasterIdFk(Integer scMasterIdFk) {
//        this.scMasterIdFk = scMasterIdFk;
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
//    public Integer getMaxApprovals() {
//        return maxApprovals;
//    }
//
//    public void setMaxApprovals(Integer maxApprovals) {
//        this.maxApprovals = maxApprovals;
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
//        ScoreCategory that = (ScoreCategory) o;
//        return id == that.id && productIdFk == that.productIdFk && scMasterIdFk == that.scMasterIdFk && Objects.equals(name, that.name) && Objects.equals(contribution, that.contribution) && Objects.equals(used, that.used) && Objects.equals(approvalStatus, that.approvalStatus) && Objects.equals(approvalLevel, that.approvalLevel) && Objects.equals(maxApprovals, that.maxApprovals) && Objects.equals(updateCycle, that.updateCycle) && Objects.equals(intrash, that.intrash);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, productIdFk, contribution, used, scMasterIdFk, approvalStatus, approvalLevel, maxApprovals, updateCycle, intrash);
//    }

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
