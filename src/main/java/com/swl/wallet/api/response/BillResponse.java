package com.swl.wallet.api.response;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.swl.wallet.dto.BillDTO;
import com.swl.wallet.util.CommonConstant;
import com.swl.wallet.util.CommonUtil;

/**
 * @author SanWaiLwin
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class BillResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status_message;
	private String date_time;
	private Long bill_id;
	private String name;
	private String description;

	public BillResponse() {
		super();
	}

	public BillResponse(String status_message, String date_time, Long bill_id, String name, String description) {
		super();
		this.status_message = status_message;
		this.date_time = date_time;
		this.bill_id = bill_id;
		this.name = name;
		this.description = description;
	}

	public String getStatus_message() {
		return status_message;
	}

	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public Long getBill_id() {
		return bill_id;
	}

	public void setBill_id(Long bill_id) {
		this.bill_id = bill_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BillResponse prepareForBillResponse(BillDTO dto) {
		BillResponse response = new BillResponse();
		response.setBill_id(dto.getId());
		response.setName(CommonUtil.checkValidString(dto.getName()));
		response.setDescription(CommonUtil.checkValidString(dto.getDescription()));
		return response;
	}

	public BillResponse convertFromDto(BillDTO dto) {
		BillResponse response = new BillResponse();
		response.setBill_id(dto.getId());
		response.setName(CommonUtil.checkValidString(dto.getName()));
		response.setDescription(CommonUtil.checkValidString(dto.getDescription()));
		response.setStatus_message("Bill Top up is successfully saved in the system.");
		response.setDate_time(CommonUtil.dateToString(CommonConstant.STD_DATE_FORMAT, new Date()));
		return response;
	}
}
