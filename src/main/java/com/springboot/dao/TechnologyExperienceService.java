package com.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springboot.model.Candidate;
import com.springboot.model.TechnologyExperience;
import com.springboot.model.DTO.ExperienceDTO;
import com.springboot.model.referenceTable.Technology;
import com.springboot.repository.CandidateRepository;
import com.springboot.repository.TechnologyExperienceRepository;
import com.springboot.repository.TechnologyRepository;

@Service
public class TechnologyExperienceService {
	@Autowired
	TechnologyExperienceRepository technologyExperienceRepository;
	
	@Autowired
	TechnologyRepository technologyRepository;
	
	@Autowired
	CandidateRepository candidateRepository;
	
	public Iterable<TechnologyExperience> getAllIndustryExperience() {
		return technologyExperienceRepository.findAll(); 
	}
	
	
	public void submitTechnologyExperience(TechnologyExperience technologyExperience) {
		technologyExperienceRepository.save(technologyExperience);
	}
	
	
	public List<ExperienceDTO> getTechnologyExperienceAllValues() {
        List<TechnologyExperience> technologyExperienceList = technologyExperienceRepository.findAll();
        List<ExperienceDTO> technologyExperienceDTOList = new ArrayList<>();

        for (TechnologyExperience technologyExperience : technologyExperienceList) {
        	
            Technology technology = technologyRepository.findById((Integer) technologyExperience.getTechnologyId()).orElse(null);
            Candidate candidate = candidateRepository.findById((Integer) technologyExperience.getCandidateId()).orElse(null);

            if (technology != null && candidate != null) {
            	ExperienceDTO technologyExperienceDTO = new ExperienceDTO();
            	technologyExperienceDTO.setId(technologyExperience.getId());
            	technologyExperienceDTO.setName(technology.getName());
            	technologyExperienceDTO.setCandidateId(candidate.getId());
            	technologyExperienceDTO.setExperienceDurationType(technologyExperience.getExperienceDurationType());
            	technologyExperienceDTO.setExperienceDurationValue(technologyExperience.getExperienceDurationValue());
            	technologyExperienceDTOList.add(technologyExperienceDTO);
            }
 
        }

        return technologyExperienceDTOList;
    }
	
	public List<ExperienceDTO> getTechnologyExperienceAllValuesById(int candidateId) {
        List<TechnologyExperience> technologyExperienceList = technologyExperienceRepository.findByCandidateId(candidateId);
        List<ExperienceDTO> technologyExperienceDTOList = new ArrayList<>();

        for (TechnologyExperience technologyExperience : technologyExperienceList) {
        	
            Technology technology = technologyRepository.findById((Integer) technologyExperience.getTechnologyId()).orElse(null);
            Candidate candidate = candidateRepository.findById((Integer) technologyExperience.getCandidateId()).orElse(null);

            if (technology != null) {
            	ExperienceDTO technologyExperienceDTO = new ExperienceDTO();
            	technologyExperienceDTO.setId(technologyExperience.getId());
            	technologyExperienceDTO.setName(technology.getName());
            	technologyExperienceDTO.setCandidateId(candidate.getId());
            	technologyExperienceDTO.setExperienceDurationType(technologyExperience.getExperienceDurationType());
            	technologyExperienceDTO.setExperienceDurationValue(technologyExperience.getExperienceDurationValue());
            	technologyExperienceDTOList.add(technologyExperienceDTO);
            }
 
        }

        return technologyExperienceDTOList;
    }
}
