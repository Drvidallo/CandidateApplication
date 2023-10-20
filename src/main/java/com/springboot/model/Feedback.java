package com.springboot.model;

import javax.validation.constraints.Pattern;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
    private Integer id;

	@NotNull
	@NotBlank
	@Column(name = "candidateId")
    private Integer candidateId;
	
	
	@Column(name = "educational_Background_feedback")
	private int educationalBackgroundFeedback;


	@Column(name = "relevant_experience_feedback")
	private int relevantExperienceFeedback;


	@Column(name = "programming_language_feedback")
	private int programmingLanguagesFeedback;


	@Column(name = "implementation_feedback")
	private int implementationFeedback;


	@Column(name = "testing_framework_feedback")
	private int testingFrameworkFeedback;


	@Column(name = "design_feedback")
	private int designFeedback;


	@Column(name = "relevant_technologies_feedback")
	private int relevantTechnologiesFeedback;


	@Column(name = "technical_communication_feedback")
	private int technicalCommunicationFeedback;


	@Column(name = "methodology_eedback")
	private int methodologyFeedback;
	

	@Column(name = "certifications_feedback")
	private int certificationsFeedback;
	

	@Column(name = "project_management_skills")
	private int projectManagementSkillsFeedback;

	

	@Column(name = "project_management_tools_feedback")
	private int projectManagementToolsFeedback;



	@Column(name = "leadership_feedback")
	private int leadershipFeedback;
	

	@Column(name = "initiative_feedback")
	private int initiativeFeedback;

	

	@Column(name = "strengths_feedback")
	private int strengthsFeedback;

		

	@Column(name = "teamwork_feedback")
	private int teamworkFeedback;
	
	@Pattern(regexp = "[a-zA-Z0-9_.-]{1,500}", message = "Invalid characters in additionalNotes")
	@Column(name = "additional_notes")
	private String additionalNotes;


	
	@JoinColumn(name="practice_exam_result")
	private int practiceExamResult;


	@JoinColumn(name="recommendation")
	private int recommendation;
	

	@JoinColumn(name = "role_and_maturity")
	private int roleAndMaturity;

	@Pattern(regexp = "[a-zA-Z0-9_.-]{1,50}", message = "Invalid characters in comparators")
	@Column(name = "comparators")
	private String comparators;


	@JoinColumn(name = "crCode")
	private int crCode;


	@Column(name = "other_qualified_role")
	private int otherQualifiedRole;


	
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


	public int getEducationalBackgroundFeedback() {
		return educationalBackgroundFeedback;
	}


	public void setEducationalBackgroundFeedback(int educationalBackgroundFeedback) {
		this.educationalBackgroundFeedback = educationalBackgroundFeedback;
	}


	public int getRelevantExperienceFeedback() {
		return relevantExperienceFeedback;
	}


	public void setRelevantExperienceFeedback(int relevantExperienceFeedback) {
		this.relevantExperienceFeedback = relevantExperienceFeedback;
	}


	public int getProgrammingLanguagesFeedback() {
		return programmingLanguagesFeedback;
	}


	public void setProgrammingLanguagesFeedback(int programmingLanguagesFeedback) {
		this.programmingLanguagesFeedback = programmingLanguagesFeedback;
	}


	public int getImplementationFeedback() {
		return implementationFeedback;
	}


	public void setImplementationFeedback(int implementationFeedback) {
		this.implementationFeedback = implementationFeedback;
	}


	public int getTestingFrameworkFeedback() {
		return testingFrameworkFeedback;
	}


	public void setTestingFrameworkFeedback(int testingFrameworkFeedback) {
		this.testingFrameworkFeedback = testingFrameworkFeedback;
	}


	public int getDesignFeedback() {
		return designFeedback;
	}


	public void setDesignFeedback(int designFeedback) {
		this.designFeedback = designFeedback;
	}


	public int getRelevantTechnologiesFeedback() {
		return relevantTechnologiesFeedback;
	}


	public void setRelevantTechnologiesFeedback(int relevantTechnologiesFeedback) {
		this.relevantTechnologiesFeedback = relevantTechnologiesFeedback;
	}


	public int getTechnicalCommunicationFeedback() {
		return technicalCommunicationFeedback;
	}


	public void setTechnicalCommunicationFeedback(int technicalCommunicationFeedback) {
		this.technicalCommunicationFeedback = technicalCommunicationFeedback;
	}


	public int getMethodologyFeedback() {
		return methodologyFeedback;
	}


	public void setMethodologyFeedback(int methodologyFeedback) {
		this.methodologyFeedback = methodologyFeedback;
	}


	public int getCertificationsFeedback() {
		return certificationsFeedback;
	}


	public void setCertificationsFeedback(int certificationsFeedback) {
		this.certificationsFeedback = certificationsFeedback;
	}


	public int getProjectManagementSkillsFeedback() {
		return projectManagementSkillsFeedback;
	}


	public void setProjectManagementSkillsFeedback(int projectManagementSkillsFeedback) {
		this.projectManagementSkillsFeedback = projectManagementSkillsFeedback;
	}


	public int getProjectManagementToolsFeedback() {
		return projectManagementToolsFeedback;
	}


	public void setProjectManagementToolsFeedback(int projectManagementToolsFeedback) {
		this.projectManagementToolsFeedback = projectManagementToolsFeedback;
	}


	public int getLeadershipFeedback() {
		return leadershipFeedback;
	}


	public void setLeadershipFeedback(int leadershipFeedback) {
		this.leadershipFeedback = leadershipFeedback;
	}


	public int getInitiativeFeedback() {
		return initiativeFeedback;
	}


	public void setInitiativeFeedback(int initiativeFeedback) {
		this.initiativeFeedback = initiativeFeedback;
	}


	public int getStrengthsFeedback() {
		return strengthsFeedback;
	}


	public void setStrengthsFeedback(int strengthsFeedback) {
		this.strengthsFeedback = strengthsFeedback;
	}


	public int getTeamworkFeedback() {
		return teamworkFeedback;
	}


	public void setTeamworkFeedback(int teamworkFeedback) {
		this.teamworkFeedback = teamworkFeedback;
	}


	public String getAdditionalNotes() {
		return additionalNotes;
	}


	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}



	public String getComparators() {
		return comparators;
	}


	public void setComparators(String comparators) {
		this.comparators = comparators;
	}



	public int getPracticeExamResult() {
		return practiceExamResult;
	}


	public void setPracticeExamResult(int practiceExamResult) {
		this.practiceExamResult = practiceExamResult;
	}


	public int getRecommendation() {
		return recommendation;
	}


	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}


	public int getRoleAndMaturity() {
		return roleAndMaturity;
	}


	public void setRoleAndMaturity(int roleAndMaturity) {
		this.roleAndMaturity = roleAndMaturity;
	}


	public int getCrCode() {
		return crCode;
	}


	public void setCrCode(int crCode) {
		this.crCode = crCode;
	}


	public int getOtherQualifiedRole() {
		return otherQualifiedRole;
	}


	public void setOtherQualifiedRole(int otherQualifiedRole) {
		this.otherQualifiedRole = otherQualifiedRole;
	}


	public Feedback() {
		
	}

	

}
