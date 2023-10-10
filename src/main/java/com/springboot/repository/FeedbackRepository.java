package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.Feedback;
import com.springboot.model.enums.CriteriaEnum;


@Repository
public interface FeedbackRepository extends JpaRepository <Feedback, Integer>{
	
	
//	@Query("SELECT f.id, f.role_and_maturity, rm.name FROM Feedback f JOIN role_and_maturity rm ON f.role_and_maturity = rm.id")
//	Optional<Feedback> findFeedbackAll(@Param("id") Integer feedbackId);
	
	@Query("SELECT rm.name AS roleAndMaturity, per.name AS practiceExamResult,"
			+ " edf.name AS educationalBackgroundFeedback, r.name AS recommendation, c.name AS crCode FROM Feedback f "
			+ "JOIN RoleAndMaturity rm ON f.roleAndMaturity = rm.id "
			+ "JOIN PracticeExamResult per ON f.practiceExamResult = per.id "
			+ "JOIN Recommendation r ON f.recommendation = r.id "
			+ "JOIN CRCode c ON f.crCode = c.id "
			
			+ "JOIN Criteria edf ON f.educationalBackgroundFeedback = edf.id")
	Optional<Integer> findFeedbackAll(@Param("id") Integer feedbackId);
}


//+ "JOIN Interviewee i ON f.intervieweeId = i.id "