package com.pankaj.phase3project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pankaj.phase3project.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findUserByEmail(String email);

	
}
