package com.springweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.model.ShoppingCart;
import com.springweb.repository.ShoppingcartRepository;



@Service
public class ShoppingcartDAO {
	
	@Autowired
	ShoppingcartRepository shoppingcartRepository;
	
	/*to save employee */
	
	public ShoppingCart save(ShoppingCart crt) {
		return shoppingcartRepository.save(crt);
	}
	
	/* search all employee*/
	public List<ShoppingCart> findAll(){
		return shoppingcartRepository.findAll();
	}

	/*get an employee by id*/
	public ShoppingCart findone(Long crtid) {
		return shoppingcartRepository.findOne(crtid);
	}
	
	/*delete an employee*/
	
	public void delete (ShoppingCart crt) {
		shoppingcartRepository.delete(crt);
	}	

}
