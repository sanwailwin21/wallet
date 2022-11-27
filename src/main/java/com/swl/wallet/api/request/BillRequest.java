package com.swl.wallet.api.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author SanWaiLwin
 *
 */
public class BillRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Name is required.")
	@NotNull(message = "Name must not be null.")
	private String name;

	private String description;

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

}
