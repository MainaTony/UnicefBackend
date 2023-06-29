package com.pinnoserv.portal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "business_type")
public class BusinessType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "business_code")
    private Long businessCode;
    @Column(name = "description")
    private String description;
    @Column(name = "date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "in_trash")
    private String inTrash;
//    @OneToMany(mappedBy = "businessTypeByBusinessTypeFk")
//    private Collection<Organisation> organisationsById;

//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
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
//    public Integer getCreatedByFk() {
//        return createdByFk;
//    }
//
//    public void setCreatedByFk(Integer createdByFk) {
//        this.createdByFk = createdByFk;
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
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BusinessTypeModel that = (BusinessTypeModel) o;
//        return id == that.id && Objects.equals(type, that.type) && Objects.equals(description, that.description) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(createdByFk, that.createdByFk) && Objects.equals(intrash, that.intrash);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, type, description, dateCreated, createdByFk, intrash);
//    }


//    public Collection<Organisation> getOrganisationsById() {
//        return organisationsById;
//    }
//
//    public void setOrganisationsById(Collection<Organisation> organisationsById) {
//        this.organisationsById = organisationsById;
//    }
}
