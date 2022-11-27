package com.swl.wallet.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;

import com.swl.wallet.api.request.TransactionRequest; 

/**
 * @author SanWaiLwin
 * 
 */
public class TransactionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String apiCaller;
	private BillDTO billDto;
	private BigDecimal amount;
	private String referenceNo;
	private String phoneNo;
	private String transactionDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApiCaller() {
		return apiCaller;
	}

	public void setApiCaller(String apiCaller) {
		this.apiCaller = apiCaller;
	}

	public BillDTO getBillDto() {
		return billDto;
	}

	public void setBillDto(BillDTO billDto) {
		this.billDto = billDto;
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

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public TransactionDTO convertToDTO(@Valid TransactionRequest req) {
		TransactionDTO dto = new TransactionDTO();
		dto.setApiCaller(req.getApiCaller());
		dto.setBillDto(new BillDTO(req.getBillId()));
		dto.setAmount(req.getAmount());
		dto.setReferenceNo(req.getReferenceNo());
		dto.setPhoneNo(req.getPhoneNo());
		return dto;
	} 

}
