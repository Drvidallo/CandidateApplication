package com.springboot.model.referenceTable;


import com.springboot.model.enums.CriteriaEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "criteria")
public class Criteria {
	@Id
    private Integer id;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 20)
    private CriteriaEnum name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CriteriaEnum getName() {
		return name;
	}

	public void setName(CriteriaEnum name) {
		this.name = name;
	}
}
