package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.dao.IndustryExperienceService;
import com.springboot.model.IndustryExperience;
import com.springboot.model.DTO.IndustryExperienceDTO;


@RestController
@RequestMapping("/api/industryExperience")
public class IndustryExperienceController {
	private final IndustryExperienceService industryExperienceService;

	@Autowired
	public IndustryExperienceController(IndustryExperienceService industryExperienceService) {
		this.industryExperienceService = industryExperienceService;
	}
	
	@PostMapping("/post")
	public void addIndustryExperience(@RequestBody IndustryExperience industryExperience) {
		industryExperienceService.submitIndustryExperience(industryExperience);
	}
	
	@GetMapping(path="/get")
	public List<IndustryExperienceDTO> getIndustryExperienceAll() {
		return industryExperienceService.getIndustryExperienceAllValues();
	}
}
