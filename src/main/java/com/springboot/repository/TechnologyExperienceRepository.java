package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.TechnologyExperience;

@Repository
public interface TechnologyExperienceRepository extends JpaRepository <TechnologyExperience, Integer>{

}
