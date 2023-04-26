//package com.pinnoserv.portal.entity;
//
//import javax.persistence.*;
//import java.math.BigInteger;
//import java.util.Date;
//import java.util.Objects;
//
//@Entity
//@Table(name = "ROLE")
//public class Role {
//    private BigInteger id;
//    private BigInteger approvalStatus;
//    private BigInteger businessEntityId;
//    private BigInteger createdBy;
//    private BigInteger currentApprovalLevel;
//    private BigInteger maxApprovals;
//    private String name;
//    private boolean status;
//    private Date timeCreated;
//    private Date timeUpdated;
//    private BigInteger updatedBy;
//    /*@Transient
//    private List<Permission> permissions;
//    @Transient
//    private boolean has_role;*/
//
//    @Id
//    @Column(name = "ID")
//    public BigInteger getId() {
//        return id;
//    }
//
//    public void setId(BigInteger id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "APPROVAL_STATUS")
//    public BigInteger getApprovalStatus() {
//        return approvalStatus;
//    }
//
//    public void setApprovalStatus(BigInteger approvalStatus) {
//        this.approvalStatus = approvalStatus;
//    }
//
//    @Basic
//    @Column(name = "BUSINESS_ENTITY_ID")
//    public BigInteger getBusinessEntityId() {
//        return businessEntityId;
//    }
//
//    public void setBusinessEntityId(BigInteger businessEntityId) {
//        this.businessEntityId = businessEntityId;
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
//    @Column(name = "CURRENT_APPROVAL_LEVEL")
//    public BigInteger getCurrentApprovalLevel() {
//        return currentApprovalLevel;
//    }
//
//    public void setCurrentApprovalLevel(BigInteger currentApprovalLevel) {
//        this.currentApprovalLevel = currentApprovalLevel;
//    }
//
//    @Basic
//    @Column(name = "MAX_APPROVALS")
//    public BigInteger getMaxApprovals() {
//        return maxApprovals;
//    }
//
//    public void setMaxApprovals(BigInteger maxApprovals) {
//        this.maxApprovals = maxApprovals;
//    }
//
//    @Basic
//    @Column(name = "NAME")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Basic
//    @Column(name = "STATUS")
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//
//    @Basic
//    @Column(name = "TIME_CREATED")
//    public Date getTimeCreated() {
//        return timeCreated;
//    }
//
//    public void setTimeCreated(Date timeCreated) {
//        this.timeCreated = timeCreated;
//    }
//
//    @Basic
//    @Column(name = "TIME_UPDATED")
//    public Date getTimeUpdated() {
//        return timeUpdated;
//    }
//
//    public void setTimeUpdated(Date timeUpdated) {
//        this.timeUpdated = timeUpdated;
//    }
//
//    @Basic
//    @Column(name = "UPDATED_BY")
//    public BigInteger getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(BigInteger updatedBy) {
//        this.updatedBy = updatedBy;
//    }
//
//    /*public List<Permission> getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(List<Permission> permissions) {
//        this.permissions = permissions;
//    }
//
//    public boolean isHas_role() {
//        return has_role;
//    }
//
//    public void setHas_role(boolean has_role) {
//        this.has_role = has_role;
//    }*/
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Role role = (Role) o;
//        return id == role.id && approvalStatus == role.approvalStatus && businessEntityId == role.businessEntityId && createdBy == role.createdBy && currentApprovalLevel == role.currentApprovalLevel && maxApprovals == role.maxApprovals && status == role.status && updatedBy == role.updatedBy && Objects.equals(name, role.name) && Objects.equals(timeCreated, role.timeCreated) && Objects.equals(timeUpdated, role.timeUpdated);
//    }
//
//
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, approvalStatus, businessEntityId, createdBy, currentApprovalLevel, maxApprovals, name, status, timeCreated, timeUpdated, updatedBy);
//    }
//}
