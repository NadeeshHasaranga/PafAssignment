package com.springweb.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "shopping_cart")
@EntityListeners(AuditingEntityListener.class)
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long id;
	
	private String name;
	
	private String totamount;
	
	private String procount;
	
	private String discount;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTotamount() {
		return totamount;
	}

	public void setTotamount(String totamount) {
		this.totamount = totamount;
	}

	public String getProcount() {
		return procount;
	}

	public void setProcount(String procount) {
		this.procount = procount;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}


}
