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

import com.springweb.dao.PaymentDAO;
import com.springweb.model.Payment;


@RestController
@RequestMapping("/ecommercepay")
public class PaymentController {
	
	@Autowired

	PaymentDAO paymentDAO;

	/* to save a payment */

	@PostMapping("/payment")
	public Payment createPayment(@Valid @RequestBody Payment pay) {
		return paymentDAO.save(pay);
	}

	/* get all payments */

	@GetMapping("/payment")
	public List<Payment> getAllPayments() {
		return paymentDAO.findAll();
	}

	/* get product by paymentid */

	@GetMapping("/payment/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value = "id") Long payid) {

		Payment pay = paymentDAO.findone(payid);

		if (pay == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pay);

	}

	/*
	 * update an payment by paymentid
	 * 
	 */

	@PutMapping("/payment/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable(value = "id") Long payid,
			@Valid @RequestBody Payment payDetails) {

		Payment pay = paymentDAO.findone(payid);

		if (pay == null) {
			return ResponseEntity.notFound().build();
		}
		
		  pay.setCusname(payDetails.getCusname());
		  pay.setPayamount(payDetails.getPayamount());
		  pay.setProId(payDetails.getProId());
		  
		Payment updatePayment = paymentDAO.save(pay);
		return ResponseEntity.ok().body(pay);

	}

	/* Delete a payment */
	@DeleteMapping("/payment/{id}")
	public ResponseEntity<Payment> deletePayment(@PathVariable(value = "id") Long payid) {
		Payment pay = paymentDAO.findone(payid);

		if (pay == null) {
			return ResponseEntity.notFound().build();
		}
		paymentDAO.delete(pay);
		return ResponseEntity.ok().build();

	}
	
}
