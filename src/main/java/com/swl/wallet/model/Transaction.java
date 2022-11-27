package com.swl.wallet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.swl.wallet.model.common.BaseEntity;

/**
 * @author SanWaiLwin
 * 
 */
@Entity
@Table(name = "transaction")
public class Transaction extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ApiCaller")
	private String apiCaller;

	@ManyToOne
	@JoinColumn(name = "Bill_Id")
	private Bill bill;

	@Column(name = "Amount")
	private BigDecimal amount;

	@Column(name = "ReferenceNo")
	private String referenceNo;

	@Column(name = "PoneNo")
	private String phoneNo;

	@Column(name = "TransactionDate")
	private Date transactionDate;

	public String getApiCaller() {
		return apiCaller;
	}

	public void setApiCaller(String apiCaller) {
		this.apiCaller = apiCaller;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

}
