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
@Table(name = "delinquency")
public class DelinquencyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIQUENCY_MODEL_SEQ")
//    @SequenceGenerator(name = "DELIQUENCY_MODEL_SEQ", sequenceName = "DELIQUENCY_MODEL_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "product_id_fk")
    private int productIdFk;
    @Column(name = "action")
    private String action;
    @Column(name = "period")
    private Integer period;
    @Column(name = "penalty")
    private Integer penalty;
    @Column(name = "penalty_type")
    private String penaltyType;
    @Column(name = "in_trash")
    private String inTrash;
    @Column(name = "can_default")
    private Integer canDefault;
    @Column(name = "can_blacklist")
    private Integer canBlacklist;
    @Column(name = "days_after_default")
    private Integer daysAfterDefault;
    @Column(name = "days_to_suspension")
    private Integer daysToSuspension;
    @Basic
    @Column(name = "can_suspend")
    private Integer canSuspend;

//    @ManyToOne
//    @JoinColumn(name = "PRODUCT_ID_FK", referencedColumnName = "PRODUCT_ID", nullable = false, insertable=false, updatable=false)
//    private Product productByProductIdFk;

//
//    public Integer getDeliquencyModelId() {
//        return deliquencyModelId;
//    }
//
//    public void setDeliquencyModelId(Integer deliquencyModelId) {
//        this.deliquencyModelId = deliquencyModelId;
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
//    public String getAction() {
//        return action;
//    }
//
//    public void setAction(String action) {
//        this.action = action;
//    }
//
//
//    public Integer getPeriod() {
//        return period;
//    }
//
//    public void setPeriod(Integer period) {
//        this.period = period;
//    }
//
//
//    public Integer getPenalty() {
//        return penalty;
//    }
//
//    public void setPenalty(Integer penalty) {
//        this.penalty = penalty;
//    }
//
//
//    public String getPenaltyType() {
//        return penaltyType;
//    }
//
//    public void setPenaltyType(String penaltyType) {
//        this.penaltyType = penaltyType;
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
//    public Integer getCandefault() {
//        return candefault;
//    }
//
//    public void setCandefault(Integer candefault) {
//        this.candefault = candefault;
//    }
//
//
//    public Integer getCanblacklist() {
//        return canblacklist;
//    }
//
//    public void setCanblacklist(Integer canblacklist) {
//        this.canblacklist = canblacklist;
//    }
//
//
//    public Integer getDaysafterdefault() {
//        return daysafterdefault;
//    }
//
//    public void setDaysafterdefault(Integer daysafterdefault) {
//        this.daysafterdefault = daysafterdefault;
//    }
//
//
//    public Integer getDaystosuspension() {
//        return daystosuspension;
//    }
//
//    public void setDaystosuspension(Integer daystosuspension) {
//        this.daystosuspension = daystosuspension;
//    }
//
//
//    public Integer getCansuspend() {
//        return cansuspend;
//    }
//
//    public void setCansuspend(Integer cansuspend) {
//        this.cansuspend = cansuspend;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        DelinquencyModel that = (DelinquencyModel) o;
//        return deliquencyModelId == that.deliquencyModelId && productIdFk == that.productIdFk && Objects.equals(action, that.action) && Objects.equals(period, that.period) && Objects.equals(penalty, that.penalty) && Objects.equals(penaltyType, that.penaltyType) && Objects.equals(intrash, that.intrash) && Objects.equals(candefault, that.candefault) && Objects.equals(canblacklist, that.canblacklist) && Objects.equals(daysafterdefault, that.daysafterdefault) && Objects.equals(daystosuspension, that.daystosuspension) && Objects.equals(cansuspend, that.cansuspend);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(deliquencyModelId, productIdFk, action, period, penalty, penaltyType, intrash, candefault, canblacklist, daysafterdefault, daystosuspension, cansuspend);
//    }
//
//
//    public Product getProductByProductIdFk() {
//        return productByProductIdFk;
//    }
//
//    public void setProductByProductIdFk(Product productByProductIdFk) {
//        this.productByProductIdFk = productByProductIdFk;
//    }
}
