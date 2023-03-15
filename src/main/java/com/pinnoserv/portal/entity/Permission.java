package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PERMISSION")
public class Permission {
    private BigInteger id;
    private boolean approvalStatus;
    private BigInteger createdBy;
    private BigInteger currentApprovalLevel;
    private String description;
    private String icon;
    private short isMenu;
    private BigInteger maxApprovals;
    private String menuName;
    private String menuPosition;
    private String module;
    private String name;
    private BigInteger parentId;
    private boolean status;
    private Date timeCreated;
    private Date timeUpdated;
    private BigInteger updatedBy;
    private String url;

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
    public boolean isApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(boolean approvalStatus) {
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
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ICON")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "IS_MENU")
    public short getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(short isMenu) {
        this.isMenu = isMenu;
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
    @Column(name = "MENU_NAME")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "MENU_POSITION")
    public String getMenuPosition() {
        return menuPosition;
    }

    public void setMenuPosition(String menuPosition) {
        this.menuPosition = menuPosition;
    }

    @Basic
    @Column(name = "MODULE")
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
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
    @Column(name = "PARENT_ID")
    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "STATUS")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return id == that.id && approvalStatus == that.approvalStatus && createdBy == that.createdBy && currentApprovalLevel == that.currentApprovalLevel && isMenu == that.isMenu && maxApprovals == that.maxApprovals && parentId == that.parentId && status == that.status && updatedBy == that.updatedBy && Objects.equals(description, that.description) && Objects.equals(icon, that.icon) && Objects.equals(menuName, that.menuName) && Objects.equals(menuPosition, that.menuPosition) && Objects.equals(module, that.module) && Objects.equals(name, that.name) && Objects.equals(timeCreated, that.timeCreated) && Objects.equals(timeUpdated, that.timeUpdated) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, approvalStatus, createdBy, currentApprovalLevel, description, icon, isMenu, maxApprovals, menuName, menuPosition, module, name, parentId, status, timeCreated, timeUpdated, updatedBy, url);
    }
}
