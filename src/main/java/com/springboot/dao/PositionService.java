package com.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.referenceTable.Position;
import com.springboot.repository.PositionRepository;

@Service
public class PositionService {
	@Autowired
	PositionRepository positionRepository;
	
	public Iterable<Position> getAllPosition() {
		return positionRepository.findAll(); 
	}
	
	public void submitPosition(Position industry) {
		positionRepository.save(industry);
	}
}
