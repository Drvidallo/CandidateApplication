package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.referenceTable.PracticeExamResult;

@Repository
public interface PracticeExamResultRepository extends JpaRepository <PracticeExamResult, Integer>{

}
