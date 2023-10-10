package com.springboot.model.DTO;

import javax.validation.constraints.Pattern;

import com.springboot.model.enums.CrCodeEnum;
import com.springboot.model.enums.CriteriaEnum;
import com.springboot.model.enums.PracticeExamResultEnum;
import com.springboot.model.enums.RecommendationEnum;
import com.springboot.model.enums.RoleAndMaturityEnum;

import jakarta.persistence.Column;


public class FeedbackDTO {
	private Integer id;
	
    private RoleAndMaturityEnum roleAndMaturity;
    
    private PracticeExamResultEnum practiceExamResult;
    
    private RecommendationEnum recommendation;
    
    private CrCodeEnum crCode;

	private CriteriaEnum educationalBackgroundFeedback;

	private CriteriaEnum relevantExperienceFeedback;

	private CriteriaEnum programmingLanguagesFeedback;

	private CriteriaEnum implementationFeedback;

	private CriteriaEnum testingFrameworkFeedback;

	private CriteriaEnum designFeedback;

	private CriteriaEnum relevantTechnologiesFeedback;

	private CriteriaEnum technicalCommunicationFeedback;

	private CriteriaEnum methodologyFeedback;
	
	private CriteriaEnum certificationsFeedback;
	
	private CriteriaEnum projectManagementSkillsFeedback;

	private CriteriaEnum projectManagementToolsFeedback;

	private CriteriaEnum leadershipFeedback;
	
	private CriteriaEnum initiativeFeedback;

	private CriteriaEnum strengthsFeedback;

	private CriteriaEnum teamworkFeedback;
	
	@Pattern(regexp = "[a-zA-Z0-9_.-]{1,500}", message = "Invalid characters in additionalNotes")
	@Column(name = "additional_notes")
	private String additionalNotes;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RoleAndMaturityEnum getRoleAndMaturity() {
		return roleAndMaturity;
	}
	public void setRoleAndMaturity(RoleAndMaturityEnum roleAndMaturity) {
		this.roleAndMaturity = roleAndMaturity;
	}
	public PracticeExamResultEnum getPracticeExamResult() {
		return practiceExamResult;
	}
	public void setPracticeExamResult(PracticeExamResultEnum practiceExamResult) {
		this.practiceExamResult = practiceExamResult;
	}
	
	
	
	public RecommendationEnum getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(RecommendationEnum recommendation) {
		this.recommendation = recommendation;
	}
	
	public CrCodeEnum getCrCode() {
		return crCode;
	}
	public void setCrCode(CrCodeEnum crCode) {
		this.crCode = crCode;
	}
	public CriteriaEnum getEducationalBackgroundFeedback() {
		return educationalBackgroundFeedback;
	}
	public void setEducationalBackgroundFeedback(CriteriaEnum educationalBackgroundFeedback) {
		this.educationalBackgroundFeedback = educationalBackgroundFeedback;
	}
	public CriteriaEnum getRelevantExperienceFeedback() {
		return relevantExperienceFeedback;
	}
	public void setRelevantExperienceFeedback(CriteriaEnum relevantExperienceFeedback) {
		this.relevantExperienceFeedback = relevantExperienceFeedback;
	}
	public CriteriaEnum getProgrammingLanguagesFeedback() {
		return programmingLanguagesFeedback;
	}
	public void setProgrammingLanguagesFeedback(CriteriaEnum programmingLanguagesFeedback) {
		this.programmingLanguagesFeedback = programmingLanguagesFeedback;
	}
	public CriteriaEnum getImplementationFeedback() {
		return implementationFeedback;
	}
	public void setImplementationFeedback(CriteriaEnum implementationFeedback) {
		this.implementationFeedback = implementationFeedback;
	}
	public CriteriaEnum getTestingFrameworkFeedback() {
		return testingFrameworkFeedback;
	}
	public void setTestingFrameworkFeedback(CriteriaEnum testingFrameworkFeedback) {
		this.testingFrameworkFeedback = testingFrameworkFeedback;
	}
	public CriteriaEnum getDesignFeedback() {
		return designFeedback;
	}
	public void setDesignFeedback(CriteriaEnum designFeedback) {
		this.designFeedback = designFeedback;
	}
	public CriteriaEnum getRelevantTechnologiesFeedback() {
		return relevantTechnologiesFeedback;
	}
	public void setRelevantTechnologiesFeedback(CriteriaEnum relevantTechnologiesFeedback) {
		this.relevantTechnologiesFeedback = relevantTechnologiesFeedback;
	}
	public CriteriaEnum getTechnicalCommunicationFeedback() {
		return technicalCommunicationFeedback;
	}
	public void setTechnicalCommunicationFeedback(CriteriaEnum technicalCommunicationFeedback) {
		this.technicalCommunicationFeedback = technicalCommunicationFeedback;
	}
	public CriteriaEnum getMethodologyFeedback() {
		return methodologyFeedback;
	}
	public void setMethodologyFeedback(CriteriaEnum methodologyFeedback) {
		this.methodologyFeedback = methodologyFeedback;
	}
	public CriteriaEnum getCertificationsFeedback() {
		return certificationsFeedback;
	}
	public void setCertificationsFeedback(CriteriaEnum certificationsFeedback) {
		this.certificationsFeedback = certificationsFeedback;
	}
	public CriteriaEnum getProjectManagementSkillsFeedback() {
		return projectManagementSkillsFeedback;
	}
	public void setProjectManagementSkillsFeedback(CriteriaEnum projectManagementSkillsFeedback) {
		this.projectManagementSkillsFeedback = projectManagementSkillsFeedback;
	}
	public CriteriaEnum getProjectManagementToolsFeedback() {
		return projectManagementToolsFeedback;
	}
	public void setProjectManagementToolsFeedback(CriteriaEnum projectManagementToolsFeedback) {
		this.projectManagementToolsFeedback = projectManagementToolsFeedback;
	}
	public CriteriaEnum getLeadershipFeedback() {
		return leadershipFeedback;
	}
	public void setLeadershipFeedback(CriteriaEnum leadershipFeedback) {
		this.leadershipFeedback = leadershipFeedback;
	}
	public CriteriaEnum getInitiativeFeedback() {
		return initiativeFeedback;
	}
	public void setInitiativeFeedback(CriteriaEnum initiativeFeedback) {
		this.initiativeFeedback = initiativeFeedback;
	}
	public CriteriaEnum getStrengthsFeedback() {
		return strengthsFeedback;
	}
	public void setStrengthsFeedback(CriteriaEnum strengthsFeedback) {
		this.strengthsFeedback = strengthsFeedback;
	}
	public CriteriaEnum getTeamworkFeedback() {
		return teamworkFeedback;
	}
	public void setTeamworkFeedback(CriteriaEnum teamworkFeedback) {
		this.teamworkFeedback = teamworkFeedback;
	}
	public String getAdditionalNotes() {
		return additionalNotes;
	}
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}


}
