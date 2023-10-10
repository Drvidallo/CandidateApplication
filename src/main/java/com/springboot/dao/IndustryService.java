package com.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.referenceTable.Industry;
import com.springboot.repository.IndustryRepository;

@Service
public class IndustryService {
	@Autowired
	IndustryRepository industryRepository;
	
	public Iterable<Industry> getAllIndustry() {
		return industryRepository.findAll(); 
	}
	
	public void submitIndustry(Industry industry) {
		industryRepository.save(industry);
	}
}
