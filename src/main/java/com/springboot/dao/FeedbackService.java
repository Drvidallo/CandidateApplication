package com.springboot.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Feedback;
import com.springboot.model.DTO.FeedbackDTO;
import com.springboot.model.referenceTable.RoleAndMaturity;
import com.springboot.model.referenceTable.CRCode;
import com.springboot.model.referenceTable.Criteria;
import com.springboot.model.referenceTable.Position;
import com.springboot.model.referenceTable.PracticeExamResult;
import com.springboot.model.referenceTable.Recommendation;
import com.springboot.repository.CrCodeRepository;
import com.springboot.repository.CriteriaRepository;
import com.springboot.repository.RecommendationRepository;
import com.springboot.repository.FeedbackRepository;
import com.springboot.repository.PositionRepository;
import com.springboot.repository.PracticeExamResultRepository;
import com.springboot.repository.RoleAndMaturityRepository;


@Service
public class FeedbackService {
	
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	RoleAndMaturityRepository roleAndMaturityRepository;
	
	@Autowired
	PracticeExamResultRepository practiceExamResultRepository;
	
	@Autowired
	CriteriaRepository criteriaRepository;
	
	@Autowired
	RecommendationRepository recommendationRepository;
	
	@Autowired
	CrCodeRepository crcodeRepository;
	
	@Autowired
	PositionRepository positionRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
	

	
	public void submitFeedback(Feedback feedback) {
		Integer feedbackId = feedback.getId();
		Optional <Feedback> existingFeedback = feedbackRepository.findById(feedbackId);

//        if (existingFeedback == null) {
             feedbackRepository.save(feedback);
//        } else {
//        	 throw new UnsupportedOperationException("An entity with the same unique number already exists.");
//        }
		
	}
	
	public Optional<Integer> getFeedbackAll(int feedbackId) {
		return feedbackRepository.findFeedbackAll(feedbackId);
	}
	
	
	
