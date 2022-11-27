package com.swl.wallet.dto;

import java.io.Serializable;

/**
 * @author SanWaiLwin
 *
 */
public class BillDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String description;

	public BillDTO() {
		super();
	}

	public BillDTO(Long id) {
		super();
		this.id = id;
	}

	public BillDTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
