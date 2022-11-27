package com.swl.wallet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.swl.wallet.model.common.BaseEntity;

/**
 * @author SanWaiLwin
 *
 */
@Entity
@Table(name = "bill")
public class Bill extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	public Bill() {
		super();
	}

	public Bill(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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