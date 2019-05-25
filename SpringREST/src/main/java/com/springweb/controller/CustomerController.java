package com.springweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springweb.dao.CustomerDAO;
import com.springweb.model.Customer;


@RestController
@RequestMapping("/ecommercecus")
public class CustomerController {
	
	
	@Autowired

	CustomerDAO customerDAO;

	/* to save a customer */

	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody Customer cus) {
		return customerDAO.save(cus);
	}

	/* get all customers */

	@GetMapping("/customer")
	public List<Customer> getAllCustomers() {
		return customerDAO.findAll();
	}

	/* get customer by cusid */

	@GetMapping("/specific/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long cusid) {

		Customer cus = customerDAO.findone(cusid);

		if (cus == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(cus);

	}

	/*
	 * update a customer by cusid
	 * 
	 */

	@PutMapping("/specific/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long cusid,@Valid @RequestBody Customer cusDetails) {

		Customer cus = customerDAO.findone(cusid);

		if (cus == null) {
			return ResponseEntity.notFound().build();
		}

		
		  cus.setName(cusDetails.getName());
		  cus.setUsername(cusDetails.getUsername());
		  cus.setEmail(cusDetails.getEmail());
		  cus.setMobile(cusDetails.getMobile());
		  cus.setAddress(cusDetails.getAddress());
		 
		Customer updateCustomer = customerDAO.save(cus);
		return ResponseEntity.ok().body(cus);

	}

	/* Delete a customer */
	@DeleteMapping("/specific/{id}")
	public ResponseEntity<Customer> deleteEmployee(@PathVariable(value = "id") Long cusid) {
		Customer cus = customerDAO.findone(cusid);

		if (cus == null) {
			return ResponseEntity.notFound().build();
		}
		customerDAO.delete(cus);
		return ResponseEntity.ok().build();

	}

}
