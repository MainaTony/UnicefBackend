package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
public class Program {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROGRAM_SEQ")
//    @SequenceGenerator(name = "PROGRAM_SEQ", sequenceName = "PROGRAM_SEQ", allocationSize = 1)
    @Column(name = "PROGRAM_ID")
    private BigInteger programId;
    @Basic
    @Column(name = "CREATED_BY")
    private BigInteger createdBy;
    @Basic
    @Column(name = "DATA_SOURCE_ID_FK")
    private BigInteger dataSourceIdFk;
    @Basic
    @Column(name = "DATE_CREATED")
    private Date dateCreated;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic
    @Column(name = "INTRASH")
    private String intrash;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "ORGANISATION_ID_FK")
    private BigInteger organisationIdFk;
    @Basic
    @Column(name = "PRIMARY_IDENTITY_TYPE")
    private String primaryIdentityType;
    @Basic
    @Column(name = "STATUS")
    private BigInteger status;
    @Basic
    @Column(name = "DATA_SOURCE")
    private String dataSource;
//    @Basic
//    @Column(name = "ORGANISATION_ID")
//    private BigInteger organisationId;
    @Basic
    @Column(name = "ORGANISATION")
    private String organisation;


    /*private Collection<CreditScore> creditScoresByProgramId;
    private Collection<CustomerSubscription> customerSubscriptionsByProgramId;
    private Collection<Product> productsByProgramId;
    private Organisation organisationByOrganisationIdFk;
    private DataSource dataSourceByDataSourceIdFk;*/


    public BigInteger getProgramId() {
        return programId;
    }

    public void setProgramId(BigInteger programId) {
        this.programId = programId;
    }


    public String getorganisation() {
        return organisation;
    }

    public void setorganisation(String organisation) {
        this.organisation = organisation;
    }


//    public BigInteger getorganisationId() {
//        return organisationId;
//    }
//    public void setorganisationId(String setorganisationId) {
//        this.organisationId = organisationId;
//    }


    public BigInteger getOrganisationIdFk() {
        return organisationIdFk;
    }

    public void setOrganisationIdFk(BigInteger organisationIdFk) {
        this.organisationIdFk = organisationIdFk;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPrimaryIdentityType() {
        return primaryIdentityType;
    }

    public void setPrimaryIdentityType(String primaryIdentityType) {
        this.primaryIdentityType = primaryIdentityType;
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    public BigInteger getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(BigInteger createdBy) {
        this.createdBy = createdBy;
    }


    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }


    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }


    public BigInteger getDataSourceIdFk() {
        return dataSourceIdFk;
    }

    public void setDataSourceIdFk(BigInteger dataSourceIdFk) {
        this.dataSourceIdFk = dataSourceIdFk;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return programId == program.programId && organisationIdFk == program.organisationIdFk && dataSourceIdFk == program.dataSourceIdFk && Objects.equals(name, program.name) && Objects.equals(primaryIdentityType, program.primaryIdentityType) && Objects.equals(dateCreated, program.dateCreated) && Objects.equals(createdBy, program.createdBy) && Objects.equals(intrash, program.intrash) && Objects.equals(status, program.status) && Objects.equals(description, program.description) && Objects.equals(organisation, program.organisation) && Objects.equals(dataSource, program.dataSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programId, organisationIdFk, name, primaryIdentityType, dateCreated, createdBy, intrash, dataSource, status, dataSourceIdFk, description, organisation);
    }

    /*@OneToMany(mappedBy = "programByProgramIdFk")
    public Collection<CreditScore> getCreditScoresByProgramId() {
        return creditScoresByProgramId;
    }

    public void setCreditScoresByProgramId(Collection<CreditScore> creditScoresByProgramId) {
        this.creditScoresByProgramId = creditScoresByProgramId;
    }

    @OneToMany(mappedBy = "programByProgramIdFk")
    public Collection<CustomerSubscription> getCustomerSubscriptionsByProgramId() {
        return customerSubscriptionsByProgramId;
    }

    public void setCustomerSubscriptionsByProgramId(Collection<CustomerSubscription> customerSubscriptionsByProgramId) {
        this.customerSubscriptionsByProgramId = customerSubscriptionsByProgramId;
    }

    @OneToMany(mappedBy = "programByProgramIdFk")
    public Collection<Product> getProductsByProgramId() {
        return productsByProgramId;
    }

    public void setProductsByProgramId(Collection<Product> productsByProgramId) {
        this.productsByProgramId = productsByProgramId;
    }

    @ManyToOne
    @JoinColumn(name = "ORGANISATION_ID_FK", referencedColumnName = "ORGANISATION_ID", nullable = false, insertable=false, updatable=false)
    public Organisation getOrganisationByOrganisationIdFk() {
        return organisationByOrganisationIdFk;
    }

    public void setOrganisationByOrganisationIdFk(Organisation organisationByOrganisationIdFk) {
        this.organisationByOrganisationIdFk = organisationByOrganisationIdFk;
    }

    @ManyToOne
    @JoinColumn(name = "DATA_SOURCE_ID_FK", referencedColumnName = "DATA_SOURCE_ID", nullable = false, insertable=false, updatable=false)
    public DataSource getDataSourceByDataSourceIdFk() {
        return dataSourceByDataSourceIdFk;
    }

    public void setDataSourceByDataSourceIdFk(DataSource dataSourceByDataSourceIdFk) {
        this.dataSourceByDataSourceIdFk = dataSourceByDataSourceIdFk;
    }*/
}
