package com.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springweb.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	

}
