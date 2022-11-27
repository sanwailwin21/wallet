package com.swl.wallet.api.response;

import java.io.Serializable;

/**
 * @author SanWaiLwin
 *
 */
public class LoginResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status_message;
	private String access_token;

	public LoginResponse(String status_message) {
		super();
		this.status_message = status_message;
	}

	public LoginResponse(String status_message, String access_token) {
		super();
		this.status_message = status_message;
		this.access_token = access_token;
	}

	public String getStatus_message() {
		return status_message;
	}

	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

}
