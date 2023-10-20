package com.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.model.IndustryExperience;
import com.springboot.model.Candidate;
import com.springboot.model.DTO.ExperienceDTO;
import com.springboot.model.referenceTable.Industry;
import com.springboot.repository.IndustryExperienceRepository;
import com.springboot.repository.IndustryRepository;
import com.springboot.repository.CandidateRepository;


@Service
public class IndustryExperienceService {
	@Autowired
	IndustryExperienceRepository industryExperienceRepository;
	
	@Autowired
	IndustryRepository industryRepository;
	
	@Autowired
	CandidateRepository candidateRepository;
	
	public Iterable<IndustryExperience> getAllIndustryExperience() {
		return industryExperienceRepository.findAll(); 
	}
	
	
	public void submitIndustryExperience(IndustryExperience industryExperience) {
		industryExperienceRepository.save(industryExperience);
	}
	
	public List<ExperienceDTO> getIndustryExperienceAllValues() {
        List<IndustryExperience> industryExperienceList = industryExperienceRepository.findAll();
        List<ExperienceDTO> industryExperienceDTOList = new ArrayList<>();

        for (IndustryExperience industryExperience : industryExperienceList) {
        	
            Industry industry = industryRepository.findById((Integer) industryExperience.getIndustryId()).orElse(null);
            Candidate candidate = candidateRepository.findById((Integer) industryExperience.getCandidateId()).orElse(null);

            if (industry != null) {
            	ExperienceDTO industryExperienceDTO = new ExperienceDTO();
            	industryExperienceDTO.setId(industryExperience.getId());
            	industryExperienceDTO.setName(industry.getName());
            	industryExperienceDTO.setCandidateId(candidate.getId());
            	industryExperienceDTO.setExperienceDurationType(industryExperience.getExperienceDurationType());
            	industryExperienceDTO.setExperienceDurationValue(industryExperience.getExperienceDurationValue());
            	industryExperienceDTOList.add(industryExperienceDTO);
            }

        }

        return industryExperienceDTOList;
    }
	
	public List<ExperienceDTO> getIndustryExperienceAllValuesById(int candidateId) {
        List<IndustryExperience> industryExperienceList = industryExperienceRepository.findByCandidateId(candidateId);
        List<ExperienceDTO> industryExperieneWithValuesList = new ArrayList<>();

        for (IndustryExperience industryExperience : industryExperienceList) {
        	
            Industry industry = industryRepository.findById((Integer) industryExperience.getIndustryId()).orElse(null);
            Candidate candidate = candidateRepository.findById((Integer) industryExperience.getCandidateId()).orElse(null);

            if (industry != null) {
            	ExperienceDTO industryExperieneWithValues = new ExperienceDTO();
            	industryExperieneWithValues.setId(industryExperience.getId());
            	industryExperieneWithValues.setName(industry.getName());
            	industryExperieneWithValues.setCandidateId(candidate.getId());
            	industryExperieneWithValues.setExperienceDurationType(industryExperience.getExperienceDurationType());
            	industryExperieneWithValues.setExperienceDurationValue(industryExperience.getExperienceDurationValue());
            	industryExperieneWithValuesList.add(industryExperieneWithValues);
            }

        }

        return industryExperieneWithValuesList;
    }
}
