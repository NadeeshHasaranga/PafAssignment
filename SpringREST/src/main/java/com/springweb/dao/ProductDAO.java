package com.springweb.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.model.Product;
import com.springweb.repository.ProductRepository;


@Service
public class ProductDAO {
	
	@Autowired
	ProductRepository productRepository;
	
	/*to save employee */
	
	public Product save(Product pro) {
		return productRepository.save(pro);
	}
	
	/* search all employee*/
	public List<Product> findAll(){
		return productRepository.findAll();
	}

	/*get an employee by id*/
	public Product findone(Long proid) {
		return productRepository.findOne(proid);
	}
	
	/*delete an employee*/
	
	public void delete (Product pro) {
		productRepository.delete(pro);
	}
	
	
	

}
