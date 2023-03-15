package com.pinnoserv.portal.view;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "DELIQUENCY_MODEL_VIEW")
public class DeliquencyModelView {
    private BigInteger deliquencyModelId;
    private BigInteger productIdFk;
    private String productName;
    private String action;
    private BigInteger period;
    private BigInteger penalty;
    private String penaltyType;
    private String intrash;
    private BigInteger candefault;
    private BigInteger canblacklist;
    private BigInteger daysafterdefault;
    private Short daystosuspension;
    private BigInteger cansuspend;

    @Id
    @Basic(optional = false)
    @NotNull
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
    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
    public Short getDaystosuspension() {
        return daystosuspension;
    }

    public void setDaystosuspension(Short daystosuspension) {
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
        DeliquencyModelView that = (DeliquencyModelView) o;
        return deliquencyModelId == that.deliquencyModelId && productIdFk == that.productIdFk && Objects.equals(productName, that.productName) && Objects.equals(action, that.action) && Objects.equals(period, that.period) && Objects.equals(penalty, that.penalty) && Objects.equals(penaltyType, that.penaltyType) && Objects.equals(intrash, that.intrash) && Objects.equals(candefault, that.candefault) && Objects.equals(canblacklist, that.canblacklist) && Objects.equals(daysafterdefault, that.daysafterdefault) && Objects.equals(daystosuspension, that.daystosuspension) && Objects.equals(cansuspend, that.cansuspend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliquencyModelId, productIdFk, productName, action, period, penalty, penaltyType, intrash, candefault, canblacklist, daysafterdefault, daystosuspension, cansuspend);
    }
}
