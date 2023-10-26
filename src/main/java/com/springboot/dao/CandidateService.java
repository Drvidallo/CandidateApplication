package com.springboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Candidate;
import com.springboot.model.DTO.CandidateDTO;
import com.springboot.model.DTO.ExperienceDTO;
import com.springboot.model.DTO.FeedbackDTO;
import com.springboot.model.DTO.InterviewDTO;
import com.springboot.repository.CandidateRepository;
import com.springboot.repository.IndustryExperienceRepository;
import com.springboot.repository.IndustryRepository;
import com.springboot.repository.TechnologyExperienceRepository;
import com.springboot.utils.Utils;

import jakarta.transaction.Transactional;

@Service
public class CandidateService {
	@Autowired
	CandidateRepository candidateRepository;

	@Autowired
	IndustryExperienceRepository industryExperienceRepository;

	@Autowired
	TechnologyExperienceRepository technologyExperienceRepository;

	@Autowired
	IndustryRepository industryRepository;

	private final IndustryExperienceService industryExperienceService;
	private final TechnologyExperienceService technologyExperienceService;
	private final FeedbackService feedbackService;
	private final InterviewService interviewService;

	private Utils utils;

	public Iterable<Candidate> getAllCandidate() {
		return candidateRepository.findAll();
	}

	public CandidateService(CandidateRepository intervieweeRepository,
			IndustryExperienceService industryExperienceService,
			TechnologyExperienceService technologyExperienceService, FeedbackService feedbackService,
			InterviewService interviewService) {

		this.candidateRepository = intervieweeRepository;
		this.industryExperienceService = industryExperienceService;
		this.technologyExperienceService = technologyExperienceService;
		this.feedbackService = feedbackService;
		this.interviewService = interviewService;
	}

	@Transactional
	public Candidate submitCandidate(Candidate candidate) {
		Candidate createdCandidate = candidateRepository.save(candidate);
		return createdCandidate;
	}

	public void deleteCandidate(int intervieweeId) {
		boolean exists = candidateRepository.existsById(intervieweeId);
		if (!exists) {
			throw new IllegalStateException("Interviewee" + intervieweeId + "doesn't exist");
		}

		candidateRepository.deleteById(intervieweeId);
	}

	@Transactional
	public void updateCandidate(int intervieweeId, Candidate NewInterviewee) {
		try {
			Optional<Candidate> intervieweeOptional = candidateRepository.findById(intervieweeId);
			Candidate currentInterviewee = intervieweeOptional.get();
			currentInterviewee.setFirstName(NewInterviewee.getFirstName());
			currentInterviewee.setLastName(NewInterviewee.getLastName());
			currentInterviewee.setRrfNumber(NewInterviewee.getRrfNumber());
			currentInterviewee.setPositionId(NewInterviewee.getPositionId());

		} catch (IllegalStateException e) {
			throw new IllegalStateException("Interviewee with id " + intervieweeId + " doesn't exist");
		}
	}

	public List<CandidateDTO> getAllCandidateDetails() {

		List<Candidate> candidateList = candidateRepository.findAll();
		List<ExperienceDTO> industryExperienceList = industryExperienceService.getIndustryExperienceAllValues();
		List<ExperienceDTO> technologyExperienceList = technologyExperienceService.getTechnologyExperienceAllValues();

		List<CandidateDTO> candidateDTOList = new ArrayList<>();
		List<ExperienceDTO> industryExperienceDTO = new ArrayList<>();
		List<ExperienceDTO> technologyExperienceDTO = new ArrayList<>();

		for (Candidate candidate : candidateList) {
			Utils.clearArrayList(industryExperienceDTO, technologyExperienceDTO);

			CandidateDTO candidateDTO = new CandidateDTO();
			candidateDTO.setId(candidate.getId());
			candidateDTO.setFirstName(candidate.getFirstName());
			candidateDTO.setLastName(candidate.getLastName());
			InterviewDTO interviewDTO = interviewService.getInterviewByCandidateId(candidate.getId());
			FeedbackDTO feedbackDTO = feedbackService.getFeedbackByCandidateId(candidate.getId());

//    	Filter out multiple experiences that has the same Id
			for (ExperienceDTO experience : industryExperienceList) {
				if (experience.getCandidateId() == candidate.getId()) {
					industryExperienceDTO.add(experience);
				}
			}

			for (ExperienceDTO experience : technologyExperienceList) {
				if (experience.getCandidateId() == candidate.getId()) {
					technologyExperienceDTO.add(experience);
				}
			}

//        	Map the experiences to array of experiences
			List<ExperienceDTO> industryExperienceDTOArray = industryExperienceDTO.stream()
					.map(criteria -> new ExperienceDTO(criteria.getId(), criteria.getName(), criteria.getCandidateId(),
							criteria.getExperienceDurationValue(), criteria.getExperienceDurationType()))
					.collect(Collectors.toList());
			List<ExperienceDTO> technologyExperienceDTOArray = technologyExperienceDTO.stream()
					.map(criteria -> new ExperienceDTO(criteria.getId(), criteria.getName(), criteria.getCandidateId(),
							criteria.getExperienceDurationValue(), criteria.getExperienceDurationType()))
					.collect(Collectors.toList());

			candidateDTO.setIndustryExperience(industryExperienceDTOArray);
			candidateDTO.setTechnologyExperience(technologyExperienceDTOArray);
			candidateDTO.setInterview(interviewDTO);
			candidateDTO.setFeedback(feedbackDTO);

			candidateDTOList.add(candidateDTO);

		}

		return candidateDTOList;
	}

	public Candidate getCandidateById(int candidateId) {

		Candidate candidate = candidateRepository.findById(candidateId).orElseThrow();
		return candidate;

	}

	public CandidateDTO getCandidateByIdAllDetails(int candidateId) {

		Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
		CandidateDTO candidateDTO = new CandidateDTO();
		if (candidate != null) {

			List<ExperienceDTO> industryExperienceList = industryExperienceService
					.getIndustryExperienceAllValuesById(candidate.getId());
			List<ExperienceDTO> technologyExperienceList = technologyExperienceService
					.getTechnologyExperienceAllValuesById(candidate.getId());

			candidateDTO.setId(candidate.getId());
			candidateDTO.setFirstName(candidate.getFirstName());
			candidateDTO.setLastName(candidate.getLastName());

			InterviewDTO interviewDTO = interviewService.getInterviewByCandidateId(candidate.getId());

			FeedbackDTO feedbackDTO = feedbackService.getFeedbackByCandidateId(candidate.getId());

			List<ExperienceDTO> industryExperienceDTOArray = industryExperienceList.stream()
					.map(criteria -> new ExperienceDTO(criteria.getId(), criteria.getName(), criteria.getCandidateId(),
							criteria.getExperienceDurationValue(), criteria.getExperienceDurationType()))
					.collect(Collectors.toList());

			List<ExperienceDTO> technologyExperienceDTOArray = technologyExperienceList.stream()
					.map(criteria -> new ExperienceDTO(criteria.getId(), criteria.getName(), criteria.getCandidateId(),
							criteria.getExperienceDurationValue(), criteria.getExperienceDurationType()))
					.collect(Collectors.toList());

			candidateDTO.setIndustryExperience(industryExperienceDTOArray);
			candidateDTO.setTechnologyExperience(technologyExperienceDTOArray);
			candidateDTO.setInterview(interviewDTO);
			candidateDTO.setFeedback(feedbackDTO);
		}
		return candidateDTO;

	}

}
