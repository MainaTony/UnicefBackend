package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "SCORE_CATEGORY_MASTER")
public class ScoreCategoryMaster {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCORE_CATEGORY_MASTER_SEQ")
//    @SequenceGenerator(name = "SCORE_CATEGORY_MASTER_SEQ", sequenceName = "SCORE_CATEGORY_MASTER_SEQ", allocationSize = 1)
    @Column(name = "SC_MASTER_ID")
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
    @Column(name = "PRODUCT_NAME")
    private String productName;
    /*private Product productByProductIdFk;
    private Collection<ScoreCategory> scoreCategoriesById;
    private Collection<ScoreParamMaster> scoreParamMastersById;*/


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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreCategoryMaster that = (ScoreCategoryMaster) o;
        return id == that.id
                && productIdFk == that.productIdFk
                && Objects.equals(name, that.name)
                && Objects.equals(contribution, that.contribution)
                && Objects.equals(used, that.used);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productIdFk, contribution, used);
    }

    /*@ManyToOne
    @JoinColumn(name = "PRODUCT_ID_FK", referencedColumnName = "PRODUCT_ID", nullable = false, insertable=false, updatable=false)
    public Product getProductByProductIdFk() {
        return productByProductIdFk;
    }

    public void setProductByProductIdFk(Product productByProductIdFk) {
        this.productByProductIdFk = productByProductIdFk;
    }

    @OneToMany(mappedBy = "scoreCategoryMasterByScMasterIdFk")
    public Collection<ScoreCategory> getScoreCategoriesById() {
        return scoreCategoriesById;
    }

    public void setScoreCategoriesById(Collection<ScoreCategory> scoreCategoriesById) {
        this.scoreCategoriesById = scoreCategoriesById;
    }

    @OneToMany(mappedBy = "scoreCategoryMasterByCategoryMasterIdFk")
    public Collection<ScoreParamMaster> getScoreParamMastersById() {
        return scoreParamMastersById;
    }

    public void setScoreParamMastersById(Collection<ScoreParamMaster> scoreParamMastersById) {
        this.scoreParamMastersById = scoreParamMastersById;
    }*/
}
