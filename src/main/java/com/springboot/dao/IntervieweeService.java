package com.springboot.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.springboot.model.Interviewee;
import com.springboot.repository.IndustryExperienceRepository;
import com.springboot.repository.IndustryRepository;
import com.springboot.repository.IntervieweeRepository;
import com.springboot.repository.TechnologyExperienceRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class IntervieweeService {
	@Autowired
	IntervieweeRepository intervieweeRepository;
	

	@Autowired
	IndustryExperienceRepository industryExperienceRepository;
	
	@Autowired
	TechnologyExperienceRepository technologyExperienceRepository;
	
	@Autowired
	IndustryRepository industryRepository;
	
	
	
	public Iterable<Interviewee> getAllInterviewee() {
		
		
		return intervieweeRepository.findAll(); 
	}
	
	
	public IntervieweeService(
            IntervieweeRepository intervieweeRepository) {
        this.intervieweeRepository = intervieweeRepository;
    }

	
	@Transactional
	public void submitInterviewee(Interviewee interviewee) {
			intervieweeRepository.save(interviewee);

	}
	

	
	public void deleteInterviewee (int intervieweeId) {
		boolean exists = intervieweeRepository.existsById(intervieweeId);
		if(!exists) {
			throw new IllegalStateException("Interviewee" + intervieweeId + "doesn't exist");
		}
		
		intervieweeRepository.deleteById(intervieweeId);
	}
	
	@Transactional
	public void updateInterviewee(int intervieweeId, Interviewee NewInterviewee) {		
		try {
			Optional<Interviewee> intervieweeOptional = intervieweeRepository.findById(intervieweeId);
			Interviewee currentInterviewee = intervieweeOptional.get();
			currentInterviewee.setFirstName(NewInterviewee.getFirstName());
			currentInterviewee.setLastName(NewInterviewee.getLastName());
			currentInterviewee.setRrfNumber(NewInterviewee.getRrfNumber());
			currentInterviewee.setPosition(NewInterviewee.getPosition());
			


		} catch (IllegalStateException e) {
			throw new IllegalStateException("Interviewee with id " + intervieweeId + " doesn't exist");
		}
	}
	
	public Optional<Interviewee> getIntervieweeById(int intervieweeId) {
//		boolean exists = intervieweeRepository.existsById(intervieweeId);
//		if(!exists) {
//			throw new IllegalStateException("Interviewee " + intervieweeId + " doesn't exist");
//		}
		
		return intervieweeRepository.findIntervieweeAllTable(intervieweeId);
//		Interviewee intervieweeOptional = intervieweeRepository.findById(intervieweeId)
//				.orElseThrow(() -> new EntityNotFoundException("Entity not found with ID: " + intervieweeId));
//
//		 return intervieweeOptional;
	}

}
