package com.springboot.model.referenceTable;

import com.springboot.model.enums.RecommendationEnum;
import com.springboot.model.enums.RoleAndMaturityEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roleAndMaturity")
public class RoleAndMaturity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleAndMaturityEnum name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoleAndMaturityEnum getName() {
		return name;
	}

	public void setName(RoleAndMaturityEnum name) {
		this.name = name;
	}
}
