package com.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.referenceTable.Technology;
import com.springboot.repository.TechnologyRepository;

@Service
public class TechnologyService {
	@Autowired
	TechnologyRepository industryRepository;
	
	public Iterable<Technology> getAllTechnology() {
		return industryRepository.findAll(); 
	}
	
	public void submitTechnology(Technology technology) {
		industryRepository.save(technology);
	}
}
