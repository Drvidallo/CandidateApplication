package com.springboot.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.springboot.model.enums.ExperienceDurationTypeEnum;



@Entity
@Table(name = "industryExperience")
public class IndustryExperience {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

	@NotNull
	@NotBlank
	@Column(name = "candidate_id", nullable=false)
    private Integer candidateId;

	@NotNull
	@NotBlank
	@Column(name = "industry_id", nullable=false)
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

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
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

	public IndustryExperience(Integer id, Integer industryId, Integer experienceDurationValue,
			ExperienceDurationTypeEnum experienceDurationType) {
		super();
		this.id = id;
		this.industryId = industryId;
		this.experienceDurationValue = experienceDurationValue;
		this.experienceDurationType = experienceDurationType;
	}

	public IndustryExperience() {}
	
	
}
