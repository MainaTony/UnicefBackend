//package com.pinnoserv.portal.entity;
//
//import javax.persistence.*;
//import java.math.BigInteger;
//import java.sql.Timestamp;
//import java.util.Objects;
//
//@Entity
//public class Transaction {
//    private BigInteger transactionId;
//    private String trxId;
//    private BigInteger loanIdFk;
//    private BigInteger customerIdFk;
//    private String msisdn;
//    private BigInteger amount;
//    private BigInteger primaryParty;
//    private BigInteger receiverParty;
//    private BigInteger trxStatus;
//    private String trxType;
//    private BigInteger intermediateStatus;
//    private Timestamp timeInitiated;
//    private Timestamp timeCompleted;
//    private String conversationId;
//    private String origConversationId;
//    private String sessionId;
//    private BigInteger failCount;
//    private BigInteger disbursementChannel;
//    private String referenceId;
//    private String intrash;
//    private Loan loanByLoanIdFk;
//    private Customer customerByCustomerIdFk;
//
//    @Id
//    @Column(name = "TRANSACTION_ID")
//    public BigInteger getTransactionId() {
//        return transactionId;
//    }
//
//    public void setTransactionId(BigInteger transactionId) {
//        this.transactionId = transactionId;
//    }
//
//    @Basic
//    @Column(name = "TRX_ID")
//    public String getTrxId() {
//        return trxId;
//    }
//
//    public void setTrxId(String trxId) {
//        this.trxId = trxId;
//    }
//
//    @Basic
//    @Column(name = "LOAN_ID_FK")
//    public BigInteger getLoanIdFk() {
//        return loanIdFk;
//    }
//
//    public void setLoanIdFk(BigInteger loanIdFk) {
//        this.loanIdFk = loanIdFk;
//    }
//
//    @Basic
//    @Column(name = "CUSTOMER_ID_FK")
//    public BigInteger getCustomerIdFk() {
//        return customerIdFk;
//    }
//
//    public void setCustomerIdFk(BigInteger customerIdFk) {
//        this.customerIdFk = customerIdFk;
//    }
//
//    @Basic
//    @Column(name = "MSISDN")
//    public String getMsisdn() {
//        return msisdn;
//    }
//
//    public void setMsisdn(String msisdn) {
//        this.msisdn = msisdn;
//    }
//
//    @Basic
//    @Column(name = "AMOUNT")
//    public BigInteger getAmount() {
//        return amount;
//    }
//
//    public void setAmount(BigInteger amount) {
//        this.amount = amount;
//    }
//
//    @Basic
//    @Column(name = "PRIMARY_PARTY")
//    public BigInteger getPrimaryParty() {
//        return primaryParty;
//    }
//
//    public void setPrimaryParty(BigInteger primaryParty) {
//        this.primaryParty = primaryParty;
//    }
//
//    @Basic
//    @Column(name = "RECEIVER_PARTY")
//    public BigInteger getReceiverParty() {
//        return receiverParty;
//    }
//
//    public void setReceiverParty(BigInteger receiverParty) {
//        this.receiverParty = receiverParty;
//    }
//
//    @Basic
//    @Column(name = "TRX_STATUS")
//    public BigInteger getTrxStatus() {
//        return trxStatus;
//    }
//
//    public void setTrxStatus(BigInteger trxStatus) {
//        this.trxStatus = trxStatus;
//    }
//
//    @Basic
//    @Column(name = "TRX_TYPE")
//    public String getTrxType() {
//        return trxType;
//    }
//
//    public void setTrxType(String trxType) {
//        this.trxType = trxType;
//    }
//
//    @Basic
//    @Column(name = "INTERMEDIATE_STATUS")
//    public BigInteger getIntermediateStatus() {
//        return intermediateStatus;
//    }
//
//    public void setIntermediateStatus(BigInteger intermediateStatus) {
//        this.intermediateStatus = intermediateStatus;
//    }
//
//    @Basic
//    @Column(name = "TIME_INITIATED")
//    public Timestamp getTimeInitiated() {
//        return timeInitiated;
//    }
//
//    public void setTimeInitiated(Timestamp timeInitiated) {
//        this.timeInitiated = timeInitiated;
//    }
//
//    @Basic
//    @Column(name = "TIME_COMPLETED")
//    public Timestamp getTimeCompleted() {
//        return timeCompleted;
//    }
//
//    public void setTimeCompleted(Timestamp timeCompleted) {
//        this.timeCompleted = timeCompleted;
//    }
//
//    @Basic
//    @Column(name = "CONVERSATION_ID")
//    public String getConversationId() {
//        return conversationId;
//    }
//
//    public void setConversationId(String conversationId) {
//        this.conversationId = conversationId;
//    }
//
//    @Basic
//    @Column(name = "ORIG_CONVERSATION_ID")
//    public String getOrigConversationId() {
//        return origConversationId;
//    }
//
//    public void setOrigConversationId(String origConversationId) {
//        this.origConversationId = origConversationId;
//    }
//
//    @Basic
//    @Column(name = "SESSION_ID")
//    public String getSessionId() {
//        return sessionId;
//    }
//
//    public void setSessionId(String sessionId) {
//        this.sessionId = sessionId;
//    }
//
//    @Basic
//    @Column(name = "FAIL_COUNT")
//    public BigInteger getFailCount() {
//        return failCount;
//    }
//
//    public void setFailCount(BigInteger failCount) {
//        this.failCount = failCount;
//    }
//
//    @Basic
//    @Column(name = "DISBURSEMENT_CHANNEL")
//    public BigInteger getDisbursementChannel() {
//        return disbursementChannel;
//    }
//
//    public void setDisbursementChannel(BigInteger disbursementChannel) {
//        this.disbursementChannel = disbursementChannel;
//    }
//
//    @Basic
//    @Column(name = "REFERENCE_ID")
//    public String getReferenceId() {
//        return referenceId;
//    }
//
//    public void setReferenceId(String referenceId) {
//        this.referenceId = referenceId;
//    }
//
//    @Basic
//    @Column(name = "INTRASH")
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
//        Transaction that = (Transaction) o;
//        return transactionId == that.transactionId && loanIdFk == that.loanIdFk && customerIdFk == that.customerIdFk && Objects.equals(trxId, that.trxId) && Objects.equals(msisdn, that.msisdn) && Objects.equals(amount, that.amount) && Objects.equals(primaryParty, that.primaryParty) && Objects.equals(receiverParty, that.receiverParty) && Objects.equals(trxStatus, that.trxStatus) && Objects.equals(trxType, that.trxType) && Objects.equals(intermediateStatus, that.intermediateStatus) && Objects.equals(timeInitiated, that.timeInitiated) && Objects.equals(timeCompleted, that.timeCompleted) && Objects.equals(conversationId, that.conversationId) && Objects.equals(origConversationId, that.origConversationId) && Objects.equals(sessionId, that.sessionId) && Objects.equals(failCount, that.failCount) && Objects.equals(disbursementChannel, that.disbursementChannel) && Objects.equals(referenceId, that.referenceId) && Objects.equals(intrash, that.intrash);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(transactionId, trxId, loanIdFk, customerIdFk, msisdn, amount, primaryParty, receiverParty, trxStatus, trxType, intermediateStatus, timeInitiated, timeCompleted, conversationId, origConversationId, sessionId, failCount, disbursementChannel, referenceId, intrash);
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "LOAN_ID_FK", referencedColumnName = "LOAN_ID", nullable = false, insertable=false, updatable=false)
//    public Loan getLoanByLoanIdFk() {
//        return loanByLoanIdFk;
//    }
//
//    public void setLoanByLoanIdFk(Loan loanByLoanIdFk) {
//        this.loanByLoanIdFk = loanByLoanIdFk;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "CUSTOMER_ID_FK", referencedColumnName = "CUSTOMER_ID", nullable = false, insertable=false, updatable=false)
//    public Customer getCustomerByCustomerIdFk() {
//        return customerByCustomerIdFk;
//    }
//
//    public void setCustomerByCustomerIdFk(Customer customerByCustomerIdFk) {
//        this.customerByCustomerIdFk = customerByCustomerIdFk;
//    }
//}
