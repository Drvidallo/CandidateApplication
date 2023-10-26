package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.FeedbackService;
import com.springboot.model.Feedback;
import com.springboot.model.DTO.FeedbackDTO;
import com.springboot.repository.FeedbackRepository;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

	private final FeedbackService feedbackService;

	@Autowired
	FeedbackRepository feedbackRepository;

	@Autowired
	public FeedbackController(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	@PostMapping("/post")
	public ResponseEntity<String> submitFeedback(@RequestBody Feedback feedback) {
		feedbackService.submitFeedback(feedback);

		try {
			Feedback createdFeedback = feedbackService.submitFeedback(feedback);
			return ResponseEntity.ok("Successfully Registered Feedback with ID: " + createdFeedback.getId());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Register Feedback failed: ");
		}
	}

	@GetMapping(path = "get")
	public List<FeedbackDTO> getFeedbackAllValues() {
		return feedbackService.getFeedbackAllValues();
	}

	@GetMapping(path = "get/{feedbackId}")
	public FeedbackDTO getFeedbackByCandidateId(@PathVariable("feedbackId") int id) {
		return feedbackService.getFeedbackByCandidateId(id);
	}
}
