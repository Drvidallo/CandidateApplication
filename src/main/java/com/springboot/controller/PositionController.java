package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.PositionService;
import com.springboot.model.referenceTable.Position;

@RestController
@RequestMapping("/api/position")
public class PositionController {
	private final PositionService positionService;

	@Autowired
	public PositionController(PositionService positionService) {
		this.positionService = positionService;
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(path = "/get")
	public Iterable<Position> getPositionAll() {
		return positionService.getAllPosition();
	}

	@PostMapping("/post")
	public void submitPosition(@RequestBody Position position) {
		positionService.submitPosition(position);
	}
}
