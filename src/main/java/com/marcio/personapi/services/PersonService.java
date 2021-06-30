package com.marcio.personapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marcio.personapi.domain.Person;
import com.marcio.personapi.dto.PersonDTO;
import com.marcio.personapi.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Person insert(Person person) {
		return repository.save(person);
	}

	public List<PersonDTO> listAll() {
		return repository.findAll().stream().map(this::toPersonDTO).collect(Collectors.toList());
	}

	public PersonDTO findById(Integer id) throws PersonNotFoundException {
		Person person = repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
		return modelMapper.map(person, PersonDTO.class);
	}

	public void delete(Integer id) throws PersonNotFoundException {
		repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
		repository.deleteById(id);
	}

	public ResponseEntity<Person> update(Integer id, PersonDTO personDTO) throws PersonNotFoundException {
		repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
		Person updatedPerson = modelMapper.map(personDTO, Person.class);
		Person savedPerson = repository.save(updatedPerson);
		return ResponseEntity.ok(savedPerson);
	}

	private PersonDTO toPersonDTO(Person person) {
		return modelMapper.map(person, PersonDTO.class);
	}

}
