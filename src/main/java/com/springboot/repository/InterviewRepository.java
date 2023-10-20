package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.IndustryExperience;
import com.springboot.model.Interview;

@Repository
public interface InterviewRepository extends JpaRepository <Interview, Integer>{
	Interview findByCandidateId(int candidateId);
}
