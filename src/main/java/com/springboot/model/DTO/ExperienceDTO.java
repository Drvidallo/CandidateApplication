package com.springboot.model.DTO;


import com.springboot.model.enums.ExperienceDurationTypeEnum;


public class ExperienceDTO {
	private Integer id;
	
    private String name;

    private Integer candidateId;

	private Integer experienceDurationValue;
	
	private ExperienceDurationTypeEnum experienceDurationType;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
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


    
	public ExperienceDTO(Integer id, String name, Integer candidateId, Integer experienceDurationValue,
			ExperienceDurationTypeEnum experienceDurationType) {
		super();
		this.id = id;
		this.name = name;
		this.candidateId = candidateId;
		this.experienceDurationValue = experienceDurationValue;
		this.experienceDurationType = experienceDurationType;
	}

	public ExperienceDTO() {}
	
    
}
