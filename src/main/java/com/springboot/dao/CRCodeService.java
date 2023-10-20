package com.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.referenceTable.CRCode;
import com.springboot.repository.CrCodeRepository;

@Service
public class CRCodeService {
	@Autowired
	CrCodeRepository crCodeRepository;
	
	public Iterable<CRCode> getAllCrCode() {
		return crCodeRepository.findAll(); 
	}
}
