package com.springboot.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.Feedback;
import com.springboot.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository <Candidate, Integer>{

}
