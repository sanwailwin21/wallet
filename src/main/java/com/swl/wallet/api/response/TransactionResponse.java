package com.swl.wallet.api.response;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.swl.wallet.dto.TransactionDTO;
import com.swl.wallet.util.CommonConstant;
import com.swl.wallet.util.CommonUtil;

/**
 * @author SanWaiLwin
 * 
 */
@JsonInclude(value = Include.NON_NULL)
public class TransactionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status_message;
	private Long transaction_id;
	private BigDecimal amount;
	private String transaction_date;
	private String phone_number;
	private String api_caller;
	private Long bill_id;

	public String getStatus_message() {
		return status_message;
	}

	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}

	public Long getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getApi_caller() {
		return api_caller;
	}

	public void setApi_caller(String api_caller) {
		this.api_caller = api_caller;
	}

	public Long getBill_id() {
		return bill_id;
	}

	public void setBill_id(Long bill_id) {
		this.bill_id = bill_id;
	}

	public TransactionResponse convertFromDto(TransactionDTO dto) {
		TransactionResponse response = new TransactionResponse();
		response.setStatus_message("Transaction is successful!");
		response.setTransaction_id(dto.getId());
		response.setAmount(dto.getAmount());
		response.setTransaction_date(CommonUtil.ChangeFormatDateToDateString(CommonConstant.STD_DATE_TIME_FORMAT,
				CommonConstant.STD_DATE_FORMAT, dto.getTransactionDate()));
		response.setPhone_number(dto.getPhoneNo());
		return response;
	}

	public TransactionResponse convertFromDTOs(TransactionDTO dto) {
		TransactionResponse response = new TransactionResponse();
		response.setApi_caller(CommonUtil.checkValidString(dto.getApiCaller()));
		response.setBill_id(dto.getBillDto().getId());
		response.setAmount(dto.getAmount());
		response.setTransaction_date(CommonUtil.ChangeFormatDateToDateString(CommonConstant.STD_DATE_TIME_FORMAT,
				CommonConstant.STD_DATE_FORMAT, dto.getTransactionDate()));
		response.setPhone_number(dto.getPhoneNo());
		return response;
	}
}
