package com.swl.wallet.api.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author SanWaiLwin
 * 
 */
public class TransactionRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String apiCaller;

	@Min(value = 1, message = "Bill'id must not be less than 1.")
	private Long billId;

	@Min(value = 1, message = "Amount must not be less than 1.")
	@Max(value = 100000, message = "Amount must not be greater than 100000.")
	private BigDecimal amount;

	@NotBlank(message = "Reference number is required.")
	@NotNull(message = "Reference number must not be null.")
	private String referenceNo;

	@NotBlank(message = "Phone number is required.")
	@NotNull(message = "Phone number must not be null.")
	private String phoneNo;

	public String getApiCaller() {
		return apiCaller;
	}

	public void setApiCaller(String apiCaller) {
		this.apiCaller = apiCaller;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
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

}
