package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "BUSINESS_TYPE")
public class BusinessType {
    private BigInteger id;
    private String type;
    private String description;
    private Timestamp dateCreated;
    private BigInteger createdByFk;
    private String intrash;
    private Collection<Organisation> organisationsById;

    @Id
    @Column(name = "ID")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "DATE_CREATED")
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "CREATED_BY_FK")
    public BigInteger getCreatedByFk() {
        return createdByFk;
    }

    public void setCreatedByFk(BigInteger createdByFk) {
        this.createdByFk = createdByFk;
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
        BusinessType that = (BusinessType) o;
        return id == that.id && Objects.equals(type, that.type) && Objects.equals(description, that.description) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(createdByFk, that.createdByFk) && Objects.equals(intrash, that.intrash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, description, dateCreated, createdByFk, intrash);
    }

    @OneToMany(mappedBy = "businessTypeByBusinessTypeFk")
    public Collection<Organisation> getOrganisationsById() {
        return organisationsById;
    }

    public void setOrganisationsById(Collection<Organisation> organisationsById) {
        this.organisationsById = organisationsById;
    }
}
