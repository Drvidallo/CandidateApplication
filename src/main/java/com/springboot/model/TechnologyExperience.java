package com.springboot.model;

import com.springboot.model.enums.ExperienceDurationTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "technologyExperience")
public class TechnologyExperience {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JoinColumn(name = "interviewee_id")
    private Integer intervieweeId;


    @JoinColumn(name = "technology_id")
    private Integer technologyId;
	
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


	public Integer getTechnologyId() {
		return technologyId;
	}


	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
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
