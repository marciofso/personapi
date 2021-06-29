package com.marcio.personapi.dto;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.marcio.personapi.enums.PhoneType;

public class PhoneDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@Enumerated(EnumType.STRING)
	private PhoneType type;

	@NotEmpty
	@Size(min = 13, max = 14)
	private String number;

	public PhoneDTO() {
	}

	public PhoneDTO(Integer id, PhoneType type, @NotEmpty @Size(min = 13, max = 14) String number) {
		super();
		this.id = id;
		this.type = type;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
