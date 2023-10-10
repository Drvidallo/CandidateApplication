package com.springboot.model.DTO;


import com.springboot.model.enums.ExperienceDurationTypeEnum;


public class IndustryExperienceDTO {
	private Integer id;
	
    private String industry;

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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
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
