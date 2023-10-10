package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.referenceTable.RoleAndMaturity;

@Repository
public interface RoleAndMaturityRepository extends JpaRepository <RoleAndMaturity, Integer>{

}
