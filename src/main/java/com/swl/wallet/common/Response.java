package com.swl.wallet.common;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.swl.wallet.util.CommonUtil;
import com.swl.wallet.util.FieldErrors;

/**
 * @author SanWaiLwin
 * 
 */
@JsonInclude(value = Include.NON_NULL)
public class Response<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status_message;

	private String date_time;

	private T data;

	private List<FieldErrors> errorList;

	private List<?> billers;

	public Response() {
		super();
	}

	public Response(List<FieldErrors> errors) {
		super();
		if (CommonUtil.validList(errors)) {
			this.errorList = errors;
		}
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<FieldErrors> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<FieldErrors> errorList) {
		this.errorList = errorList;
	}

	public List<?> getBillers() {
		return billers;
	}

	public void setBillers(List<?> billers) {
		this.billers = billers;
	}

}
