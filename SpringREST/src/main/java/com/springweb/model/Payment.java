package com.springweb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "payment")
@EntityListeners(AuditingEntityListener.class)
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long id;
	
	
	private String cusname;
	
	
	private String payamount;
	
	
	private String proId;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCusname() {
		return cusname;
	}


	public void setCusname(String cusname) {
		this.cusname = cusname;
	}


	public String getPayamount() {
		return payamount;
	}


	public void setPayamount(String payamount) {
		this.payamount = payamount;
	}


	public String getProId() {
		return proId;
	}


	public void setProId(String proId) {
		this.proId = proId;
	}
	
	
}
