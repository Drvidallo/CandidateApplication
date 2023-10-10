package com.springboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.FeedbackService;
import com.springboot.model.Feedback;
import com.springboot.model.DTO.FeedbackDTO;


@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
	
	private final FeedbackService feedbackService;

	@Autowired
	public FeedbackController(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}
	
	@PostMapping("/post")
	public void submitFeedback(@RequestBody Feedback feedback) {
		feedbackService.submitFeedback(feedback);
	}
	
	@GetMapping(path="get/{feedbackId}")
	public List<FeedbackDTO> getFeedbackAllValues(@PathVariable("feedbackId") int id) {
		return feedbackService.getFeedbackAllValues();
	}
}
