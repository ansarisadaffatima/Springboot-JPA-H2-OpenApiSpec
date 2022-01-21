package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.datamodel.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByIdAndName(Long id,String name);
	List<Customer> findByNameContaining(String exp);
	List<Customer> findByAgeGreaterThan(Long age);
}
