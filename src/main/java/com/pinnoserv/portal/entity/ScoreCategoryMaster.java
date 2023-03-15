package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "SCORE_CATEGORY_MASTER")
public class ScoreCategoryMaster {
    private BigInteger id;
    private String name;
    private BigInteger productIdFk;
    private BigInteger contribution;
    private String used;
    /*private Product productByProductIdFk;
    private Collection<ScoreCategory> scoreCategoriesById;
    private Collection<ScoreParamMaster> scoreParamMastersById;*/

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCORE_CATEGORY_MASTER_SEQ")
    @SequenceGenerator(name = "SCORE_CATEGORY_MASTER_SEQ", sequenceName = "SCORE_CATEGORY_MASTER_SEQ", allocationSize = 1)
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
        ScoreCategoryMaster that = (ScoreCategoryMaster) o;
        return id == that.id && productIdFk == that.productIdFk && Objects.equals(name, that.name) && Objects.equals(contribution, that.contribution) && Objects.equals(used, that.used);
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
