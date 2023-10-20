package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.referenceTable.Recommendation;



@Repository
public interface RecommendationRepository extends JpaRepository <Recommendation, Integer>{

}
