package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "BUSINESS_TYPE")
public class BusinessTypeModel {
    @Id
    @Column(name = "ID")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Basic
    @Column(name = "TYPE")
    private String type;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic
    @Column(name = "DATE_CREATED")
    private Date dateCreated;
    @Basic
    @Column(name = "CREATED_BY_FK")
    private BigInteger createdByFk;
    @Basic
    @Column(name = "INTRASH")
    private String intrash;
//    @OneToMany(mappedBy = "businessTypeByBusinessTypeFk")
//    private Collection<Organisation> organisationsById;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    public BigInteger getCreatedByFk() {
        return createdByFk;
    }

    public void setCreatedByFk(BigInteger createdByFk) {
        this.createdByFk = createdByFk;
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
        BusinessTypeModel that = (BusinessTypeModel) o;
        return id == that.id && Objects.equals(type, that.type) && Objects.equals(description, that.description) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(createdByFk, that.createdByFk) && Objects.equals(intrash, that.intrash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, description, dateCreated, createdByFk, intrash);
    }


//    public Collection<Organisation> getOrganisationsById() {
//        return organisationsById;
//    }
//
//    public void setOrganisationsById(Collection<Organisation> organisationsById) {
//        this.organisationsById = organisationsById;
//    }
}
