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

import com.abc.onlinevegetablestore.dto.LoginResponseDTO;
import com.abc.onlinevegetablestore.exception.ResourceNotFoundException;
import com.abc.onlinevegetablestore.model.Customer;
import com.abc.onlinevegetablestore.model.LoginResponse;
import com.abc.onlinevegetablestore.repository.CustomerRepository;
import com.abc.onlinevegetablestore.repository.LoginRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api/v1")
	public class CustomerController {
		@Autowired
		private LoginRepository loginRepository;
			
		

		@Autowired
		private CustomerRepository customerRepository;
		
		// get all employees
		@GetMapping("/customers")
		public List<Customer> getAllCustomers(){
			return customerRepository.findAll();
		}		
		
		// create employee rest api
		@PostMapping("/customers")
		public Customer createCustomer(@RequestBody Customer customer) {
			return customerRepository.save(customer);
		}
		
		// get employee by id rest api
		@GetMapping("/customers/{id}")
		public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
			Customer customer = customerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
			return ResponseEntity.ok(customer);
		}
		
		// update employee rest api
		
		@PutMapping("/customers/{id}")
		public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails){
			Customer customer = customerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
			
			customer.setFirstName(customerDetails.getFirstName());
			customer.setLastName(customerDetails.getLastName());
			customer.setEmailId(customerDetails.getEmailId());
			
			Customer updatedCustomer = customerRepository.save(customer);
			return ResponseEntity.ok(updatedCustomer);
		}
		
		// delete employee rest api
		@DeleteMapping("/customers/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
			Customer customer = customerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
			
			customerRepository.delete(customer);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		@GetMapping("/login")
		public LoginResponseDTO validateUser(@PathVariable String username, @PathVariable String password){
			LoginResponse response = loginRepository.findByUsername(username);
			response.getPassword();
			LoginResponseDTO resp = new LoginResponseDTO();
			if(password.equals(response.getPassword())){
				resp.setStatus("true");
			}
		else {
			resp.setStatus("false");
		}	
			return resp;
		}
		
		
		
	}


