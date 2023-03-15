package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Channel {
    private BigInteger channelId;
    private String name;
    private Date dateCreated;
    private String description;
    private String intrash;
    private String createdBy;
    private String paymentChannel;
    private String channelType;
    private Boolean status;
    private String channelMode;
    private Collection<LoanPayment> loanPaymentsByChannelId;
    private Collection<RepaymentChannel> repaymentChannelsByChannelId;

    @Id
    @Column(name = "CHANNEL_ID")
    public BigInteger getChannelId() {
        return channelId;
    }

    public void setChannelId(BigInteger channelId) {
        this.channelId = channelId;
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
    @Column(name = "DATE_CREATED")
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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
    @Column(name = "INTRASH")
    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }

    @Basic
    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "PAYMENT_CHANNEL")
    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    @Basic
    @Column(name = "CHANNEL_TYPE")
    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    @Basic
    @Column(name = "STATUS")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CHANNEL_MODE")
    public String getChannelMode() {
        return channelMode;
    }

    public void setChannelMode(String channelMode) {
        this.channelMode = channelMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return channelId == channel.channelId && Objects.equals(name, channel.name) && Objects.equals(dateCreated, channel.dateCreated) && Objects.equals(description, channel.description) && Objects.equals(intrash, channel.intrash) && Objects.equals(createdBy, channel.createdBy) && Objects.equals(paymentChannel, channel.paymentChannel) && Objects.equals(channelType, channel.channelType) && Objects.equals(status, channel.status) && Objects.equals(channelMode, channel.channelMode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelId, name, dateCreated, description, intrash, createdBy, paymentChannel, channelType, status, channelMode);
    }

    @OneToMany(mappedBy = "channelByChannelIdFk")
    public Collection<LoanPayment> getLoanPaymentsByChannelId() {
        return loanPaymentsByChannelId;
    }

    public void setLoanPaymentsByChannelId(Collection<LoanPayment> loanPaymentsByChannelId) {
        this.loanPaymentsByChannelId = loanPaymentsByChannelId;
    }

    @OneToMany(mappedBy = "channelByChannelIdFk")
    public Collection<RepaymentChannel> getRepaymentChannelsByChannelId() {
        return repaymentChannelsByChannelId;
    }

    public void setRepaymentChannelsByChannelId(Collection<RepaymentChannel> repaymentChannelsByChannelId) {
        this.repaymentChannelsByChannelId = repaymentChannelsByChannelId;
    }
}
