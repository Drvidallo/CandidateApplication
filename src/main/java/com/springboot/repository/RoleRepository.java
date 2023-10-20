package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Role;
import com.springboot.model.enums.RoleEnum;

public interface RoleRepository extends JpaRepository <Role, Integer>{
	Optional<Role> findByName(RoleEnum name);
}
