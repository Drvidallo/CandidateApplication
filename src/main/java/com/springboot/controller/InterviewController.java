package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.InterviewService;
import com.springboot.model.Interview;
import com.springboot.model.DTO.InterviewDTO;




@RestController
@RequestMapping("/api/interview")
public class InterviewController {
	private final InterviewService interviewService;
	
	@Autowired
	public InterviewController(InterviewService interviewService) {
		this.interviewService = interviewService;
	}
	
//	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/get")
	public List<InterviewDTO> getInterview(){
		return interviewService.getInterviewAllValues();
	}
	
//	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/get/{intervieweeId}")
	public InterviewDTO getInterviewById(@PathVariable("intervieweeId") int id){
		return interviewService.getInterviewByCandidateId(id);
	}
	
	
	@PostMapping("/post")
	public void submitInterview(@RequestBody Interview interview) {
		interviewService.submitInterview(interview);
	}
}
