package com.pankaj.phase3project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pankaj.phase3project.model.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {

}