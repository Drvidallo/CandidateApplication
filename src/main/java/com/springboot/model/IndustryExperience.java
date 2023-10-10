package com.springboot.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;



import com.springboot.model.enums.ExperienceDurationTypeEnum;



@Entity
@Table(name = "industryExperience")
public class IndustryExperience {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 


    @JoinColumn(name = "interviewee_id")
    private Integer intervieweeId;


    @JoinColumn(name = "industry_id")
    private Integer industryId;
    
	@Column(length = 20, name="experience_duration_value")
	private Integer experienceDurationValue;
	
	@Column(length = 20, name="experience_duration_type")
	private ExperienceDurationTypeEnum experienceDurationType;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getIntervieweeId() {
		return intervieweeId;
	}

	public void setIntervieweeId(Integer intervieweeId) {
		this.intervieweeId = intervieweeId;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
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
