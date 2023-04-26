//package com.pinnoserv.portal.entity;
//
//import javax.persistence.*;
//import java.math.BigInteger;
//import java.sql.Timestamp;
//import java.util.Collection;
//import java.util.Objects;
//
//@Entity
//public class Loan {
//    private BigInteger loanId;
//    private String loanNumber;
//    private String cbsLoanNumber;
//    private BigInteger customerIdFk;
//    private BigInteger productIdFk;
//    private Boolean amount;
//    private Boolean period;
//    private Boolean interest;
//    private String loanStatus;
//    private String approvalStatus;
//    private Boolean parentId;
//    private BigInteger processingStatus;
//    private String type;
//    private Timestamp timeInitiated;
//    private Timestamp timeApproved;
//    private Boolean loanBalance;
//    private Boolean principalRepaid;
//    private BigInteger interestRepaid;
//    private Boolean interestTakenUpfront;
//    private Boolean totalCharges;
//    private Boolean customerApprovals;
//    private Boolean customerApprovalLevel;
//    private BigInteger requestedBy;
//    private Boolean channelId;
//    private String accountNo;
//    private String description;
//    private Boolean creditScoreLogId;
//    private Timestamp lastUpdated;
//    private Customer customerByCustomerIdFk;
//    private Product productByProductIdFk;
//    private Collection<LoanPayment> loanPaymentsByLoanId;
//    private Collection<LoanSchedule> loanSchedulesByLoanId;
//    private Collection<Transaction> transactionsByLoanId;
//
//    @Id
//    @Column(name = "LOAN_ID")
//    public BigInteger getLoanId() {
//        return loanId;
//    }
//
//    public void setLoanId(BigInteger loanId) {
//        this.loanId = loanId;
//    }
//
//    @Basic
//    @Column(name = "LOAN_NUMBER")
//    public String getLoanNumber() {
//        return loanNumber;
//    }
//
//    public void setLoanNumber(String loanNumber) {
//        this.loanNumber = loanNumber;
//    }
//
//    @Basic
//    @Column(name = "CBS_LOAN_NUMBER")
//    public String getCbsLoanNumber() {
//        return cbsLoanNumber;
//    }
//
//    public void setCbsLoanNumber(String cbsLoanNumber) {
//        this.cbsLoanNumber = cbsLoanNumber;
//    }
//
//    @Basic
//    @Column(name = "CUSTOMER_ID_FK")
//    public BigInteger isCustomerIdFk() {
//        return customerIdFk;
//    }
//
//    public void setCustomerIdFk(BigInteger customerIdFk) {
//        this.customerIdFk = customerIdFk;
//    }
//
//    @Basic
//    @Column(name = "PRODUCT_ID_FK")
//    public BigInteger getProductIdFk() {
//        return productIdFk;
//    }
//
//    public void setProductIdFk(BigInteger productIdFk) {
//        this.productIdFk = productIdFk;
//    }
//
//    @Basic
//    @Column(name = "AMOUNT")
//    public Boolean getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Boolean amount) {
//        this.amount = amount;
//    }
//
//    @Basic
//    @Column(name = "PERIOD")
//    public Boolean getPeriod() {
//        return period;
//    }
//
//    public void setPeriod(Boolean period) {
//        this.period = period;
//    }
//
//    @Basic
//    @Column(name = "INTEREST")
//    public Boolean getInterest() {
//        return interest;
//    }
//
//    public void setInterest(Boolean interest) {
//        this.interest = interest;
//    }
//
//    @Basic
//    @Column(name = "LOAN_STATUS")
//    public String getLoanStatus() {
//        return loanStatus;
//    }
//
//    public void setLoanStatus(String loanStatus) {
//        this.loanStatus = loanStatus;
//    }
//
//    @Basic
//    @Column(name = "APPROVAL_STATUS")
//    public String getApprovalStatus() {
//        return approvalStatus;
//    }
//
//    public void setApprovalStatus(String approvalStatus) {
//        this.approvalStatus = approvalStatus;
//    }
//
//    @Basic
//    @Column(name = "PARENT_ID")
//    public Boolean getParentId() {
//        return parentId;
//    }
//
//    public void setParentId(Boolean parentId) {
//        this.parentId = parentId;
//    }
//
//    @Basic
//    @Column(name = "PROCESSING_STATUS")
//    public BigInteger getProcessingStatus() {
//        return processingStatus;
//    }
//
//    public void setProcessingStatus(BigInteger processingStatus) {
//        this.processingStatus = processingStatus;
//    }
//
//    @Basic
//    @Column(name = "TYPE")
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
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
//    @Column(name = "TIME_APPROVED")
//    public Timestamp getTimeApproved() {
//        return timeApproved;
//    }
//
//    public void setTimeApproved(Timestamp timeApproved) {
//        this.timeApproved = timeApproved;
//    }
//
//    @Basic
//    @Column(name = "LOAN_BALANCE")
//    public Boolean getLoanBalance() {
//        return loanBalance;
//    }
//
//    public void setLoanBalance(Boolean loanBalance) {
//        this.loanBalance = loanBalance;
//    }
//
//    @Basic
//    @Column(name = "PRINCIPAL_REPAID")
//    public Boolean getPrincipalRepaid() {
//        return principalRepaid;
//    }
//
//    public void setPrincipalRepaid(Boolean principalRepaid) {
//        this.principalRepaid = principalRepaid;
//    }
//
//    @Basic
//    @Column(name = "INTEREST_REPAID")
//    public BigInteger getInterestRepaid() {
//        return interestRepaid;
//    }
//
//    public void setInterestRepaid(BigInteger interestRepaid) {
//        this.interestRepaid = interestRepaid;
//    }
//
//    @Basic
//    @Column(name = "INTEREST_TAKEN_UPFRONT")
//    public Boolean getInterestTakenUpfront() {
//        return interestTakenUpfront;
//    }
//
//    public void setInterestTakenUpfront(Boolean interestTakenUpfront) {
//        this.interestTakenUpfront = interestTakenUpfront;
//    }
//
//    @Basic
//    @Column(name = "TOTAL_CHARGES")
//    public Boolean getTotalCharges() {
//        return totalCharges;
//    }
//
//    public void setTotalCharges(Boolean totalCharges) {
//        this.totalCharges = totalCharges;
//    }
//
//    @Basic
//    @Column(name = "CUSTOMER_APPROVALS")
//    public Boolean getCustomerApprovals() {
//        return customerApprovals;
//    }
//
//    public void setCustomerApprovals(Boolean customerApprovals) {
//        this.customerApprovals = customerApprovals;
//    }
//
//    @Basic
//    @Column(name = "CUSTOMER_APPROVAL_LEVEL")
//    public Boolean getCustomerApprovalLevel() {
//        return customerApprovalLevel;
//    }
//
//    public void setCustomerApprovalLevel(Boolean customerApprovalLevel) {
//        this.customerApprovalLevel = customerApprovalLevel;
//    }
//
//    @Basic
//    @Column(name = "REQUESTED_BY")
//    public BigInteger getRequestedBy() {
//        return requestedBy;
//    }
//
//    public void setRequestedBy(BigInteger requestedBy) {
//        this.requestedBy = requestedBy;
//    }
//
//    @Basic
//    @Column(name = "CHANNEL_ID")
//    public Boolean getChannelId() {
//        return channelId;
//    }
//
//    public void setChannelId(Boolean channelId) {
//        this.channelId = channelId;
//    }
//
//    @Basic
//    @Column(name = "ACCOUNT_NO")
//    public String getAccountNo() {
//        return accountNo;
//    }
//
//    public void setAccountNo(String accountNo) {
//        this.accountNo = accountNo;
//    }
//
//    @Basic
//    @Column(name = "DESCRIPTION")
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Basic
//    @Column(name = "CREDIT_SCORE_LOG_ID")
//    public Boolean getCreditScoreLogId() {
//        return creditScoreLogId;
//    }
//
//    public void setCreditScoreLogId(Boolean creditScoreLogId) {
//        this.creditScoreLogId = creditScoreLogId;
//    }
//
//    @Basic
//    @Column(name = "LAST_UPDATED")
//    public Timestamp getLastUpdated() {
//        return lastUpdated;
//    }
//
//    public void setLastUpdated(Timestamp lastUpdated) {
//        this.lastUpdated = lastUpdated;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Loan loan = (Loan) o;
//        return loanId == loan.loanId && customerIdFk == loan.customerIdFk && productIdFk == loan.productIdFk && processingStatus == loan.processingStatus && interestRepaid == loan.interestRepaid && requestedBy == loan.requestedBy && Objects.equals(loanNumber, loan.loanNumber) && Objects.equals(cbsLoanNumber, loan.cbsLoanNumber) && Objects.equals(amount, loan.amount) && Objects.equals(period, loan.period) && Objects.equals(interest, loan.interest) && Objects.equals(loanStatus, loan.loanStatus) && Objects.equals(approvalStatus, loan.approvalStatus) && Objects.equals(parentId, loan.parentId) && Objects.equals(type, loan.type) && Objects.equals(timeInitiated, loan.timeInitiated) && Objects.equals(timeApproved, loan.timeApproved) && Objects.equals(loanBalance, loan.loanBalance) && Objects.equals(principalRepaid, loan.principalRepaid) && Objects.equals(interestTakenUpfront, loan.interestTakenUpfront) && Objects.equals(totalCharges, loan.totalCharges) && Objects.equals(customerApprovals, loan.customerApprovals) && Objects.equals(customerApprovalLevel, loan.customerApprovalLevel) && Objects.equals(channelId, loan.channelId) && Objects.equals(accountNo, loan.accountNo) && Objects.equals(description, loan.description) && Objects.equals(creditScoreLogId, loan.creditScoreLogId) && Objects.equals(lastUpdated, loan.lastUpdated);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(loanId, loanNumber, cbsLoanNumber, customerIdFk, productIdFk, amount, period, interest, loanStatus, approvalStatus, parentId, processingStatus, type, timeInitiated, timeApproved, loanBalance, principalRepaid, interestRepaid, interestTakenUpfront, totalCharges, customerApprovals, customerApprovalLevel, requestedBy, channelId, accountNo, description, creditScoreLogId, lastUpdated);
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
//
//    @ManyToOne
//    @JoinColumn(name = "PRODUCT_ID_FK", referencedColumnName = "PRODUCT_ID", nullable = false, insertable=false, updatable=false)
//    public Product getProductByProductIdFk() {
//        return productByProductIdFk;
//    }
//
//    public void setProductByProductIdFk(Product productByProductIdFk) {
//        this.productByProductIdFk = productByProductIdFk;
//    }
//
//    @OneToMany(mappedBy = "loanByLoanIdFk")
//    public Collection<LoanPayment> getLoanPaymentsByLoanId() {
//        return loanPaymentsByLoanId;
//    }
//
//    public void setLoanPaymentsByLoanId(Collection<LoanPayment> loanPaymentsByLoanId) {
//        this.loanPaymentsByLoanId = loanPaymentsByLoanId;
//    }
//
//    @OneToMany(mappedBy = "loanByLoanIdFk")
//    public Collection<LoanSchedule> getLoanSchedulesByLoanId() {
//        return loanSchedulesByLoanId;
//    }
//
//    public void setLoanSchedulesByLoanId(Collection<LoanSchedule> loanSchedulesByLoanId) {
//        this.loanSchedulesByLoanId = loanSchedulesByLoanId;
//    }
//
//    @OneToMany(mappedBy = "loanByLoanIdFk")
//    public Collection<Transaction> getTransactionsByLoanId() {
//        return transactionsByLoanId;
//    }
//
//    public void setTransactionsByLoanId(Collection<Transaction> transactionsByLoanId) {
//        this.transactionsByLoanId = transactionsByLoanId;
//    }
//}
