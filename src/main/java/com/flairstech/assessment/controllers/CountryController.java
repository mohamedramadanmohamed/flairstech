package com.flairstech.assessment.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flairstech.assessment.entities.Country;
import com.flairstech.assessment.exceptions.CountryCodeNotFoundException;
import com.flairstech.assessment.exceptions.DataBaseDownException;
import com.flairstech.assessment.services.CountryService;

@RestController
@RequestMapping("/")
public class CountryController {

	@Autowired
	CountryService service;
	
	//get specific country by id
	@GetMapping("{id}")
	public ResponseEntity<Country> getCountry(@PathVariable(value="id")String  id){
		Country country= service.findCountryByCode(id);
		
		if(country==null) 
			throw new CountryCodeNotFoundException("INVALID COUNTRY CODE");

		return ResponseEntity.status(HttpStatus.OK).body(country);
	}
	
	//get specific country by id
	@GetMapping
	public ResponseEntity<List<Country>> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		} catch (Exception e) {
			throw new DataBaseDownException("INTERNAL ERROR");
		}
		
	}
	
}
