package com.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.utils.Utils;
import com.springboot.model.Candidate;
import com.springboot.model.DTO.ExperienceDTO;
import com.springboot.model.DTO.InterviewDTO;
import com.springboot.model.DTO.CandidateDTO;
import com.springboot.model.referenceTable.Industry;
import com.springboot.model.IndustryExperience;
import com.springboot.model.Interview;
import com.springboot.repository.CandidateRepository;
import com.springboot.repository.InterviewRepository;

import jakarta.transaction.Transactional;

@Service
public class InterviewService {
	@Autowired
	InterviewRepository interviewRepository;
	
	@Autowired
	CandidateRepository intervieweeRepository;
	
	Utils intervieweeUtils = new Utils();
	
	public Iterable<Interview> getAllInterviewer() {
		return interviewRepository.findAll(); 
	}
	
	public InterviewService(InterviewRepository interviewRepository) {
		
        this.interviewRepository = interviewRepository;
    }
	
	@Transactional
	public void submitInterview(Interview interview) {
			interviewRepository.save(interview);
	}
	
	public List<InterviewDTO> getInterviewAllValues() {
        List<Interview> interviewList = interviewRepository.findAll();
        List<InterviewDTO> interviewWithValuesList = new ArrayList<>();

        for (Interview interview : interviewList) {
        	
            Candidate candidate = intervieweeRepository.findById((Integer) interview.getCandidateId()).orElse(null);

            if (candidate != null) {
            	InterviewDTO interviewWithValues = new InterviewDTO();
            	interviewWithValues.setId(interview.getId());
            	interviewWithValues.setIntervieweeId(candidate.getId());
            	interviewWithValues.setInterviewDate(interview.getInterviewDate());
            	interviewWithValuesList.add(interviewWithValues);
            }

        }

        return interviewWithValuesList;
    }
	
	public InterviewDTO getInterviewByCandidateId(int intervieweeId) {
        Interview interview = interviewRepository.findByCandidateId(intervieweeId);
        InterviewDTO interviewWithValues = new InterviewDTO();

            Candidate candidate = intervieweeRepository.findById((Integer) interview.getCandidateId()).orElse(null);

            if (candidate != null) {
            	
            	interviewWithValues.setId(interview.getId());
            	interviewWithValues.setIntervieweeId(candidate.getId());
            	interviewWithValues.setInterviewDate(interview.getInterviewDate());
            }
        return interviewWithValues;
    }
}
