package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "DATA_SOURCE_MAPPING")
public class DataSourceMapping {
    @Id
    @Column(name = "DS_MAPPING_ID")
    private Integer dsMappingId;
    @Basic
    @Column(name = "DATA_SOURCE_ID_FK")
    private Integer dataSourceIdFk;
    @Basic
    @Column(name = "DATA_SOURCE_DESC")
    private String dataSourceDesc;
    @Basic
    @Column(name = "PARAMETER")
    private String parameter;
    @Basic
    @Column(name = "TYPE_OF_DATA")
    private String typeOfData;
    @Basic
    @Column(name = "DATA_COLUMN_ID_FK")
    private String dataColumnIdFk;
    @Basic
    @Column(name = "INTRASH")
    private String intrash;
    //private DataSource dataSourceByDataSourceIdFk;


    public Integer getDsMappingId() {
        return dsMappingId;
    }

    public void setDsMappingId(Integer dsMappingId) {
        this.dsMappingId = dsMappingId;
    }


    public Integer getDataSourceIdFk() {
        return dataSourceIdFk;
    }

    public void setDataSourceIdFk(Integer dataSourceIdFk) {
        this.dataSourceIdFk = dataSourceIdFk;
    }


    public String getDataSourceDesc() {
        return dataSourceDesc;
    }

    public void setDataSourceDesc(String dataSourceDesc) {
        this.dataSourceDesc = dataSourceDesc;
    }


    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }


    public String getTypeOfData() {
        return typeOfData;
    }

    public void setTypeOfData(String typeOfData) {
        this.typeOfData = typeOfData;
    }


    public String getDataColumnIdFk() {
        return dataColumnIdFk;
    }

    public void setDataColumnIdFk(String dataColumnIdFk) {
        this.dataColumnIdFk = dataColumnIdFk;
    }


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
