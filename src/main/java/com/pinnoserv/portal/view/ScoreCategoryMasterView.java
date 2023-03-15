package com.pinnoserv.portal.view;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "SCORE_CATEGORY_MASTER_VIEW")
public class ScoreCategoryMasterView {
    private BigInteger id;
    private String name;
    private BigInteger productIdFk;
    private String productName;
    private BigInteger contribution;
    private String used;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "CONTRIBUTION")
    public BigInteger getContribution() {
        return contribution;
    }

    public void setContribution(BigInteger contribution) {
        this.contribution = contribution;
    }

    @Basic
    @Column(name = "USED")
    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreCategoryMasterView that = (ScoreCategoryMasterView) o;
        return id == that.id && productIdFk == that.productIdFk && Objects.equals(name, that.name) && Objects.equals(productName, that.productName) && Objects.equals(contribution, that.contribution) && Objects.equals(used, that.used);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productIdFk, productName, contribution, used);
    }
}
