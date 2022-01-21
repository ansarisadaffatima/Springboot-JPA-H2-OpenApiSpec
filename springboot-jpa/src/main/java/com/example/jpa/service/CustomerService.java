package com.example.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.datamodel.Customer;
import com.example.jpa.exception.CustomerNotFoundException;
import com.example.jpa.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void createAllCustomer(List<Customer> customers) {
		customerRepository.saveAll(customers);
	}
	
	public List<Customer> findCustomerByIdAndName(Long id,String name) {
		return customerRepository.findByIdAndName(id, name);
	}

	public List<Customer> findCustomerNameContaining(String exp){
		return customerRepository.findByNameContaining(exp);
	}
	
	public List<Customer> findAllCustomer(){
		return customerRepository.findAll();
	}
	
	public List<Customer> findByAgeGreaterThan(Long age){
		return customerRepository.findByAgeGreaterThan(age);
	}
	
	public void deleteCustomer(Long id){
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			customerRepository.delete(customer.get());
		}else {
            throw new CustomerNotFoundException("Customer not found with id : " + id);
        }
			
	}
	
	public Customer updateCustomer(Customer customer){
		Optional<Customer> isCustomer = customerRepository.findById(customer.getId());
		if(isCustomer.isPresent()) {
			Customer existingCustomer = isCustomer.get();
			existingCustomer.setAge(customer.getAge());
			existingCustomer.setName(customer.getName());
			existingCustomer.setLocation(customer.getLocation());
			customerRepository.save(existingCustomer);
			return existingCustomer;
		}else {
            throw new CustomerNotFoundException("Customer not found with id : " + customer.getId());
        }			
	}

}
