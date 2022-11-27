package com.swl.wallet.api.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author SanWaiLwin
 *
 */
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "User name is required.")
	@NotNull(message = "User name must not be null.")
	private String userName;

	@NotBlank(message = "Password is required.")
	@NotNull(message = "Password must not be null.")
	private String password;

	public LoginRequest() {
		super();
	}

	public LoginRequest(@NotBlank String userName, @NotBlank String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
