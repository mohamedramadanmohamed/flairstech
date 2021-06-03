package com.flairstech.assessment.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flairstech.assessment.entities.CountryLanguage;
import com.flairstech.assessment.entities.CountryLanguagePK;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguagePK>{
	@Query(value = "select * from country_language where country_code=:country_code", nativeQuery = true)
	public Optional<CountryLanguage> findCountryLanguage(@Param("country_code") String country_code);
}
