package com.springboot.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.Feedback;
import com.springboot.model.Interviewee;

@Repository
public interface IntervieweeRepository extends JpaRepository <Interviewee, Integer>{

	@Query("SELECT e FROM Interviewee e LEFT JOIN Feedback f ON e.id = f.id")
	Optional<Interviewee> findIntervieweeAllTable(@Param("id") Integer intervieweeId);
	
	
	@Query("SELECT i FROM Interviewee i WHERE i.id = :id")
	Optional<Interviewee> findIntervieweeId(@Param("id") Integer intervieweeId);
}
