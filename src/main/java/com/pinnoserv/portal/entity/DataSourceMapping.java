package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "DATA_SOURCE_MAPPING")
public class DataSourceMapping {
    private BigInteger dsMappingId;
    private BigInteger dataSourceIdFk;
    private String dataSourceDesc;
    private String parameter;
    private String typeOfData;
    private String dataColumnIdFk;
    private String intrash;
    //private DataSource dataSourceByDataSourceIdFk;

    @Id
    @Column(name = "DS_MAPPING_ID")
    public BigInteger getDsMappingId() {
        return dsMappingId;
    }

    public void setDsMappingId(BigInteger dsMappingId) {
        this.dsMappingId = dsMappingId;
    }

    @Basic
    @Column(name = "DATA_SOURCE_ID_FK")
    public BigInteger getDataSourceIdFk() {
        return dataSourceIdFk;
    }

    public void setDataSourceIdFk(BigInteger dataSourceIdFk) {
        this.dataSourceIdFk = dataSourceIdFk;
    }

    @Basic
    @Column(name = "DATA_SOURCE_DESC")
    public String getDataSourceDesc() {
        return dataSourceDesc;
    }

    public void setDataSourceDesc(String dataSourceDesc) {
        this.dataSourceDesc = dataSourceDesc;
    }

    @Basic
    @Column(name = "PARAMETER")
    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Basic
    @Column(name = "TYPE_OF_DATA")
    public String getTypeOfData() {
        return typeOfData;
    }

    public void setTypeOfData(String typeOfData) {
        this.typeOfData = typeOfData;
    }

    @Basic
    @Column(name = "DATA_COLUMN_ID_FK")
    public String getDataColumnIdFk() {
        return dataColumnIdFk;
    }

    public void setDataColumnIdFk(String dataColumnIdFk) {
        this.dataColumnIdFk = dataColumnIdFk;
    }

    @Basic
    @Column(name = "INTRASH")
    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSourceMapping that = (DataSourceMapping) o;
        return dsMappingId == that.dsMappingId && dataSourceIdFk == that.dataSourceIdFk && Objects.equals(dataSourceDesc, that.dataSourceDesc) && Objects.equals(parameter, that.parameter) && Objects.equals(typeOfData, that.typeOfData) && Objects.equals(dataColumnIdFk, that.dataColumnIdFk) && Objects.equals(intrash, that.intrash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dsMappingId, dataSourceIdFk, dataSourceDesc, parameter, typeOfData, dataColumnIdFk, intrash);
    }

    /*@ManyToOne
    @JoinColumn(name = "DATA_SOURCE_ID_FK", referencedColumnName = "DATA_SOURCE_ID", nullable = false, insertable=false, updatable=false)
    public DataSource getDataSourceByDataSourceIdFk() {
        return dataSourceByDataSourceIdFk;
    }

    public void setDataSourceByDataSourceIdFk(DataSource dataSourceByDataSourceIdFk) {
        this.dataSourceByDataSourceIdFk = dataSourceByDataSourceIdFk;
    }*/
}
