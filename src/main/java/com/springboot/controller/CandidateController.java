package com.springboot.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.constants.HTTPConstants;
import com.springboot.constants.Response;

import com.springboot.dao.CandidateService;

import com.springboot.model.Candidate;
import com.springboot.model.DTO.FeedbackDTO;

import jakarta.validation.Valid;

import com.springboot.model.DTO.ExperienceDTO;
import com.springboot.model.DTO.CandidateDTO;

@Validated
@RestController
@RequestMapping("/api/interviewee")
public class CandidateController {
	
private final CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	
//	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/get")
	public Iterable<Candidate> getAllCandidate(){
		
		return candidateService.getAllCandidate();
	}
	
	@GetMapping("/get/all")
	public List<CandidateDTO> getAllCandidateDetails(){
		
		return candidateService.getAllCandidateDetails();
	}
	
//	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(path="get/{candidateId}")
	public Optional<Candidate> getCandidateById(@PathVariable("candidateId") int id) {
		return candidateService.getCandidateById(id);
	}
	
	 
	@PostMapping("/post")
	public ResponseEntity <String> addCandidate(@Valid @RequestBody Candidate candidate) {
	
		try {
			Candidate createdCandidate = candidateService.submitCandidate(candidate);
			return ResponseEntity.ok("Resource created with ID: " + createdCandidate.getId());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Resource creation failed: " );
		}
	
	
//		 return ResponseEntity.ok("Resource created with ID: " + createdResource.getId());
//		Response<Void> response = Response.success(HTTPConstants.SUCCESS);
        
		
//		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping(path="update/{candidateId}")
	public void updateInterviewee(
			@PathVariable("candidateId") int id, @RequestBody Candidate candidate
			) {
		candidateService.updateCandidate(id, candidate);
	}
	
}
