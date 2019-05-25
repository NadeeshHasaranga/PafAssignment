package com.springweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.model.Customer;
import com.springweb.repository.CustomerRepository;


@Service
public class CustomerDAO {
	

	@Autowired
	CustomerRepository customerRepository;
	
	/*to save customer */
	
	public Customer save(Customer cus) {
		return customerRepository.save(cus);
	}
	
	/* search all customers*/
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

	/*get an customer by id*/
	public Customer findone(Long cusid) {
		return customerRepository.findOne(cusid);
	}
	
	/*delete a customer*/
	
	public void delete (Customer cus) {
		customerRepository.delete(cus);
	}
	
	
	


}
