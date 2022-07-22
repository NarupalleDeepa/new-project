package com.abc.onlinevegetablestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.onlinevegetablestore.model.Vegetable;

@Repository
	public interface VegetableRepository extends JpaRepository<Vegetable, Long>{

	}


