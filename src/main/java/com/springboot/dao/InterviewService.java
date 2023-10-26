package com.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Candidate;
import com.springboot.model.Interview;
import com.springboot.model.DTO.InterviewDTO;
import com.springboot.repository.CandidateRepository;
import com.springboot.repository.InterviewRepository;
import com.springboot.utils.Utils;

import jakarta.transaction.Transactional;

@Service
public class InterviewService {
	@Autowired
	InterviewRepository interviewRepository;

	@Autowired
	CandidateRepository candidateRepository;

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

			Candidate candidate = candidateRepository.findById((Integer) interview.getCandidateId()).orElse(null);

			if (candidate != null) {
				InterviewDTO interviewWithValues = new InterviewDTO();
				interviewWithValues.setId(interview.getId());
				interviewWithValues.setCandidateId(candidate.getId());
				interviewWithValues.setInterviewDate(interview.getInterviewDate());
				interviewWithValuesList.add(interviewWithValues);
			}

		}

		return interviewWithValuesList;
	}

	public InterviewDTO getInterviewByCandidateId(int intervieweeId) {
		Interview interview = interviewRepository.findByCandidateId(intervieweeId);
		InterviewDTO interviewDTO = new InterviewDTO();
		Candidate candidate = candidateRepository.findById((Integer) interview.getCandidateId()).orElse(null);

		if (candidate != null) {

			interviewDTO.setId(interview.getId());
			interviewDTO.setCandidateId(candidate.getId());
			interviewDTO.setInterviewDate(interview.getInterviewDate());
		}
		return interviewDTO;
	}
}