	public List<FeedbackDTO> getFeedbackAllValues() {
        List<Feedback> feedbackList = feedbackRepository.findAll();
        List<FeedbackDTO> feedbackWithCriteriaList = new ArrayList<>();

        for (Feedback feedback : feedbackList) {
        	
            RoleAndMaturity roleAndMaturity = roleAndMaturityRepository.findById((Integer) feedback.getRoleAndMaturity()).orElse(null);
            PracticeExamResult practiceExamResult = practiceExamResultRepository.findById((Integer) feedback.getPracticeExamResult()).orElse(null);
            Recommendation recommendation = recommendationRepository.findById((Integer) feedback.getRecommendation()).orElse(null);
            CRCode crCode = crcodeRepository.findById((Integer) feedback.getCrCode()).orElse(null);
            Position position = positionRepository.findById((Integer) feedback.getOtherQualifiedRole()).orElse(null);
            
            Criteria educationalBackgroundFeedback = criteriaRepository.findById((Integer) feedback.getEducationalBackgroundFeedback()).orElse(null);
            Criteria relevantExperienceFeedback = criteriaRepository.findById((Integer) feedback.getRelevantExperienceFeedback()).orElse(null);
            Criteria programmingLanguagesFeedback = criteriaRepository.findById((Integer) feedback.getProgrammingLanguagesFeedback()).orElse(null);
            Criteria implementationFeedback = criteriaRepository.findById((Integer) feedback.getImplementationFeedback()).orElse(null);
            Criteria testingFrameworkFeedback = criteriaRepository.findById((Integer) feedback.getTestingFrameworkFeedback()).orElse(null);
            Criteria designFeedback = criteriaRepository.findById((Integer) feedback.getDesignFeedback()).orElse(null);
            Criteria relevantTechnologiesFeedback = criteriaRepository.findById((Integer) feedback.getRelevantTechnologiesFeedback()).orElse(null);
            Criteria technicalCommunicationFeedback = criteriaRepository.findById((Integer) feedback.getTechnicalCommunicationFeedback()).orElse(null);
            Criteria methodologyFeedback = criteriaRepository.findById((Integer) feedback.getMethodologyFeedback()).orElse(null);
            Criteria certificationsFeedback = criteriaRepository.findById((Integer) feedback.getCertificationsFeedback()).orElse(null);
            Criteria projectManagementSkillsFeedback = criteriaRepository.findById((Integer) feedback.getProjectManagementToolsFeedback()).orElse(null);
            Criteria projectManagementToolsFeedback = criteriaRepository.findById((Integer) feedback.getProjectManagementToolsFeedback()).orElse(null);
            Criteria leadershipFeedback = criteriaRepository.findById((Integer) feedback.getLeadershipFeedback()).orElse(null);
            Criteria initiativeFeedback = criteriaRepository.findById((Integer) feedback.getInitiativeFeedback()).orElse(null);
            Criteria strengthsFeedback = criteriaRepository.findById((Integer) feedback.getStrengthsFeedback()).orElse(null);
            Criteria teamworkFeedback = criteriaRepository.findById((Integer) feedback.getTeamworkFeedback()).orElse(null);
            
        	

            if (roleAndMaturity != null && practiceExamResult != null) {
            	
            	
            	FeedbackDTO feedbackWithCriteria = new FeedbackDTO();
                feedbackWithCriteria.setId(feedback.getId());
                feedbackWithCriteria.setRoleAndMaturity(roleAndMaturity.getName());
                feedbackWithCriteria.setPracticeExamResult(practiceExamResult.getName());
                feedbackWithCriteria.setRecommendation(recommendation.getName());
                feedbackWithCriteria.setCrCode(crCode.getName());
                feedbackWithCriteria.setCandidateId(feedback.getCandidateId());
                feedbackWithCriteria.setAdditionalNotes(feedback.getAdditionalNotes());
                feedbackWithCriteria.setOtherQualifiedRole(position.getName());
                
                
                
                feedbackWithCriteria.setEducationalBackgroundFeedback(educationalBackgroundFeedback.getName());
                feedbackWithCriteria.setRelevantExperienceFeedback(relevantExperienceFeedback.getName());
                feedbackWithCriteria.setProgrammingLanguagesFeedback(programmingLanguagesFeedback.getName());
                feedbackWithCriteria.setImplementationFeedback(implementationFeedback.getName());
                feedbackWithCriteria.setTestingFrameworkFeedback(testingFrameworkFeedback.getName());
                feedbackWithCriteria.setDesignFeedback(designFeedback.getName());
                feedbackWithCriteria.setRelevantTechnologiesFeedback(relevantTechnologiesFeedback.getName());
                feedbackWithCriteria.setTechnicalCommunicationFeedback(technicalCommunicationFeedback.getName());
                feedbackWithCriteria.setMethodologyFeedback(methodologyFeedback.getName());
                feedbackWithCriteria.setCertificationsFeedback(certificationsFeedback.getName());
                feedbackWithCriteria.setProjectManagementSkillsFeedback(projectManagementSkillsFeedback.getName());
                feedbackWithCriteria.setProjectManagementToolsFeedback(projectManagementToolsFeedback.getName());
                feedbackWithCriteria.setLeadershipFeedback(leadershipFeedback.getName());
                feedbackWithCriteria.setInitiativeFeedback(initiativeFeedback.getName());
                feedbackWithCriteria.setStrengthsFeedback(strengthsFeedback.getName());
                feedbackWithCriteria.setTeamworkFeedback(teamworkFeedback.getName());
                
                
                
                feedbackWithCriteriaList.add(feedbackWithCriteria);
            }
        
            
            
        }

        return feedbackWithCriteriaList;
    }
	
