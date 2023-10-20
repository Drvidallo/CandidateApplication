package com.springboot.model;

import com.springboot.model.enums.ExperienceDurationTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "technologyExperience")
public class TechnologyExperience {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@NotNull
	@NotBlank
	@Column(name = "candidate_id", nullable=false)
    private Integer candidateId;

	@NotNull
	@NotBlank
	@Column(name = "technology_id")
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

	public Integer getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
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
