//package com.pinnoserv.portal.entity;
//
//import javax.persistence.*;
//import java.math.BigInteger;
//import java.util.Date;
//import java.util.Objects;
//
//@Entity
//@Table(name = "PERMISSION_MAP")
//public class PermissionMap {
//    private BigInteger id;
//    private BigInteger approvalStatus;
//    private BigInteger createdBy;
//    private BigInteger currentApprovalLevel;
//    private BigInteger maxApprovals;
//    private BigInteger status;
//    private Date timeCreated;
//    private Date timeUpdated;
//    private BigInteger updatedBy;
//    private BigInteger permissionId;
//    private BigInteger roleId;
//    /*@JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID")
//    @ManyToOne(optional = false)
//    private Permission permissions;
//    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
//    @ManyToOne(optional = false)
//    private Role role;*/
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
//    @Column(name = "STATUS")
//    public BigInteger getStatus() {
//        return status;
//    }
//
//    public void setStatus(BigInteger status) {
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
//    @Basic
//    @Column(name = "PERMISSION_ID")
//    public BigInteger getPermissionId() {
//        return permissionId;
//    }
//
//    public void setPermissionId(BigInteger permissionId) {
//        this.permissionId = permissionId;
//    }
//
//    @Basic
//    @Column(name = "ROLE_ID")
//    public BigInteger getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(BigInteger roleId) {
//        this.roleId = roleId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PermissionMap that = (PermissionMap) o;
//        return id == that.id && approvalStatus == that.approvalStatus && createdBy == that.createdBy && currentApprovalLevel == that.currentApprovalLevel && maxApprovals == that.maxApprovals && status == that.status && updatedBy == that.updatedBy && permissionId == that.permissionId && roleId == that.roleId && Objects.equals(timeCreated, that.timeCreated) && Objects.equals(timeUpdated, that.timeUpdated);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, approvalStatus, createdBy, currentApprovalLevel, maxApprovals, status, timeCreated, timeUpdated, updatedBy, permissionId, roleId);
//    }
//
//    /*public Permission getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(Permission permissions) {
//        this.permissions = permissions;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role roleId) {
//        this.role = roleId;
//    }*/
//}
