package com.swl.wallet.util;

import java.io.Serializable;

/**
 * @author SanWaiLwin
 * 
 */
public class FieldErrors implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status_message;

	public FieldErrors() {
		super();
	}

	public FieldErrors(String status_message) {
		super();
		this.status_message = status_message;
	}

	public String getStatus_message() {
		return status_message;
	}

	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}

}
