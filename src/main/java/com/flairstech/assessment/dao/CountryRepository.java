package com.flairstech.assessment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flairstech.assessment.entities.Country;

public interface CountryRepository extends JpaRepository<Country, String>{

}
