package com.marcio.personapi.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.marcio.personapi.domain.Phone;

public class PersonDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String firstName;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String lastName;
	
	@NotEmpty
	@CPF
	private String cpf;
	
	@NotNull
	private LocalDate birthDate;
	
	@Valid
	@NotEmpty
	private List<Phone> phones;
	
	public PersonDTO() {
		
	}

	public PersonDTO(Integer id, @NotEmpty @Size(min = 2, max = 100) String firstName,
			@NotEmpty @Size(min = 2, max = 100) String lastName, @NotEmpty @CPF String cpf,
			@NotNull LocalDate birthDate, @Valid @NotEmpty List<Phone> phones) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.phones = phones;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}
