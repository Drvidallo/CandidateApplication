package com.springboot.model.referenceTable;

import com.springboot.model.enums.CrCodeEnum;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cr_code")
public class CRCode {

	@Id
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 2)
    private CrCodeEnum name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CrCodeEnum getName() {
		return name;
	}

	public void setName(CrCodeEnum name) {
		this.name = name;
	}
}