	public FeedbackDTO getFeedbackByCandidateId(int feedbackId) {
		Feedback feedback = feedbackRepository.findByCandidateId(feedbackId);
		FeedbackDTO feedbackWithCriteria = new FeedbackDTO();
		
		
        RoleAndMaturity roleAndMaturity = roleAndMaturityRepository.findById((Integer) feedback.getRoleAndMaturity()).orElse(null);
        PracticeExamResult practiceExamResult = practiceExamResultRepository.findById((Integer) feedback.getPracticeExamResult()).orElse(null);
        Recommendation recommendation = recommendationRepository.findById((Integer) feedback.getRecommendation()).orElse(null);
        CRCode crCode = crcodeRepository.findById((Integer) feedback.getCrCode()).orElse(null);
        Position position = positionRepository.findById((Integer) feedback.getOtherQualifiedRole()).orElse(null);
        
        Criteria educationalBackgroundFeedback = criteriaRepository.findById((Integer) feedback.getEducationalBackgroundFeedback()).orElse(null);
        Criteria relevantExperienceFeedback = criteriaRepository.findById((Integer) feedback.getRelevantExperienceFeedback()).orElse(null);
        Criteria programmingLanguagesFeedback = criteriaRepository.findById((Integer) feedback.getProgrammingLanguagesFeedback()).orElse(null);
        Criteria implementationFeedback = criteriaRepository.findById((Integer) feedback.getImplementationFeedback()).orElse(null);
        Criteria testingFrameworkFeedback = criteriaRepository.findById((Integer) feedback.getTestingFrameworkFeedback()).orElse(null);
        Criteria designFeedback = criteriaRepository.findById((Integer) feedback.getDesignFeedback()).orElse(null);
        Criteria relevantTechnologiesFeedback = criteriaRepository.findById((Integer) feedback.getRelevantTechnologiesFeedback()).orElse(null);
        Criteria technicalCommunicationFeedback = criteriaRepository.findById((Integer) feedback.getTechnicalCommunicationFeedback()).orElse(null);
        Criteria methodologyFeedback = criteriaRepository.findById((Integer) feedback.getMethodologyFeedback()).orElse(null);
        Criteria certificationsFeedback = criteriaRepository.findById((Integer) feedback.getCertificationsFeedback()).orElse(null);
        Criteria projectManagementSkillsFeedback = criteriaRepository.findById((Integer) feedback.getProjectManagementToolsFeedback()).orElse(null);
        Criteria projectManagementToolsFeedback = criteriaRepository.findById((Integer) feedback.getProjectManagementToolsFeedback()).orElse(null);
        Criteria leadershipFeedback = criteriaRepository.findById((Integer) feedback.getLeadershipFeedback()).orElse(null);
        Criteria initiativeFeedback = criteriaRepository.findById((Integer) feedback.getInitiativeFeedback()).orElse(null);
        Criteria strengthsFeedback = criteriaRepository.findById((Integer) feedback.getStrengthsFeedback()).orElse(null);
        Criteria teamworkFeedback = criteriaRepository.findById((Integer) feedback.getTeamworkFeedback()).orElse(null);
        
    	

        if (roleAndMaturity != null && practiceExamResult != null && recommendation != null && crCode != null && position != null && educationalBackgroundFeedback != null ) {

            feedbackWithCriteria.setId(feedback.getId());
            feedbackWithCriteria.setRoleAndMaturity(roleAndMaturity.getName());
            feedbackWithCriteria.setPracticeExamResult(practiceExamResult.getName());
            feedbackWithCriteria.setRecommendation(recommendation.getName());
            feedbackWithCriteria.setCrCode(crCode.getName());
            feedbackWithCriteria.setCandidateId(feedback.getCandidateId());
            feedbackWithCriteria.setAdditionalNotes(feedback.getAdditionalNotes());
            feedbackWithCriteria.setOtherQualifiedRole(position.getName());

            feedbackWithCriteria.setEducationalBackgroundFeedback(educationalBackgroundFeedback.getName());
            feedbackWithCriteria.setRelevantExperienceFeedback(relevantExperienceFeedback.getName());
            feedbackWithCriteria.setProgrammingLanguagesFeedback(programmingLanguagesFeedback.getName());
            feedbackWithCriteria.setImplementationFeedback(implementationFeedback.getName());
            feedbackWithCriteria.setTestingFrameworkFeedback(testingFrameworkFeedback.getName());
            feedbackWithCriteria.setDesignFeedback(designFeedback.getName());
            feedbackWithCriteria.setRelevantTechnologiesFeedback(relevantTechnologiesFeedback.getName());
            feedbackWithCriteria.setTechnicalCommunicationFeedback(technicalCommunicationFeedback.getName());
            feedbackWithCriteria.setMethodologyFeedback(methodologyFeedback.getName());
            feedbackWithCriteria.setCertificationsFeedback(certificationsFeedback.getName());
            feedbackWithCriteria.setProjectManagementSkillsFeedback(projectManagementSkillsFeedback.getName());
            feedbackWithCriteria.setProjectManagementToolsFeedback(projectManagementToolsFeedback.getName());
            feedbackWithCriteria.setLeadershipFeedback(leadershipFeedback.getName());
            feedbackWithCriteria.setInitiativeFeedback(initiativeFeedback.getName());
            feedbackWithCriteria.setStrengthsFeedback(strengthsFeedback.getName());
            feedbackWithCriteria.setTeamworkFeedback(teamworkFeedback.getName());
            

        }
		return feedbackWithCriteria;
        
        
	}
}
