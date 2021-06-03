package com.flairstech.assessment.services;

import java.util.List;

import com.flairstech.assessment.entities.Country;

public interface CountryService {
	public Country findCountryByCode(String code);
	public List<Country> findAll();
}
