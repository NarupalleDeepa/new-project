package com.abc.onlinevegetablestore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.onlinevegetablestore.exception.ResourceNotFoundException;
import com.abc.onlinevegetablestore.model.Vegetable;
import com.abc.onlinevegetablestore.repository.VegetableRepository;


	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api/v1/")
	public class VegetableController {
		@Autowired
		private VegetableRepository vegetableRepository; 
			
		// get all jobs
			@GetMapping("/vegetables")
			public List<Vegetable> getAllVegetables(){
				return vegetableRepository.findAll();
			}
			// create job rest api
			@PostMapping("/add")
			public String createVegetable(@RequestBody Vegetable vegetable) {
				 vegetableRepository.save(vegetable);
				 return "success";
				 
				 
			}
			// get jobs by id rest api
			@GetMapping("/vegetables/{id}")
			public ResponseEntity<Vegetable> getvegetableById(@PathVariable Long id) {
				Vegetable vegetable = vegetableRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Vegetable not exist with id :" + id));
				return ResponseEntity.ok(vegetable);
			}
			

			// update employee rest api
			
			@PutMapping("/vegetables/{id}")
			public ResponseEntity<Vegetable> updateVegetable(@PathVariable Long id, @RequestBody Vegetable vegetableDetails){
				Vegetable vegetable = vegetableRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("vegetable not exist with id :" + id));
				
				vegetable.setVegName(vegetableDetails.getVegName());
				vegetable.setVegCost(vegetableDetails.getVegCost());
				vegetable.setQuantity(vegetableDetails.getQuantity());
				vegetable.setDiscount(vegetableDetails.getDiscount());
				vegetable.setDiscountType(vegetableDetails.getDiscountType());
				
				Vegetable updatedVegetable = vegetableRepository.save(vegetable);
				return ResponseEntity.ok(updatedVegetable);
			}
			
			
			// delete employee rest api
			@DeleteMapping("/vegetables/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteVegetable(@PathVariable Long id){
				Vegetable vegetable = vegetableRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("vegetable not exist with id :" + id));
				
				vegetableRepository.delete(vegetable);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}

	}


