package com.flairstech.assessment.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flairstech.assessment.dao.CountryRepository;
import com.flairstech.assessment.entities.Country;
import com.flairstech.assessment.exceptions.DataBaseDownException;
import com.flairstech.assessment.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	CountryRepository repository;
	
	@Override
	public Country findCountryByCode(String code) {
		try {
			Optional<Country> country = repository.findById(code);
			return country.isPresent()?country.get():null;
		} catch (Exception e) {
			throw new DataBaseDownException("INTERNAL ERROR");
		}

	}

	@Override
	public List<Country> findAll() {
		return repository.findAll();
	}

}
