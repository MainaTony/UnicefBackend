package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Config {
    private BigInteger id;
    private BigInteger createdBy;
    private String name;
    private Date timeCreated;
    private Timestamp timeUpdated;
    private BigInteger updatedBy;
    private BigInteger orgIdFk;
    private String category;
    private String value;
    private String largeValue;
    private Organisation organisationByOrgIdFk;

    @Id
    @Column(name = "ID")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CREATED_BY")
    public BigInteger getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(BigInteger createdBy) {
        this.createdBy = createdBy;
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
    @Column(name = "TIME_CREATED")
    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Basic
    @Column(name = "TIME_UPDATED")
    public Timestamp getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Timestamp timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    @Basic
    @Column(name = "UPDATED_BY")
    public BigInteger getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(BigInteger updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Basic
    @Column(name = "ORG_ID_FK")
    public BigInteger getOrgIdFk() {
        return orgIdFk;
    }

    public void setOrgIdFk(BigInteger orgIdFk) {
        this.orgIdFk = orgIdFk;
    }

    @Basic
    @Column(name = "CATEGORY")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "LARGE_VALUE")
    public String getLargeValue() {
        return largeValue;
    }

    public void setLargeValue(String largeValue) {
        this.largeValue = largeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config config = (Config) o;
        return id == config.id && createdBy == config.createdBy && updatedBy == config.updatedBy && orgIdFk == config.orgIdFk && Objects.equals(name, config.name) && Objects.equals(timeCreated, config.timeCreated) && Objects.equals(timeUpdated, config.timeUpdated) && Objects.equals(category, config.category) && Objects.equals(value, config.value) && Objects.equals(largeValue, config.largeValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdBy, name, timeCreated, timeUpdated, updatedBy, orgIdFk, category, value, largeValue);
    }

    @ManyToOne
    @JoinColumn(name = "ORG_ID_FK", referencedColumnName = "ORGANISATION_ID", nullable = false, insertable=false, updatable=false)
    public Organisation getOrganisationByOrgIdFk() {
        return organisationByOrgIdFk;
    }

    public void setOrganisationByOrgIdFk(Organisation organisationByOrgIdFk) {
        this.organisationByOrgIdFk = organisationByOrgIdFk;
    }
}
