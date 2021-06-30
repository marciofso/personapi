package com.marcio.personapi.resources;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.marcio.personapi.domain.Person;
import com.marcio.personapi.dto.PersonDTO;
import com.marcio.personapi.exceptions.PersonNotFoundException;
import com.marcio.personapi.services.PersonService;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {
	
	@Autowired
	private PersonService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<Person> insert(@Valid @RequestBody PersonDTO PersonDTO) {
		Person person = modelMapper.map(PersonDTO, Person.class);
		service.insert(person);
		return new ResponseEntity<>(person, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<PersonDTO> listAll() {
		return service.listAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PersonDTO findById(@PathVariable Integer id) throws PersonNotFoundException {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) throws PersonNotFoundException {
		service.delete(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Person> update(@PathVariable Integer id, @RequestBody @Valid PersonDTO personDTO)
			throws PersonNotFoundException {
		return service.update(id, personDTO);
	}	
}
