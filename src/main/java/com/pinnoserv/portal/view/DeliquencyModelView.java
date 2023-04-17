package com.pinnoserv.portal.view;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "DELIQUENCY_MODEL_VIEW")
public class DeliquencyModelView {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIQUENCY_MODEL_ID")
    private BigInteger deliquencyModelId;
    @Basic
    @Column(name = "PRODUCT_ID_FK")
    private BigInteger productIdFk;
    @Basic
    @Column(name = "PRODUCT_NAME")
    private String productName;
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
    private Short daystosuspension;
    @Basic
    @Column(name = "CANSUSPEND")
    private BigInteger cansuspend;


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


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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


    public Short getDaystosuspension() {
        return daystosuspension;
    }

    public void setDaystosuspension(Short daystosuspension) {
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
        DeliquencyModelView that = (DeliquencyModelView) o;
        return deliquencyModelId == that.deliquencyModelId && productIdFk == that.productIdFk && Objects.equals(productName, that.productName) && Objects.equals(action, that.action) && Objects.equals(period, that.period) && Objects.equals(penalty, that.penalty) && Objects.equals(penaltyType, that.penaltyType) && Objects.equals(intrash, that.intrash) && Objects.equals(candefault, that.candefault) && Objects.equals(canblacklist, that.canblacklist) && Objects.equals(daysafterdefault, that.daysafterdefault) && Objects.equals(daystosuspension, that.daystosuspension) && Objects.equals(cansuspend, that.cansuspend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliquencyModelId, productIdFk, productName, action, period, penalty, penaltyType, intrash, candefault, canblacklist, daysafterdefault, daystosuspension, cansuspend);
    }
}
