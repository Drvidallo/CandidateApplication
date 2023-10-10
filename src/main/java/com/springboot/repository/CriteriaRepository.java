package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.referenceTable.CRCode;
import com.springboot.model.referenceTable.Criteria;

public interface CriteriaRepository extends JpaRepository <Criteria, Integer>{

}
