package com.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.model.IndustryExperience;
import com.springboot.model.Interviewee;
import com.springboot.model.DTO.IndustryExperienceDTO;
import com.springboot.model.referenceTable.Industry;
import com.springboot.repository.IndustryExperienceRepository;
import com.springboot.repository.IndustryRepository;
import com.springboot.repository.IntervieweeRepository;


@Service
public class IndustryExperienceService {
	@Autowired
	IndustryExperienceRepository industryExperienceRepository;
	
	@Autowired
	IndustryRepository industryRepository;
	
	@Autowired
	IntervieweeRepository intervieweeRepository;
	
	public Iterable<IndustryExperience> getAllIndustryExperience() {
		return industryExperienceRepository.findAll(); 
	}
	
	
	public void submitIndustryExperience(IndustryExperience industryExperience) {
		industryExperienceRepository.save(industryExperience);
	}
	
	public List<IndustryExperienceDTO> getIndustryExperienceAllValues() {
        List<IndustryExperience> industryExperienceList = industryExperienceRepository.findAll();
        List<IndustryExperienceDTO> industryExperieneWithValuesList = new ArrayList<>();

        for (IndustryExperience industryExperience : industryExperienceList) {
        	
            Industry industry = industryRepository.findById((Integer) industryExperience.getIndustryId()).orElse(null);
            Interviewee interviewee = intervieweeRepository.findById((Integer) industryExperience.getIntervieweeId()).orElse(null);

            if (industry != null) {
            	IndustryExperienceDTO industryExperieneWithValues = new IndustryExperienceDTO();
            	industryExperieneWithValues.setId(industryExperience.getId());
            	industryExperieneWithValues.setIndustry(industry.getName());
            	industryExperieneWithValues.setIntervieweeFirstName(interviewee.getFirstName());
            	industryExperieneWithValues.setIntervieweeLastName(interviewee.getLastName());
            	industryExperieneWithValues.setExperienceDurationType(industryExperience.getExperienceDurationType());
            	industryExperieneWithValues.setExperienceDurationValue(industryExperience.getExperienceDurationValue());
            	industryExperieneWithValuesList.add(industryExperieneWithValues);
            }
        
            
            
        }

        return industryExperieneWithValuesList;
    }
}
