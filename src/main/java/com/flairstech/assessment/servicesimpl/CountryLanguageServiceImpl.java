package com.flairstech.assessment.servicesimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flairstech.assessment.dao.CountryLanguageRepository;
import com.flairstech.assessment.entities.CountryLanguage;
import com.flairstech.assessment.services.CountryLanguageService;

@Service
public class CountryLanguageServiceImpl implements CountryLanguageService{

	@Autowired
	CountryLanguageRepository repository;
	
	@Override
	public CountryLanguage findCountryLanguage(String code) {
			Optional<CountryLanguage> countryLanguage = repository.findCountryLanguage(code);
			return countryLanguage.isPresent()?countryLanguage.get():null;
	}

}
