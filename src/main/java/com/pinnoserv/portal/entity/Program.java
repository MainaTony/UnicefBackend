package com.pinnoserv.portal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "program")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer programId;
    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "data_source_id")
    private int dataSourceIdFk;

//    @CreatedDate
    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "description")
    private String description;

    @Column(name = "inTrash")
    private String inTrash;

    @Column(name = "name")
    private String name;

    @Column(name = "organisation_id_fk")
    private int organisationIdFk;

    @Column(name = "primary_identity_type")
    private String primaryIdentityType;

    @Column(name = "status")
    private Integer status;

    @Column(name = "data_source")
    private String dataSource;
//    @Basic
//    @Column(name = "ORGANISATION_ID")
//    private BigInteger organisationId;

    @Column(name = "organisation")
    private String organisation;


    /*private Collection<CreditScore> creditScoresByProgramId;
    private Collection<CustomerSubscription> customerSubscriptionsByProgramId;
    private Collection<Product> productsByProgramId;
    private Organisation organisationByOrganisationIdFk;
    private DataSource dataSourceByDataSourceIdFk;*/


//    public Integer getProgramId() {
//        return programId;
//    }
//
//    public void setProgramId(Integer programId) {
//        this.programId = programId;
//    }
//
//
//    public String getorganisation() {
//        return organisation;
//    }
//
//    public void setorganisation(String organisation) {
//        this.organisation = organisation;
//    }
//
//
////    public BigInteger getorganisationId() {
////        return organisationId;
////    }
////    public void setorganisationId(String setorganisationId) {
////        this.organisationId = organisationId;
////    }
//
//
//    public Integer getOrganisationIdFk() {
//        return organisationIdFk;
//    }
//
//    public void setOrganisationIdFk(Integer organisationIdFk) {
//        this.organisationIdFk = organisationIdFk;
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
//    public String getPrimaryIdentityType() {
//        return primaryIdentityType;
//    }
//
//    public void setPrimaryIdentityType(String primaryIdentityType) {
//        this.primaryIdentityType = primaryIdentityType;
//    }
//
//
//    public Date getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//
//    public Integer getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(Integer createdBy) {
//        this.createdBy = createdBy;
//    }
//
//
//    public String getIntrash() {
//        return intrash;
//    }
//
//    public void setIntrash(String intrash) {
//        this.intrash = intrash;
//    }
//
//    public String getDataSource() {
//        return dataSource;
//    }
//
//    public void setDataSource(String dataSource) {
//        this.dataSource = dataSource;
//    }
//
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//
//    public Integer getDataSourceIdFk() {
//        return dataSourceIdFk;
//    }
//
//    public void setDataSourceIdFk(Integer dataSourceIdFk) {
//        this.dataSourceIdFk = dataSourceIdFk;
//    }
//
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Program program = (Program) o;
//        return programId == program.programId && organisationIdFk == program.organisationIdFk && dataSourceIdFk == program.dataSourceIdFk && Objects.equals(name, program.name) && Objects.equals(primaryIdentityType, program.primaryIdentityType) && Objects.equals(dateCreated, program.dateCreated) && Objects.equals(createdBy, program.createdBy) && Objects.equals(intrash, program.intrash) && Objects.equals(status, program.status) && Objects.equals(description, program.description) && Objects.equals(organisation, program.organisation) && Objects.equals(dataSource, program.dataSource);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(programId, organisationIdFk, name, primaryIdentityType, dateCreated, createdBy, intrash, dataSource, status, dataSourceIdFk, description, organisation);
//    }
//
//    /*@OneToMany(mappedBy = "programByProgramIdFk")
//    public Collection<CreditScore> getCreditScoresByProgramId() {
//        return creditScoresByProgramId;
//    }
//
//    public void setCreditScoresByProgramId(Collection<CreditScore> creditScoresByProgramId) {
//        this.creditScoresByProgramId = creditScoresByProgramId;
//    }
//
//    @OneToMany(mappedBy = "programByProgramIdFk")
//    public Collection<CustomerSubscription> getCustomerSubscriptionsByProgramId() {
//        return customerSubscriptionsByProgramId;
//    }
//
//    public void setCustomerSubscriptionsByProgramId(Collection<CustomerSubscription> customerSubscriptionsByProgramId) {
//        this.customerSubscriptionsByProgramId = customerSubscriptionsByProgramId;
//    }
//
//    @OneToMany(mappedBy = "programByProgramIdFk")
//    public Collection<Product> getProductsByProgramId() {
//        return productsByProgramId;
//    }
//
//    public void setProductsByProgramId(Collection<Product> productsByProgramId) {
//        this.productsByProgramId = productsByProgramId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "ORGANISATION_ID_FK", referencedColumnName = "ORGANISATION_ID", nullable = false, insertable=false, updatable=false)
//    public Organisation getOrganisationByOrganisationIdFk() {
//        return organisationByOrganisationIdFk;
//    }
//
//    public void setOrganisationByOrganisationIdFk(Organisation organisationByOrganisationIdFk) {
//        this.organisationByOrganisationIdFk = organisationByOrganisationIdFk;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "DATA_SOURCE_ID_FK", referencedColumnName = "DATA_SOURCE_ID", nullable = false, insertable=false, updatable=false)
//    public DataSource getDataSourceByDataSourceIdFk() {
//        return dataSourceByDataSourceIdFk;
//    }
//
//    public void setDataSourceByDataSourceIdFk(DataSource dataSourceByDataSourceIdFk) {
//        this.dataSourceByDataSourceIdFk = dataSourceByDataSourceIdFk;
//    }*/
}
