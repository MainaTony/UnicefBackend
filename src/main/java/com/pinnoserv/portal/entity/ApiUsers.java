package com.pinnoserv.portal.entity;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author liam
 */
@Entity
@Table(name = "api_users")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ApiUsers.findAll", query = "SELECT s FROM ApiUsers s"),
        @NamedQuery(name = "ApiUsers.findById", query = "SELECT s FROM ApiUsers s WHERE s.id = :id"),
        @NamedQuery(name = "ApiUsers.findByUsername", query = "SELECT s FROM ApiUsers s WHERE s.username = :username"),
        @NamedQuery(name = "ApiUsers.findByFullName", query = "SELECT s FROM ApiUsers s WHERE s.email = :email"),
        @NamedQuery(name = "ApiUsers.findByIntrash", query = "SELECT s FROM ApiUsers s WHERE s.intrash = :intrash"),
        @NamedQuery(name = "ApiUsers.findByDateCreated", query = "SELECT s FROM ApiUsers s WHERE s.dateCreated = :dateCreated"),
        @NamedQuery(name = "ApiUsers.findByPassword", query = "SELECT s FROM ApiUsers s WHERE s.password = :password"),
        @NamedQuery(name = "ApiUsers.findByAccessChannelId", query = "SELECT s FROM ApiUsers s WHERE s.accessChannelId = :accessChannelId")})
public class ApiUsers implements Serializable {

    private static final long sserialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Integer id;
    @Column(name = "OTP")
    private String otp;
//    @Column(name = "Flag")
//    private Integer flag;
//    @Column(name = "OTP_TIME")
//    private LocalDateTime expirationTime;
    @Size(max = 255)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 255)
    @Column(name = "Email")
    private String email;
    @Column(name = "INTRASH")
    private Integer intrash;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "ORGANISATION_ID_FK")
    private Integer organisationIdFk;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ACCESS_CHANNEL_ID")
    private Integer accessChannelId;

    public ApiUsers() {
    }

    public ApiUsers(Integer id) {
        this.id = id;
    }

//    public ApiUsers(String username, String encodedPassword, String fullname, Integer accessChannelId, Date dateCreated) {
//        this.username = username;
//        this.password = encodedPassword;
//        this.fullName = fullname;
//        this.accessChannelId = accessChannelId;
//        this.dateCreated = dateCreated;
//        ;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Integer getFlag() {
//        return flag;
//    }
//
//    public void setFlag(Integer flag) {
//        this.flag = flag;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String fullName) {
        this.email = fullName;
    }

    public Integer getIntrash() {
        return intrash;
    }

    public void setIntrash(Integer intrash) {
        this.intrash = intrash;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

//    public LocalDateTime getExprationTime() {
//        return expirationTime;
//    }


    @Basic
    @Column(name = "ORGANISATION_ID_FK")
    public Integer getOrganisationIdFk() {
        return organisationIdFk;
    }

    public void setOrganisationIdFk(Integer organisationIdFk) {
        this.organisationIdFk = organisationIdFk;
    }


    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccessChannelId() {
        return accessChannelId;
    }

    public void setAccessChannelId(Integer accessChannelId) {
        this.accessChannelId = accessChannelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApiUsers)) {
            return false;
        }
        ApiUsers other = (ApiUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public ApiUsers(String username, String password, String email, Integer accessChannelId, Integer inTrash, Date dateCreated, Integer organisationIdFk, String otp) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.accessChannelId = accessChannelId;
        this.intrash = inTrash;
        this.dateCreated = dateCreated;
        this.organisationIdFk = organisationIdFk;
        this.otp = otp;
//        this.flag = flag;
//        this.otp = otp;
//        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "com.pinnopay.mobilebanking.entity.ApiUsers[ id=" + id + " ]";
    }

}
