package com.flairstech.assessment.controllers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flairstech.assessment.entities.Country;
import com.flairstech.assessment.entities.CountryLanguage;
import com.flairstech.assessment.exceptions.CountryCodeNotFoundException;
import com.flairstech.assessment.exceptions.DataBaseDownException;
import com.flairstech.assessment.services.CountryLanguageService;
import com.flairstech.assessment.services.CountryService;

@RestController
@RequestMapping("/")
public class CountryController {

	@Autowired
	CountryService service;
	
	@Autowired
	CountryLanguageService countryLanguageService;
	
	//get specific country by id
	@GetMapping("{id}")
	public ResponseEntity<Map<String,String>> getCountry(@PathVariable(value="id")String  id){
		Country country= service.findCountryByCode(id);
		
		if(country==null) 
			throw new CountryCodeNotFoundException("INVALID COUNTRY CODE");

		CountryLanguage countryLanguage = countryLanguageService.findCountryLanguage(id);
		
		Map<String,String> ans = new LinkedHashMap<>();
		ans.put("name",String.valueOf(country.getName()));
		ans.put("continent",String.valueOf(country.getContinent()));
		ans.put("population", String.valueOf(country.getPopulation()));
		ans.put("life_expectancy",String.valueOf(country.getLifeExpectancy()));
		ans.put("country_language",countryLanguage.getId().getLanguage());
		
		return ResponseEntity.status(HttpStatus.OK).body(ans);
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
