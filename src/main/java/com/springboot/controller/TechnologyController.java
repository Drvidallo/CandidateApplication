package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.TechnologyService;
import com.springboot.model.referenceTable.Technology;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {
	private final TechnologyService technologyService;
	
	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@GetMapping(path="/get")
	public Iterable<Technology> getTechnologyAll() {
		return technologyService.getAllTechnology();
	}
	
	@PostMapping("/post")
	public void submitTechnology(@RequestBody Technology technology) {
		technologyService.submitTechnology(technology);
	}
}
