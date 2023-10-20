package com.springboot.model.DTO;

import java.util.List;

import com.springboot.model.IndustryExperience;
import com.springboot.model.referenceTable.Industry;

public class CandidateDTO {
	
	private Integer id;

    private String firstName;
    
    private String lastName;
    
	private List<ExperienceDTO> industryExperience;
	
	private List<ExperienceDTO> technologyExperience;
	
	private FeedbackDTO feedback;
	
	private InterviewDTO interview;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<ExperienceDTO> getIndustryExperience() {
		return industryExperience;
	}

	public void setIndustryExperience(List<ExperienceDTO> industryExperience) {
		this.industryExperience = industryExperience;
	}

	public List<ExperienceDTO> getTechnologyExperience() {
		return technologyExperience;
	}

	public void setTechnologyExperience(List<ExperienceDTO> technologyExperience) {
		this.technologyExperience = technologyExperience;
	}

	public FeedbackDTO getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedbackDTO feedback) {
		this.feedback = feedback;
	}

	public InterviewDTO getInterview() {
		return interview;
	}

	public void setInterview(InterviewDTO interview) {
		this.interview = interview;
	}

	
	
	
}
