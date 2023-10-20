package com.springboot.model.referenceTable;


import com.springboot.model.enums.PracticeExamResultEnum;
import com.springboot.model.enums.RecommendationEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "practice_exam_result")
public class PracticeExamResult {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, unique=true)
    private PracticeExamResultEnum name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PracticeExamResultEnum getName() {
		return name;
	}

	public void setName(PracticeExamResultEnum name) {
		this.name = name;
	}

}
