package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.referenceTable.Industry;

@Repository
public interface IndustryRepository extends JpaRepository <Industry, Integer>{
	
}
