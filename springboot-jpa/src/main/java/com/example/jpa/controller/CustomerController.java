package com.example.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.datamodel.Customer;
import com.example.jpa.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		try {
			return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/createCustomers")
	public ResponseEntity<HttpStatus> createAllCustomer(@RequestBody List<Customer> customers) {
		customerService.createAllCustomer(customers);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/findCustomerbyIdAndName/{id}/{name}")
	public ResponseEntity<List<Customer>> findCustomerByIdAndName(@PathVariable Long id,@PathVariable String name) {
		List<Customer> customers = customerService.findCustomerByIdAndName(id, name);
		if (customers.isEmpty() || customers.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping("/findCustomerByNameContaining/{exp}")
	public ResponseEntity<List<Customer>> findCustomerNameContaining(@PathVariable String exp){
		List<Customer> customers = customerService.findCustomerNameContaining(exp);
		if (customers.isEmpty() || customers.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/findCustomerByAge/{age}")
	public ResponseEntity<List<Customer>> findByAgeGreaterThan(@PathVariable Long age ){
		List<Customer> customers = customerService.findByAgeGreaterThan(age);
		if (customers.isEmpty() || customers.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Customer>> findAllCustomer(){
		List<Customer> customers = customerService.findAllCustomer();
		if (customers.isEmpty() || customers.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public HttpStatus deleteCustomer(@PathVariable Long id){
		customerService.deleteCustomer(id);
		return HttpStatus.OK;
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		return ResponseEntity.ok().body(customerService.updateCustomer(customer));
	}


}
