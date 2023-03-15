package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "DELINQUENCY_MODEL")
public class DelinquencyModel {
    private BigInteger deliquencyModelId;
    private BigInteger productIdFk;
    private String action;
    private BigInteger period;
    private BigInteger penalty;
    private String penaltyType;
    private String intrash;
    private BigInteger candefault;
    private BigInteger canblacklist;
    private BigInteger daysafterdefault;
    private BigInteger daystosuspension;
    private BigInteger cansuspend;
    private Product productByProductIdFk;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIQUENCY_MODEL_SEQ")
    @SequenceGenerator(name = "DELIQUENCY_MODEL_SEQ", sequenceName = "DELIQUENCY_MODEL_SEQ", allocationSize = 1)
    @Column(name = "DELIQUENCY_MODEL_ID")
    public BigInteger getDeliquencyModelId() {
        return deliquencyModelId;
    }

    public void setDeliquencyModelId(BigInteger deliquencyModelId) {
        this.deliquencyModelId = deliquencyModelId;
    }

    @Basic
    @Column(name = "PRODUCT_ID_FK")
    public BigInteger getProductIdFk() {
        return productIdFk;
    }

    public void setProductIdFk(BigInteger productIdFk) {
        this.productIdFk = productIdFk;
    }

    @Basic
    @Column(name = "ACTION")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "PERIOD")
    public BigInteger getPeriod() {
        return period;
    }

    public void setPeriod(BigInteger period) {
        this.period = period;
    }

    @Basic
    @Column(name = "PENALTY")
    public BigInteger getPenalty() {
        return penalty;
    }

    public void setPenalty(BigInteger penalty) {
        this.penalty = penalty;
    }

    @Basic
    @Column(name = "PENALTY_TYPE")
    public String getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    @Basic
    @Column(name = "INTRASH")
    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }

    @Basic
    @Column(name = "CANDEFAULT")
    public BigInteger getCandefault() {
        return candefault;
    }

    public void setCandefault(BigInteger candefault) {
        this.candefault = candefault;
    }

    @Basic
    @Column(name = "CANBLACKLIST")
    public BigInteger getCanblacklist() {
        return canblacklist;
    }

    public void setCanblacklist(BigInteger canblacklist) {
        this.canblacklist = canblacklist;
    }

    @Basic
    @Column(name = "DAYSAFTERDEFAULT")
    public BigInteger getDaysafterdefault() {
        return daysafterdefault;
    }

    public void setDaysafterdefault(BigInteger daysafterdefault) {
        this.daysafterdefault = daysafterdefault;
    }

    @Basic
    @Column(name = "DAYSTOSUSPENSION")
    public BigInteger getDaystosuspension() {
        return daystosuspension;
    }

    public void setDaystosuspension(BigInteger daystosuspension) {
        this.daystosuspension = daystosuspension;
    }

    @Basic
    @Column(name = "CANSUSPEND")
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

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID_FK", referencedColumnName = "PRODUCT_ID", nullable = false, insertable=false, updatable=false)
    public Product getProductByProductIdFk() {
        return productByProductIdFk;
    }

    public void setProductByProductIdFk(Product productByProductIdFk) {
        this.productByProductIdFk = productByProductIdFk;
    }
}
