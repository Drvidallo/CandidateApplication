package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.dao.TechnologyExperienceService;
import com.springboot.model.TechnologyExperience;
import com.springboot.model.DTO.ExperienceDTO;

@RestController
@RequestMapping("/api/technologyExperience")
public class TechnologyExperienceController {
	private final TechnologyExperienceService technologyExperienceService;

	@Autowired
	public TechnologyExperienceController(TechnologyExperienceService technologyExperienceService) {
		this.technologyExperienceService = technologyExperienceService;
	}
	
	@PostMapping("/post")
	public void addTechnologyExperience(@RequestBody TechnologyExperience technologyExperience) {
		technologyExperienceService.submitTechnologyExperience(technologyExperience);
	}
	
	@GetMapping(path="/get")
	public List<ExperienceDTO> getTechnologyExperienceAll() {
		return technologyExperienceService.getTechnologyExperienceAllValues();
	}
}
