package com.springboot.model.DTO;

import java.util.Date;
import java.util.List;

import jakarta.persistence.JoinColumn;

public class InterviewDTO {
	
	private Integer id;

    private String interviewer;
    
	private Date interviewDate;
	
    private Integer candidateId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

}
