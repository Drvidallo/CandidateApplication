package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.referenceTable.Technology;


@Repository
public interface TechnologyRepository extends JpaRepository <Technology, Integer>{

}
