package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.referenceTable.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer>{

}
