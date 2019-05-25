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

import com.springweb.dao.ProductDAO;
import com.springweb.model.Product;

@RestController
@RequestMapping("/ecomm")
public class ProductController {

	@Autowired

	ProductDAO productDAO;

	/* to save an product */

	@PostMapping("/product")
	public Product createProduct(@Valid @RequestBody Product pro) {
		return productDAO.save(pro);
	}

	/* get all product */

	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return productDAO.findAll();
	}

	/* get product by product id*/

	@GetMapping("/specific/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long proid) {

		Product pro = productDAO.findone(proid);

		if (pro == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pro);

	}

	/*
	 * update a product 
	 * 
	 */

	@PutMapping("/specific/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long proid,
			@Valid @RequestBody Product proDetails) {

		Product pro = productDAO.findone(proid);

		if (pro == null) {
			return ResponseEntity.notFound().build();
		}

		pro.setName(proDetails.getName());
		pro.setPrice(proDetails.getPrice());
		pro.setQuantity(proDetails.getQuantity());
		pro.setCategory(proDetails.getCategory());
		pro.setBrand(proDetails.getBrand());
		//pro.setCreatedDate(proDetails.getCreatedDate());

		Product updateProduct = productDAO.save(pro);
		return ResponseEntity.ok().body(pro);

	}

	/* Delete a product by id */
	@DeleteMapping("/specific/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") Long proid) {
		Product pro = productDAO.findone(proid);

		if (pro == null) {
			return ResponseEntity.notFound().build();
		}
		productDAO.delete(pro);
		return ResponseEntity.ok().build();

	}

}
