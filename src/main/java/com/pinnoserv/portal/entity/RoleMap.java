package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ROLE_MAP")
public class RoleMap {
    private BigInteger id;
    private BigInteger approvalStatus;
    private BigInteger createdBy;
    private BigInteger currentApprovalLevel;
    private BigInteger maxApprovals;
    private BigInteger status;
    private Date timeCreated;
    private Date timeUpdated;
    private BigInteger updatedBy;
    private BigInteger roleId;
    private BigInteger userId;
    /*@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Role roles;*/
    /*@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private User users;*/

    @Id
    @Column(name = "ID")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "APPROVAL_STATUS")
    public BigInteger getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(BigInteger approvalStatus) {
        this.approvalStatus = approvalStatus;
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
    @Column(name = "CURRENT_APPROVAL_LEVEL")
    public BigInteger getCurrentApprovalLevel() {
        return currentApprovalLevel;
    }

    public void setCurrentApprovalLevel(BigInteger currentApprovalLevel) {
        this.currentApprovalLevel = currentApprovalLevel;
    }

    @Basic
    @Column(name = "MAX_APPROVALS")
    public BigInteger getMaxApprovals() {
        return maxApprovals;
    }

    public void setMaxApprovals(BigInteger maxApprovals) {
        this.maxApprovals = maxApprovals;
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
    @Column(name = "TIME_CREATED")
    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Basic
    @Column(name = "TIME_UPDATED")
    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
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
    @Column(name = "ROLE_ID")
    public BigInteger getRoleId() {
        return roleId;
    }

    public void setRoleId(BigInteger roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "USER_ID")
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleMap roleMap = (RoleMap) o;
        return id == roleMap.id && approvalStatus == roleMap.approvalStatus && createdBy == roleMap.createdBy && currentApprovalLevel == roleMap.currentApprovalLevel && maxApprovals == roleMap.maxApprovals && status == roleMap.status && updatedBy == roleMap.updatedBy && roleId == roleMap.roleId && userId == roleMap.userId && Objects.equals(timeCreated, roleMap.timeCreated) && Objects.equals(timeUpdated, roleMap.timeUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, approvalStatus, createdBy, currentApprovalLevel, maxApprovals, status, timeCreated, timeUpdated, updatedBy, roleId, userId);
    }

    /*public Role getRoles() {
        return roles;
    }

    public void setRoles(Role role) {
        this.roles = role;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }*/
}
