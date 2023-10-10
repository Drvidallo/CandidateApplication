package com.springboot.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.constants.HTTPConstants;
import com.springboot.constants.Response;

import com.springboot.dao.IntervieweeService;

import com.springboot.model.Interviewee;

@RestController
@RequestMapping("/api/interviewee")
public class IntervieweeController {
	
private final IntervieweeService interviewService;

	@Autowired
	public IntervieweeController(IntervieweeService interviewService) {
		this.interviewService = interviewService;
	}
	
	
//	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/get")
	public Iterable<Interviewee> getInterviewee(){
		
		return interviewService.getAllInterviewee();
	}
	
//	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(path="get/{intervieweeId}")
	public Optional<Interviewee> getIntervieweeById(@PathVariable("intervieweeId") int id) {
		return interviewService.getIntervieweeById(id);
	}
	 
	@PostMapping("/post")
	public ResponseEntity <Response<Void>> addInterview(@RequestBody Interviewee interviewee) {
		Response<Void> response = Response.success(HTTPConstants.SUCCESS);
        
		interviewService.submitInterviewee(interviewee);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping(path="update/{intervieweeId}")
	public void updateInterviewee(
			@PathVariable("intervieweeId") int id, @RequestBody Interviewee interviewee
			) {
		interviewService.updateInterviewee(id, interviewee);
	}
	
}
