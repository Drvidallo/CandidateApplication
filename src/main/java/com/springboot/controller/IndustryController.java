package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.dao.IndustryService;
import com.springboot.model.referenceTable.Industry;

@RestController
@RequestMapping("/api/industry")
public class IndustryController {
	private final IndustryService industryService;
	
	@Autowired
	public IndustryController(IndustryService industryService) {
		this.industryService = industryService;
	}
	
	@GetMapping(path="/get")
	public Iterable<Industry> getIndustryAll() {
		return industryService.getAllIndustry();
	}
	
	@PostMapping("/post")
	public void submitIndustry(@RequestBody Industry industry) {
		industryService.submitIndustry(industry);
	}
}
