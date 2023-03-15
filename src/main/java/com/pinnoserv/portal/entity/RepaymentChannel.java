package com.pinnoserv.portal.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "REPAYMENT_CHANNEL")
public class RepaymentChannel {
    private BigInteger repaymentChannelId;
    private BigInteger productIdFk;
    private BigInteger channelIdFk;
    private String intrash;
    private Product productByProductIdFk;
    private Channel channelByChannelIdFk;

    @Id
    @Column(name = "REPAYMENT_CHANNEL_ID")
    public BigInteger getRepaymentChannelId() {
        return repaymentChannelId;
    }

    public void setRepaymentChannelId(BigInteger repaymentChannelId) {
        this.repaymentChannelId = repaymentChannelId;
    }

    @Basic
    @Column(name = "PRODUCT_ID_FK")
    public BigInteger getProductIdFk() {
        return productIdFk;
    }

    public void setProductIdFk(BigInteger productIdFk) {
        this.productIdFk = productIdFk;
    }

    @Basic
    @Column(name = "CHANNEL_ID_FK")
    public BigInteger getChannelIdFk() {
        return channelIdFk;
    }

    public void setChannelIdFk(BigInteger channelIdFk) {
        this.channelIdFk = channelIdFk;
    }

    @Basic
    @Column(name = "INTRASH")
    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepaymentChannel that = (RepaymentChannel) o;
        return repaymentChannelId == that.repaymentChannelId && productIdFk == that.productIdFk && channelIdFk == that.channelIdFk && Objects.equals(intrash, that.intrash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repaymentChannelId, productIdFk, channelIdFk, intrash);
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID_FK", referencedColumnName = "PRODUCT_ID", nullable = false, insertable=false, updatable=false)
    public Product getProductByProductIdFk() {
        return productByProductIdFk;
    }

    public void setProductByProductIdFk(Product productByProductIdFk) {
        this.productByProductIdFk = productByProductIdFk;
    }

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID_FK", referencedColumnName = "CHANNEL_ID", nullable = false, insertable=false, updatable=false)
    public Channel getChannelByChannelIdFk() {
        return channelByChannelIdFk;
    }

    public void setChannelByChannelIdFk(Channel channelByChannelIdFk) {
        this.channelByChannelIdFk = channelByChannelIdFk;
    }
}
