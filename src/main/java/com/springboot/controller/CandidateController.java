package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.springboot.constants.HTTPConstants;
import com.springboot.dao.CandidateService;
import com.springboot.errorhandling.ErrorResponse;
import com.springboot.model.Candidate;
import jakarta.validation.Valid;
import com.springboot.model.DTO.CandidateDTO;

@Validated
@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
	
private final CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/get")
	public Iterable<Candidate> getAllCandidate(){
		
		return candidateService.getAllCandidate();
	}
	
	@GetMapping("/get/all")
	public List<CandidateDTO> getAllCandidateDetails(){
		
		return candidateService.getAllCandidateDetails();
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(path="get/{candidateId}")
	public Candidate getCandidateById(@PathVariable("candidateId") int id) {
//		  try {
	            return candidateService.getCandidateById(id);
//	        } catch (EntityNotFoundException ex) {
//	        	throw new ResourceCreationException("invalid parameter", "400", "The request parameter is invalid");// Handle the entity not found situation
//	        }
	}
	
	@GetMapping(path="get/{candidateId}/all")
	public ResponseEntity<?> getCandidateByIdAllDetails(@PathVariable("candidateId") int id) {
		CandidateDTO candidate = candidateService.getCandidateByIdAllDetails(id);
		
		if(candidate.getId() == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setCode(HTTPConstants.HTTP_CODE_INVALID_PARAMETER);
            errorResponse.setMessage(HTTPConstants.HTTP_MESSAGE_BAD_REQUEST);
            errorResponse.setDetails(HTTPConstants.HTTP_DETAIL_BAD_REQUEST);
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(candidate, HttpStatus.OK);
		}
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@PostMapping("/add")
	public ResponseEntity <String> addCandidate(@Valid @RequestBody Candidate candidate) {
	
		try {
			Candidate createdCandidate = candidateService.submitCandidate(candidate);
			return ResponseEntity.ok("Successfully Registered Candidate with ID: " + createdCandidate.getId());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Register Candidate failed: " );
		}

	}
	
	@PutMapping(path="update/{candidateId}")
	public void updateInterviewee(
			@PathVariable("candidateId") int id, @RequestBody Candidate candidate
			) {
		candidateService.updateCandidate(id, candidate);
	}
	
}
