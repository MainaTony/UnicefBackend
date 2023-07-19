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
@Table(name = "score_category_master")
public class ScoreCategoryMaster {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCORE_CATEGORY_MASTER_SEQ")
//    @SequenceGenerator(name = "SCORE_CATEGORY_MASTER_SEQ", sequenceName = "SCORE_CATEGORY_MASTER_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "product_id_fk")
    private int productIdFk;
    @Column(name = "contribution")
    private Double contribution;
    @Column(name = "used")
    private String used;
    @Column(name = "product_name")
    private String productName;
    /*private Product productByProductIdFk;
    private Collection<ScoreCategory> scoreCategoriesById;
    private Collection<ScoreParamMaster> scoreParamMastersById;*/

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
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ScoreCategoryMaster that = (ScoreCategoryMaster) o;
//        return id == that.id
//                && productIdFk == that.productIdFk
//                && Objects.equals(name, that.name)
//                && Objects.equals(contribution, that.contribution)
//                && Objects.equals(used, that.used);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, productIdFk, contribution, used);
//    }

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
