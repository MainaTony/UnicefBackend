package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
public class Program {
    private BigInteger programId;
    private BigInteger organisationIdFk;
    private String name;
    private String primaryIdentityType;
    private Date dateCreated;
    private BigInteger createdBy;
    private String intrash;
    private BigInteger status;
    private BigInteger dataSourceIdFk;

    private String dataSource;

    private String organisation;

    private BigInteger organisationId;
    private String description;
    /*private Collection<CreditScore> creditScoresByProgramId;
    private Collection<CustomerSubscription> customerSubscriptionsByProgramId;
    private Collection<Product> productsByProgramId;
    private Organisation organisationByOrganisationIdFk;
    private DataSource dataSourceByDataSourceIdFk;*/

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROGRAM_SEQ")
    @SequenceGenerator(name = "PROGRAM_SEQ", sequenceName = "PROGRAM_SEQ", allocationSize = 1)
    @Column(name = "PROGRAM_ID")
    public BigInteger getProgramId() {
        return programId;
    }

    public void setProgramId(BigInteger programId) {
        this.programId = programId;
    }

    @Basic
    @Column(name = "ORGANISATION")
    public String getorganisation() {
        return organisation;
    }

    public void setorganisation(String organisation) {
        this.organisation = organisation;
    }

    @Basic
    @Column(name = "ORGANISATION_ID")
    public BigInteger getorganisationId() {
        return organisationId;
    }
    public void setorganisationId(String setorganisationId) {
        this.organisationId = organisationId;
    }

    @Basic
    @Column(name = "ORGANISATION_ID_FK")
    public BigInteger getOrganisationIdFk() {
        return organisationIdFk;
    }

    public void setOrganisationIdFk(BigInteger organisationIdFk) {
        this.organisationIdFk = organisationIdFk;
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
    @Column(name = "PRIMARY_IDENTITY_TYPE")
    public String getPrimaryIdentityType() {
        return primaryIdentityType;
    }

    public void setPrimaryIdentityType(String primaryIdentityType) {
        this.primaryIdentityType = primaryIdentityType;
    }

    @Basic
    @Column(name = "DATE_CREATED")
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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
    @Column(name = "INTRASH")
    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }

    @Basic
    @Column(name = "STATUS")
    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
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
    @Column(name = "DESCRIPTION")
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
        return programId == program.programId && organisationIdFk == program.organisationIdFk && dataSourceIdFk == program.dataSourceIdFk && Objects.equals(name, program.name) && Objects.equals(primaryIdentityType, program.primaryIdentityType) && Objects.equals(dateCreated, program.dateCreated) && Objects.equals(createdBy, program.createdBy) && Objects.equals(intrash, program.intrash) && Objects.equals(status, program.status) && Objects.equals(description, program.description) && Objects.equals(organisation, program.organisation) && Objects.equals(organisationId, program.organisationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programId, organisationIdFk, name, primaryIdentityType, dateCreated, createdBy, intrash, status, dataSourceIdFk, description, organisation, organisationId);
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
