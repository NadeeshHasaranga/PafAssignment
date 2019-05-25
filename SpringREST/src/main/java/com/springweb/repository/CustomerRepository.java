package com.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springweb.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
