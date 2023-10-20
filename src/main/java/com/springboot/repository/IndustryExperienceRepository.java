package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.IndustryExperience;


@Repository
public interface IndustryExperienceRepository extends JpaRepository <IndustryExperience, Integer>{
	 List<IndustryExperience> findByCandidateId(int candidateId);
	
}
