//package com.pinnoserv.portal.entity;
//
//import javax.persistence.*;
//import java.math.BigInteger;
//import java.sql.Date;
//import java.util.Objects;
//
//@Entity
//@Table(name = "CREDIT_SCORE")
//public class CreditScore {
//    private BigInteger creditScoreId;
//    private BigInteger programIdFk;
//    private String dataSourceField;
//    private String operator;
//    private String factor;
//    private BigInteger noOfRecords;
//    private BigInteger createdBy;
//    private String intrash;
//    private Date dateCreated;
//    //private Program programByProgramIdFk;
//
//    @Id
//    @Column(name = "CREDIT_SCORE_ID")
//    public BigInteger getCreditScoreId() {
//        return creditScoreId;
//    }
//
//    public void setCreditScoreId(BigInteger creditScoreId) {
//        this.creditScoreId = creditScoreId;
//    }
//
//    @Basic
//    @Column(name = "PROGRAM_ID_FK")
//    public BigInteger getProgramIdFk() {
//        return programIdFk;
//    }
//
//    public void setProgramIdFk(BigInteger programIdFk) {
//        this.programIdFk = programIdFk;
//    }
//
//    @Basic
//    @Column(name = "DATA_SOURCE_FIELD")
//    public String getDataSourceField() {
//        return dataSourceField;
//    }
//
//    public void setDataSourceField(String dataSourceField) {
//        this.dataSourceField = dataSourceField;
//    }
//
//    @Basic
//    @Column(name = "OPERATOR")
//    public String getOperator() {
//        return operator;
//    }
//
//    public void setOperator(String operator) {
//        this.operator = operator;
//    }
//
//    @Basic
//    @Column(name = "FACTOR")
//    public String getFactor() {
//        return factor;
//    }
//
//    public void setFactor(String factor) {
//        this.factor = factor;
//    }
//
//    @Basic
//    @Column(name = "NO_OF_RECORDS")
//    public BigInteger getNoOfRecords() {
//        return noOfRecords;
//    }
//
//    public void setNoOfRecords(BigInteger noOfRecords) {
//        this.noOfRecords = noOfRecords;
//    }
//
//    @Basic
//    @Column(name = "CREATED_BY")
//    public BigInteger getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(BigInteger createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    @Basic
//    @Column(name = "INTRASH")
//    public String getIntrash() {
//        return intrash;
//    }
//
//    public void setIntrash(String intrash) {
//        this.intrash = intrash;
//    }
//
//    @Basic
//    @Column(name = "DATE_CREATED")
//    public Date getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CreditScore that = (CreditScore) o;
//        return creditScoreId == that.creditScoreId && programIdFk == that.programIdFk && Objects.equals(dataSourceField, that.dataSourceField) && Objects.equals(operator, that.operator) && Objects.equals(factor, that.factor) && Objects.equals(noOfRecords, that.noOfRecords) && Objects.equals(createdBy, that.createdBy) && Objects.equals(intrash, that.intrash) && Objects.equals(dateCreated, that.dateCreated);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(creditScoreId, programIdFk, dataSourceField, operator, factor, noOfRecords, createdBy, intrash, dateCreated);
//    }
//
//    /*@ManyToOne
//    @JoinColumn(name = "PROGRAM_ID_FK", referencedColumnName = "PROGRAM_ID", nullable = false, insertable=false, updatable=false)
//    public Program getProgramByProgramIdFk() {
//        return programByProgramIdFk;
//    }
//
//    public void setProgramByProgramIdFk(Program programByProgramIdFk) {
//        this.programByProgramIdFk = programByProgramIdFk;
//    }*/
//}
