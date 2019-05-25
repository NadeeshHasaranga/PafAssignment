package com.springweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.model.Payment;
import com.springweb.repository.PaymentRepository;


@Service
public class PaymentDAO {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	/*to add a payment */
	
	public Payment save(Payment pay) {
		return paymentRepository.save(pay);
	}
	
	/* search all payments*/
	public List<Payment> findAll(){
		return paymentRepository.findAll();
	}

	/*get a payment by id*/
	public Payment findone(Long payid) {
		return paymentRepository.findOne(payid);
	}
	
	/*delete a payment*/
	
	public void delete (Payment pay) {
		paymentRepository.delete(pay);
	}
	


}
