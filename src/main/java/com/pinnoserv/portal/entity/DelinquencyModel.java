package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "DELINQUENCY_MODEL")
public class DelinquencyModel {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIQUENCY_MODEL_SEQ")
//    @SequenceGenerator(name = "DELIQUENCY_MODEL_SEQ", sequenceName = "DELIQUENCY_MODEL_SEQ", allocationSize = 1)
    @Column(name = "DELIQUENCY_MODEL_ID")
    private BigInteger deliquencyModelId;
    @Basic
    @Column(name = "PRODUCT_ID_FK")
    private BigInteger productIdFk;
    @Basic
    @Column(name = "ACTION")
    private String action;
    @Basic
    @Column(name = "PERIOD")
    private BigInteger period;
    @Basic
    @Column(name = "PENALTY")
    private BigInteger penalty;
    @Basic
    @Column(name = "PENALTY_TYPE")
    private String penaltyType;
    @Basic
    @Column(name = "INTRASH")
    private String intrash;
    @Basic
    @Column(name = "CANDEFAULT")
    private BigInteger candefault;
    @Basic
    @Column(name = "CANBLACKLIST")
    private BigInteger canblacklist;
    @Basic
    @Column(name = "DAYS_AFTER_DEFAULT")
    private BigInteger daysafterdefault;
    @Basic
    @Column(name = "DAYS_TO_SUSPENSION")
    private BigInteger daystosuspension;
    @Basic
    @Column(name = "CANSUSPEND")
    private BigInteger cansuspend;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID_FK", referencedColumnName = "PRODUCT_ID", nullable = false, insertable=false, updatable=false)
    private Product productByProductIdFk;


    public BigInteger getDeliquencyModelId() {
        return deliquencyModelId;
    }

    public void setDeliquencyModelId(BigInteger deliquencyModelId) {
        this.deliquencyModelId = deliquencyModelId;
    }


    public BigInteger getProductIdFk() {
        return productIdFk;
    }

    public void setProductIdFk(BigInteger productIdFk) {
        this.productIdFk = productIdFk;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public BigInteger getPeriod() {
        return period;
    }

    public void setPeriod(BigInteger period) {
        this.period = period;
    }


    public BigInteger getPenalty() {
        return penalty;
    }

    public void setPenalty(BigInteger penalty) {
        this.penalty = penalty;
    }


    public String getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }


    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }


    public BigInteger getCandefault() {
        return candefault;
    }

    public void setCandefault(BigInteger candefault) {
        this.candefault = candefault;
    }


    public BigInteger getCanblacklist() {
        return canblacklist;
    }

    public void setCanblacklist(BigInteger canblacklist) {
        this.canblacklist = canblacklist;
    }


    public BigInteger getDaysafterdefault() {
        return daysafterdefault;
    }

    public void setDaysafterdefault(BigInteger daysafterdefault) {
        this.daysafterdefault = daysafterdefault;
    }


    public BigInteger getDaystosuspension() {
        return daystosuspension;
    }

    public void setDaystosuspension(BigInteger daystosuspension) {
        this.daystosuspension = daystosuspension;
    }


    public BigInteger getCansuspend() {
        return cansuspend;
    }

    public void setCansuspend(BigInteger cansuspend) {
        this.cansuspend = cansuspend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DelinquencyModel that = (DelinquencyModel) o;
        return deliquencyModelId == that.deliquencyModelId && productIdFk == that.productIdFk && Objects.equals(action, that.action) && Objects.equals(period, that.period) && Objects.equals(penalty, that.penalty) && Objects.equals(penaltyType, that.penaltyType) && Objects.equals(intrash, that.intrash) && Objects.equals(candefault, that.candefault) && Objects.equals(canblacklist, that.canblacklist) && Objects.equals(daysafterdefault, that.daysafterdefault) && Objects.equals(daystosuspension, that.daystosuspension) && Objects.equals(cansuspend, that.cansuspend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliquencyModelId, productIdFk, action, period, penalty, penaltyType, intrash, candefault, canblacklist, daysafterdefault, daystosuspension, cansuspend);
    }


    public Product getProductByProductIdFk() {
        return productByProductIdFk;
    }

    public void setProductByProductIdFk(Product productByProductIdFk) {
        this.productByProductIdFk = productByProductIdFk;
    }
}
