package com.abc.onlinevegetablestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.onlinevegetablestore.model.LoginResponse;

public interface LoginRepository extends JpaRepository<LoginResponse, Integer> {
		   LoginResponse findByUsername(String Username);
		   
		}

