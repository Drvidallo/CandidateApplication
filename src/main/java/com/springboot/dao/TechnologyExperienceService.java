package com.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springboot.model.Interviewee;
import com.springboot.model.TechnologyExperience;
import com.springboot.model.DTO.TechnologyExperienceDTO;
import com.springboot.model.referenceTable.Technology;
import com.springboot.repository.IntervieweeRepository;
import com.springboot.repository.TechnologyExperienceRepository;
import com.springboot.repository.TechnologyRepository;

@Service
public class TechnologyExperienceService {
	@Autowired
	TechnologyExperienceRepository technologyExperienceRepository;
	
	@Autowired
	TechnologyRepository technologyRepository;
	
	@Autowired
	IntervieweeRepository intervieweeRepository;
	
	public Iterable<TechnologyExperience> getAllIndustryExperience() {
		return technologyExperienceRepository.findAll(); 
	}
	
	
	public void submitTechnologyExperience(TechnologyExperience technologyExperience) {
		technologyExperienceRepository.save(technologyExperience);
	}
	
	
	public List<TechnologyExperienceDTO> getTechnologyExperienceAllValues() {
        List<TechnologyExperience> technologyExperienceList = technologyExperienceRepository.findAll();
        List<TechnologyExperienceDTO> technologyExperieneWithValuesList = new ArrayList<>();

        for (TechnologyExperience technologyExperience : technologyExperienceList) {
        	
            Technology technology = technologyRepository.findById((Integer) technologyExperience.getTechnologyId()).orElse(null);
            Interviewee interviewee = intervieweeRepository.findById((Integer) technologyExperience.getIntervieweeId()).orElse(null);

            if (technology != null) {
            	TechnologyExperienceDTO technologyExperieneWithValues = new TechnologyExperienceDTO();
            	technologyExperieneWithValues.setId(technologyExperience.getId());
            	technologyExperieneWithValues.setTechnology(technology.getName());
            	technologyExperieneWithValues.setIntervieweeFirstName(interviewee.getFirstName());
            	technologyExperieneWithValues.setIntervieweeLastName(interviewee.getLastName());
            	technologyExperieneWithValues.setExperienceDurationType(technologyExperience.getExperienceDurationType());
            	technologyExperieneWithValues.setExperienceDurationValue(technologyExperience.getExperienceDurationValue());
            	technologyExperieneWithValuesList.add(technologyExperieneWithValues);
            }
 
        }

        return technologyExperieneWithValuesList;
    }
}
