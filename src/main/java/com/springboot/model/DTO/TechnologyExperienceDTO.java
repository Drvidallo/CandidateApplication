package com.springboot.model.DTO;

import com.springboot.model.enums.ExperienceDurationTypeEnum;

public class TechnologyExperienceDTO {
	private Integer id;
	
    private String technology;

    private String intervieweeFirstName;
    
    private String intervieweeLastName;
    
	private Integer experienceDurationValue;
	
	private ExperienceDurationTypeEnum experienceDurationType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getIntervieweeFirstName() {
		return intervieweeFirstName;
	}

	public void setIntervieweeFirstName(String intervieweeFirstName) {
		this.intervieweeFirstName = intervieweeFirstName;
	}

	public String getIntervieweeLastName() {
		return intervieweeLastName;
	}

	public void setIntervieweeLastName(String intervieweeLastName) {
		this.intervieweeLastName = intervieweeLastName;
	}

	public Integer getExperienceDurationValue() {
		return experienceDurationValue;
	}

	public void setExperienceDurationValue(Integer experienceDurationValue) {
		this.experienceDurationValue = experienceDurationValue;
	}

	public ExperienceDurationTypeEnum getExperienceDurationType() {
		return experienceDurationType;
	}

	public void setExperienceDurationType(ExperienceDurationTypeEnum experienceDurationType) {
		this.experienceDurationType = experienceDurationType;
	}

}
